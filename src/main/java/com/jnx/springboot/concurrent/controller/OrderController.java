package com.jnx.springboot.concurrent.controller;

import com.jnx.springboot.common.exception.ExceptionConstant;
import com.jnx.springboot.common.message.Result;
import com.jnx.springboot.concurrent.form.OrderDeatilForm;
import com.jnx.springboot.concurrent.form.OrderStatusForm;
import com.jnx.springboot.concurrent.service.OrderInfoService;
import com.jnx.springboot.concurrent.vo.OrderInfoVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 订单模块控制器
 *
 * @author 蒋楠鑫
 * @date 2020/5/15
 */
@RequestMapping("order")
@Api(tags = "订单模块控制器")
@RestController
@Validated
public class OrderController {

	/**
	 * 订单信息私有业务层
	 */
	@Autowired
	private OrderInfoService orderInfoService;

	@ApiOperation("保存订单信息")
	@PostMapping("saveOrderInfo")
	public Result<String> saveOrderInfo(@RequestBody List<OrderDeatilForm> orderDeatilFormList) {
		// 非空判断
		if (CollectionUtils.isEmpty(orderDeatilFormList)) {
			throw ExceptionConstant.ORDER_DETAIL_EMPTY;
		}
		orderInfoService.saveOrderInfo(orderDeatilFormList);
		return Result.ok("订单信息保存成功！");
	}

	@ApiOperation("修改订单状态")
	@PutMapping("updateOrderStatus")
	public Result<String> updateOrderStatus(@RequestBody OrderStatusForm orderStatusForm) {
		orderInfoService.updateOrderStatus(orderStatusForm);
		return Result.ok("订单状态修改成功！");
	}

	@ApiOperation("获取所有的订单信息")
	@GetMapping("getOrderInfo")
	public Result<List<OrderInfoVO>> getOrderInfo() {
		return Result.ok(orderInfoService.getOrderInfo());
	}
}


