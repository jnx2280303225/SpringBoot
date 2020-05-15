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
 * 商品信息表
 * </p>
 *
 * @author 蒋楠鑫
 * @since 2020-05-15
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class Product implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * 主键
	 */
	@TableId(value = "id", type = IdType.AUTO)
	private Integer id;

	/**
	 * 状态（1-启用，0-停用）
	 */
	@TableField("status")
	private Integer status;

	/**
	 * 库存数量
	 */
	@TableField("number")
	private Integer number;

	/**
	 * 创建时间
	 */
	@TableField("created")
	private LocalDateTime created;

	/**
	 * 修改时间
	 */
	@TableField("updated")
	private LocalDateTime updated;

	/**
	 * 单价（单位：分）
	 */
	@TableField("price")
	private Long price;

	/**
	 * 商品号
	 */
	@TableField("productNo")
	private String productNo;

	/**
	 * 商品名称
	 */
	@TableField("name")
	private String name;

	/**
	 * 备注
	 */
	@TableField("remark")
	private String remark;


}
