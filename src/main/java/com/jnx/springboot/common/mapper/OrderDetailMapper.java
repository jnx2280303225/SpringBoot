package com.jnx.springboot.common.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jnx.springboot.common.entity.OrderDetail;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 订单明细表 Mapper 接口
 * </p>
 *
 * @author 蒋楠鑫
 * @since 2020-05-15
 */
@Mapper
public interface OrderDetailMapper extends BaseMapper<OrderDetail> {

}
