package com.jnx.springboot.common.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jnx.springboot.common.entity.Order;
import com.jnx.springboot.common.mapper.OrderMapper;
import com.jnx.springboot.common.service.OrderService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 订单信息表 服务实现类
 * </p>
 *
 * @author 蒋楠鑫
 * @since 2020-05-15
 */
@Service
public class OrderServiceImpl extends ServiceImpl<OrderMapper, Order> implements OrderService {

}
