package com.jnx.springboot.bussiness.form;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * 前端传入的订单明细信息
 *
 * @author 蒋楠鑫
 * @date 2020/5/21
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel("用户输入的订单明细信息")
public class OrderDeatilForm implements Serializable {

	private static final long serialVersionUID = 8486509144229066824L;

	@ApiModelProperty("商品号")
	@NotEmpty
	private String productNo;

	@ApiModelProperty("数量")
	@NotNull
	private Long number;
}
