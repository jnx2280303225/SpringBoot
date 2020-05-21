package com.jnx.springboot.common.exception;

/**
 * 异常常量类
 *
 * @author 蒋楠鑫
 * @date 2020/5/15
 */
public final class ExceptionConstant {

	public static final BussinessException PRODUCT_NAME_EXISTS = new BussinessException(0, "商品名称重复");

	public static final BussinessException ORDER_DETAIL_EMPTY = new BussinessException(1, "订单明细不能为空");

	public static final BussinessException PRODUCT_NO_ERROR = new BussinessException(2,"商品号错误");
}
