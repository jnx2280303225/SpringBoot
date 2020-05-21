package com.jnx.springboot.concurrent.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * 返回给前端的商品信息对象
 *
 * @author 蒋楠鑫
 * @date 2020/5/21
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel("展示的单条商品信息")
public class ProductInfoVO implements Serializable {

	private static final long serialVersionUID = 8823047691710489548L;

	@ApiModelProperty("商品号")
	private String productNo;

	@ApiModelProperty("商品名称")
	private String name;

	@ApiModelProperty("库存数量")
	private Long number;

	@ApiModelProperty("单价")
	private Long price;

	@ApiModelProperty("备注")
	private String remark;
}
