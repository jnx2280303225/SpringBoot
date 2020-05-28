package com.jnx.springboot.javase.serializable;

import lombok.Data;

import java.io.Serializable;

/**
 * 实现序列化接口但不提供serialVersionUID
 *
 * @author 蒋楠鑫
 * @date 2020/5/26
 */
@Data
public class UserWithoutVersion implements Serializable {

	/**
	 * 用户工号
	 */
	private String userNo;

	/**
	 * 姓名
	 */
	private String name;

	/**
	 * 年龄
	 */
	private Integer age;
}
