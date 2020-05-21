package com.jnx.springboot.concurrent.form;

import com.jnx.springboot.concurrent.constant.OrderStatusEnum;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * 前端传入的订单状态
 *
 * @author 蒋楠鑫
 * @date 2020/5/21
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel("用户输入的订单状态")
public class OrderStatusForm implements Serializable {

	private static final long serialVersionUID = -3234742782510195042L;

	@ApiModelProperty("订单号")
	@NotEmpty
	private String orderNo;

	@ApiModelProperty("订单状态")
	@NotNull
	private OrderStatusEnum status;
}
