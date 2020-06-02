package com.jnx.springboot.common.constant;

/**
 * 返回前端状态码及错误信息枚举类(参考http状态码)
 *
 * @author 蒋楠鑫
 * @date 2019-10-18
 */
public enum InfoMsgEnum {

	/**
	 * 200 --- 操作成功
	 */
	OK(200, "操作成功!"),

	/**
	 * 500 --- 服务器出现异常
	 */
	SERVER_ERROR(500, "操作失败，服务器出现异常！");

	public Integer code;

	public String message;

	InfoMsgEnum(Integer code, String message) {
		this.code = code;
		this.message = message;
	}
}
