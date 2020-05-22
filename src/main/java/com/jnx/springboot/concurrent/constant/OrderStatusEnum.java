package com.jnx.springboot.concurrent.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 订单状态枚举
 *
 * @author 蒋楠鑫
 * @date 2020/5/21
 */
@Getter
@AllArgsConstructor
public enum OrderStatusEnum {

	/**
	 * 未支付 --- 0
	 */
	NOT_PAY(0, "未支付"),

	/**
	 * 已支付 --- 1
	 */
	ALREADY_PAY(1, "已支付"),

	/**
	 * 已取消 --- 2
	 */
	CANCEL(2, "已取消"),

	/**
	 * 已删除 --- 3
	 */
	DELETE(3, "已删除"),

	/**
	 * 已退款 --- 4
	 */
	REFUND(4, "已退款");

	/**
	 * 状态码
	 */
	private Integer code;

	/**
	 * 状态中文值
	 */
	private String value;

	/**
	 * 根据状态码获取状态的中文值
	 *
	 * @param code 状态码
	 * @return 状态中文值
	 */
	public static String getValue(Integer code) {
		for (OrderStatusEnum value : OrderStatusEnum.values()) {
			if (value.getCode().equals(code)) {
				return value.getValue();
			}
		}
		return null;
	}
}
