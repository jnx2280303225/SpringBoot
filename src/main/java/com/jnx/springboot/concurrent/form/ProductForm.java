package com.jnx.springboot.concurrent.form;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * 前端传入的商品信息
 *
 * @author 蒋楠鑫
 * @date 2020/5/15
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel("商品信息")
public class ProductForm {

	@ApiModelProperty("商品名称")
	@NotEmpty
	private String name;

	@ApiModelProperty("数量")
	@NotNull
	private Integer number;

	@ApiModelProperty("单价")
	@NotNull
	private Long price;

	@ApiModelProperty("状态（1-启用，0-停用）")
	@NotNull
	private Integer status;

	@ApiModelProperty("备注")
	private String remark;
}
