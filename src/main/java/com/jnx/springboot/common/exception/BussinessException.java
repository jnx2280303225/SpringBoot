package com.jnx.springboot.common.exception;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.experimental.Accessors;

/**
 * 自定义异常-业务逻辑异常
 *
 * @author 蒋楠鑫
 * @date 2020/5/15
 */
@Getter
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class BussinessException extends RuntimeException {

	private static final long serialVersionUID = -4042646123332961640L;

	/**
	 * 异常状态码
	 */
	private Integer code;

	/**
	 * 异常信息
	 */
	private String message;

	public BussinessException(Integer code, String message) {
		this.code = code;
		this.message = message;
	}
}
