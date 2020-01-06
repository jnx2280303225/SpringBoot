package com.jnx.springboot.distributedlock.setnx.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * redis分布式锁实体类
 * @author 蒋楠鑫
 * @date 2019-10-17
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class Lock implements Serializable {
	
	private static final long serialVersionUID = 8391622783882125191L;
	
	/**
	 * 锁的名称
	 */
	private String name;
	
	/**
	 * 锁的值
	 */
	private String value;
	
}
