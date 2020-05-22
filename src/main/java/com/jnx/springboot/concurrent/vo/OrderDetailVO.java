package com.jnx.springboot.concurrent.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * 、
 * 返回给前端的订单明细对象
 *
 * @author 蒋楠鑫
 * @date 2020/5/22
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel("展示的订单明细信息")
public class OrderDetailVO implements Serializable {

	private static final long serialVersionUID = -32409889489848923L;

	@ApiModelProperty("商品号")
	private String productNo;

	@ApiModelProperty("商品名称")
	private String productName;

	@ApiModelProperty("数量")
	private Long number;

	@ApiModelProperty("单价")
	private Long price;

	@ApiModelProperty("金额")
	private Long amount;
}
