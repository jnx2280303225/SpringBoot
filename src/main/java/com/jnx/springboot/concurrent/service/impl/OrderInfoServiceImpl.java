package com.jnx.springboot.concurrent.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.jnx.springboot.common.entity.OrderDetail;
import com.jnx.springboot.common.entity.Product;
import com.jnx.springboot.common.exception.ExceptionConstant;
import com.jnx.springboot.common.mapper.OrderDetailMapper;
import com.jnx.springboot.common.mapper.OrderMapper;
import com.jnx.springboot.common.mapper.ProductMapper;
import com.jnx.springboot.concurrent.form.OrderDeatilForm;
import com.jnx.springboot.concurrent.service.OrderInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

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
			ExceptionConstant.PRODUCT_NO_ERROR.setMessage("不存在商品号为" + orderDeatilFormList.get(0).getProductNo()
					+ "的商品，请检查商品号！");
			throw ExceptionConstant.PRODUCT_NO_ERROR;
		}
		// 按照商品号分组
		Map<String, Product> productMap = productList.stream().collect(
				Collectors.toMap(Product::getProductNo, Function.identity()));
		// 一次添加操作就是一张订单
		String orderNo = UUID.randomUUID().toString().replace("-", "");
		// 合计数量和合计金额
		long allNumber = 0L;
		long allAmount = 0L;
		// 生成订单明细集合
		List<OrderDetail> orderDetailList = new ArrayList<>(orderDeatilFormList.size());
		for (OrderDeatilForm orderDeatilForm : orderDeatilFormList) {
			// 获取对应的商品信息
			Product product = productMap.get(orderDeatilForm.getProductNo());
			if (product == null) {
				ExceptionConstant.PRODUCT_NO_ERROR.setMessage("不存在商品号为" + orderDeatilForm.getProductNo()
						+ "的商品，请检查商品号！");
				throw ExceptionConstant.PRODUCT_NO_ERROR;
			}
			long amount = orderDeatilForm.getNumber() * product.getPrice();
			allNumber += orderDeatilForm.getNumber();
			allAmount += amount;
			// 封装成订单明细对象
			OrderDetail orderDetail = new OrderDetail();
			orderDetail.setProductNo(product.getProductNo());
			orderDetailList.add(orderDetail);
		}


	}
}
