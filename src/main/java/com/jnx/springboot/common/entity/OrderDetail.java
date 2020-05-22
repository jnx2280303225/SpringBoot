package com.jnx.springboot.common.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 订单明细表
 * </p>
 *
 * @author 蒋楠鑫
 * @since 2020-05-15
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("`order_detail`")
public class OrderDetail implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * 主键
	 */
	@TableId(value = "`id`", type = IdType.AUTO)
	private Integer id;

	/**
	 * 创建时间
	 */
	@TableField("`created`")
	private LocalDateTime created;

	/**
	 * 修改时间
	 */
	@TableField("`updated`")
	private LocalDateTime updated;

	/**
	 * 数量
	 */
	@TableField("`number`")
	private Long number;

	/**
	 * 单价（单位：分）
	 */
	@TableField("`price`")
	private Long price;

	/**
	 * 金额（单位：分）
	 */
	@TableField("`amount`")
	private Long amount;

	/**
	 * 订单号
	 */
	@TableField("`orderNo`")
	private String orderNo;

	/**
	 * 商品号
	 */
	@TableField("`productNo`")
	private String productNo;

	/**
	 * 商品名称
	 */
	@TableField("`productName`")
	private String productName;
}
