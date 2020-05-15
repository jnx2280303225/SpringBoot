package com.jnx.springboot.common.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 公共状态枚举
 *
 * @author 蒋楠鑫
 * @date 2020/5/15`
 */
@Getter
@AllArgsConstructor
public enum CommonStatusEnum {

	/**
	 * 启用状态 --- 启用
	 */
	START_STATUS(1, "启用", "启用状态"),

	/**
	 * 启用状态 --- 停用
	 */
	STOP_STATUS(0, "停用", "启用状态");

	/**
	 * 常量码
	 */
	private Integer code;

	/**
	 * 常量值
	 */
	private String value;

	/**
	 * 类型
	 */
	private String type;
}
