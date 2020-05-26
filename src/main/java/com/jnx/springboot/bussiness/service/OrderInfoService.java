package com.jnx.springboot.bussiness.service;

import com.jnx.springboot.bussiness.form.OrderDeatilForm;
import com.jnx.springboot.bussiness.form.OrderStatusForm;
import com.jnx.springboot.bussiness.vo.OrderInfoVO;

import java.util.List;

/**
 * 订单模块业务逻辑层接口
 *
 * @author 蒋楠鑫
 * @date 2020/5/15
 */
public interface OrderInfoService {

	/**
	 * 保存订单信息
	 *
	 * @param orderDeatilFormList 订单明细信息集合
	 */
	void saveOrderInfo(List<OrderDeatilForm> orderDeatilFormList);

	/**
	 * 修改订单状态
	 *
	 * @param orderStatusForm 订单信息
	 */
	void updateOrderStatus(OrderStatusForm orderStatusForm);

	/**
	 * 获取所有的订单信息
	 *
	 * @return 订单信息集合
	 */
	List<OrderInfoVO> getOrderInfo();
}
