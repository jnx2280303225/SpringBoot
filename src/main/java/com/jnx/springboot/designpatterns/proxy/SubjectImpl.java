package com.jnx.springboot.designpatterns.proxy;

import java.util.ArrayList;
import java.util.List;

/**
 * jdk动态代理模式:被代理的实现类
 * @author 蒋楠鑫
 * @date 2020-01-08
 */
public class SubjectImpl implements ISubject{
	
	/**
	 * 获取数据
	 */
	@Override
	public void getData() {
		System.out.println("获取到了一系列数据!");
		List<String> list = new ArrayList<>(100000);
		for (int i = 0; i < 100000; i++){
			list.add("数字" + i);
		}
	}
}
