package com.jnx.springboot.concurrent.service;

import com.jnx.springboot.concurrent.form.OrderDeatilForm;

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
}
