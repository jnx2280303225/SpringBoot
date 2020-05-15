package com.jnx.springboot.httprequest.vo;

import com.jnx.springboot.httprequest.constant.StatusEnum;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * 返回给前端的信息VO
 *
 * @author 蒋楠鑫
 * @date 2020/3/31
 */
@Data
public class InfoVO implements Serializable {

	private static final long serialVersionUID = 160520934695496796L;

	@ApiModelProperty("唯一标识")
	private Integer id;

	@ApiModelProperty("名称")
	private String name;

	@ApiModelProperty("状态")
	private StatusEnum status;
}
