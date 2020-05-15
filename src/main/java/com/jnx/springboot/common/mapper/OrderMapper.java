package com.jnx.springboot.common.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jnx.springboot.common.entity.Order;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 订单信息表 Mapper 接口
 * </p>
 *
 * @author 蒋楠鑫
 * @since 2020-05-15
 */
@Mapper
public interface OrderMapper extends BaseMapper<Order> {

}
