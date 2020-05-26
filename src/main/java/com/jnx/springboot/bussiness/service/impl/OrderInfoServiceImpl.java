package com.jnx.springboot.bussiness.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.jnx.springboot.common.entity.Order;
import com.jnx.springboot.common.entity.OrderDetail;
import com.jnx.springboot.common.entity.Product;
import com.jnx.springboot.common.exception.BussinessException;
import com.jnx.springboot.common.exception.ExceptionConstant;
import com.jnx.springboot.common.mapper.OrderDetailMapper;
import com.jnx.springboot.common.mapper.OrderMapper;
import com.jnx.springboot.common.mapper.ProductMapper;
import com.jnx.springboot.bussiness.constant.OrderStatusEnum;
import com.jnx.springboot.bussiness.form.OrderDeatilForm;
import com.jnx.springboot.bussiness.form.OrderStatusForm;
import com.jnx.springboot.bussiness.service.OrderInfoService;
import com.jnx.springboot.bussiness.vo.OrderDetailVO;
import com.jnx.springboot.bussiness.vo.OrderInfoVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * 订单模块业务逻辑层实现类
 *
 * @author 蒋楠鑫
 * @date 2020/5/15
 */
@Service
public class OrderInfoServiceImpl implements OrderInfoService {

	/**
	 * 自定义常量 --- 空集合长度
	 */
	private static final int EMPTY_LIST_SIZE = 0;

	/**
	 * 商品信息公共数据层
	 */
	@Autowired
	private ProductMapper productMapper;

	/**
	 * 订单信息公共数据层
	 */
	@Autowired
	private OrderMapper orderMapper;

	/**
	 * 订单明细公共数据层
	 */
	@Autowired
	private OrderDetailMapper orderDetailMapper;

	/**
	 * 保存订单信息
	 *
	 * @param orderDeatilFormList 订单明细信息集合
	 */
	@Override
	@Transactional(rollbackFor = Exception.class)
	public void saveOrderInfo(List<OrderDeatilForm> orderDeatilFormList) {
		// 先获取商品信息
		Set<String> productNoSet = orderDeatilFormList.stream().map(
				OrderDeatilForm::getProductNo).collect(Collectors.toSet());
		QueryWrapper<Product> productWrapper = new QueryWrapper<>();
		productWrapper.in("productNo", productNoSet);
		List<Product> productList = productMapper.selectList(productWrapper);
		// 非空判断
		if (CollectionUtils.isEmpty(productList)) {
			throw new BussinessException(ExceptionConstant.PRODUCT_NO_ERROR.getCode(),
					"不存在商品号为" + orderDeatilFormList.get(0).getProductNo() + "的商品，请检查商品号！");
		}
		// 按照商品号分组
		Map<String, Product> productMap = productList.stream().collect(
				Collectors.toMap(Product::getProductNo, Function.identity()));
		// 一次添加操作就是一张订单
		String orderNo = UUID.randomUUID().toString().replace("-", "");
		LocalDateTime now = LocalDateTime.now();
		// 合计数量和合计金额
		long allNumber = 0L;
		long allAmount = 0L;
		// 生成订单明细集合
		for (OrderDeatilForm orderDeatilForm : orderDeatilFormList) {
			// 获取对应的商品信息
			Product product = productMap.get(orderDeatilForm.getProductNo());
			if (product == null) {
				throw new BussinessException(ExceptionConstant.PRODUCT_NO_ERROR.getCode(),
						"不存在商品号为" + orderDeatilForm.getProductNo() + "的商品，请检查商品号！");
			}
			// 判断数量
			if (product.getNumber() < orderDeatilForm.getNumber()) {
				throw new BussinessException(ExceptionConstant.PRODUCT_NUMBER_LACK.getCode(),
						"商品" + product.getName() + "库存不足，请修改数量");
			}
			long amount = orderDeatilForm.getNumber() * product.getPrice();
			allNumber += orderDeatilForm.getNumber();
			allAmount += amount;
			// 封装成订单明细对象
			OrderDetail orderDetail = new OrderDetail();
			orderDetail.setProductNo(product.getProductNo()).setOrderNo(orderNo).setCreated(now)
					.setNumber(orderDeatilForm.getNumber()).setPrice(product.getPrice())
					.setAmount(amount).setProductName(product.getName());
			orderDetailMapper.insert(orderDetail);
			// 扣减库存
			product.setNumber(product.getNumber() - orderDeatilForm.getNumber());
			productMapper.updateById(product);
		}
		// 支付单信息
		Order order = new Order();
		DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		order.setOrderNo(orderNo).setAmount(allAmount).setNumber(allNumber).setCreate(now)
				.setOrderTime(timeFormatter.format(now)).setStatus(OrderStatusEnum.NOT_PAY.getCode());
		orderMapper.insert(order);
	}

	/**
	 * 修改订单状态
	 *
	 * @param orderStatusForm 订单信息
	 */
	@Override
	public void updateOrderStatus(OrderStatusForm orderStatusForm) {
		// 根据订单号获取订单信息
		QueryWrapper<Order> wrapper = new QueryWrapper<>();
		wrapper.eq("orderNo", orderStatusForm.getOrderNo());
		Order order = orderMapper.selectOne(wrapper);
		// 非空判断
		if (order == null) {
			throw ExceptionConstant.ORDER_NO_ERROR;
		}
		order.setStatus(orderStatusForm.getStatus().getCode());
		orderMapper.updateById(order);
	}

	/**
	 * 获取所有的订单信息
	 *
	 * @return 订单信息集合
	 */
	@Override
	public List<OrderInfoVO> getOrderInfo() {
		// 过滤已删除的订单
		QueryWrapper<Order> orderWrapper = new QueryWrapper<>();
		orderWrapper.ne("status", OrderStatusEnum.DELETE.getCode());
		List<Order> orderList = orderMapper.selectList(orderWrapper);
		// 非空判断
		if (CollectionUtils.isEmpty(orderList)) {
			return new ArrayList<>(EMPTY_LIST_SIZE);
		}
		// 查询对应的订单明细
		List<String> orderNoList = orderList.stream().map(Order::getOrderNo).collect(Collectors.toList());
		QueryWrapper<OrderDetail> orderDetailWrapper = new QueryWrapper<>();
		orderDetailWrapper.in("orderNo", orderNoList);
		List<OrderDetail> orderDetailList = orderDetailMapper.selectList(orderDetailWrapper);
		Map<String, List<OrderDetail>> map = orderDetailList.stream().collect(
				Collectors.groupingBy(OrderDetail::getOrderNo));
		// 封装成VO对象
		List<OrderInfoVO> list = new ArrayList<>(orderList.size());
		for (Order order : orderList) {
			// 获取对应的订单明细集合
			List<OrderDetail> detailList = map.get(order.getOrderNo());
			List<OrderDetailVO> orderDetailVOList = new ArrayList<>(detailList.size());
			for (OrderDetail orderDetail : detailList) {
				OrderDetailVO orderDetailVO = new OrderDetailVO();
				BeanUtil.copyProperties(orderDetail, orderDetailVO);
				orderDetailVOList.add(orderDetailVO);
			}
			// 订单信息
			OrderInfoVO orderInfoVO = new OrderInfoVO();
			BeanUtil.copyProperties(order, orderInfoVO);
			// 状态转成中文
			orderInfoVO.setStatus(OrderStatusEnum.getValue(order.getStatus())).setDetailVOList(orderDetailVOList);
			list.add(orderInfoVO);
		}
		return list;
	}
}
