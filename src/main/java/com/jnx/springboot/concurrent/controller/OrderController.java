package com.jnx.springboot.concurrent.controller;

import io.swagger.annotations.Api;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}


