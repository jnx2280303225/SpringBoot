package com.jnx.springboot.common.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 订单信息表
 * </p>
 *
 * @author 蒋楠鑫
 * @since 2020-05-15
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class Order implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * 主键
	 */
	@TableId(value = "id", type = IdType.AUTO)
	private Integer id;

	/**
	 * 订单状态（0-未支付，1-已支付，2-已取消，3-已删除，4-已退款）
	 */
	@TableField("status")
	private Integer status;

	/**
	 * 创建时间
	 */
	@TableField("create")
	private LocalDateTime create;

	/**
	 * 修改时间
	 */
	@TableField("updated")
	private LocalDateTime updated;

	/**
	 * 数量
	 */
	@TableField("number")
	private Long number;

	/**
	 * 金额（单位：分）
	 */
	@TableField("amount")
	private Long amount;

	/**
	 * 下单时间（格式yyyy-MM-dd HH:mm:ss）
	 */
	@TableField("orderTime")
	private String orderTime;

	/**
	 * 订单号
	 */
	@TableField("orderNo")
	private String orderNo;


}
