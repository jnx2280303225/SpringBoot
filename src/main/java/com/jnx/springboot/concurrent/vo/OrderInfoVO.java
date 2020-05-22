package com.jnx.springboot.concurrent.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.List;

/**
 * 返回给前端的订单信息对象
 *
 * @author 蒋楠鑫
 * @date 2020/5/22
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel("展示的订单信息")
public class OrderInfoVO implements Serializable {

	private static final long serialVersionUID = 723002244579167325L;

	@ApiModelProperty("订单号")
	private String orderNo;

	@ApiModelProperty("状态")
	private String status;

	@ApiModelProperty("订单总数量")
	private Long number;

	@ApiModelProperty("订单总金额")
	private Long amout;

	@ApiModelProperty("订单明细集合")
	private List<OrderDetailVO> detailVOList;
}
