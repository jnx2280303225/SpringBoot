package com.jnx.springboot.common.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jnx.springboot.common.entity.OrderDetail;
import com.jnx.springboot.common.mapper.OrderDetailMapper;
import com.jnx.springboot.common.service.OrderDetailService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 订单明细表 服务实现类
 * </p>
 *
 * @author 蒋楠鑫
 * @since 2020-05-15
 */
@Service
public class OrderDetailServiceImpl extends ServiceImpl<OrderDetailMapper, OrderDetail> implements OrderDetailService {

}
