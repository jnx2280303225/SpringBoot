package com.jnx.springboot.designpatterns.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * jdk动态代理模式:代理类
 * @author 蒋楠鑫
 * @date 2020-01-08
 */
public class MyInvocationHandler implements InvocationHandler {
	
	/**
	 * 持有被代理的对象作为成员属性
	 */
	private Object target;
	
	public MyInvocationHandler(Object target){
		//实例化被代理的类
		this.target = target;
	}
	
	/**
	 * jdk动态代理的方法核心
	 * @param proxy     动态代理类
	 * @param method    代理的方法
	 * @param args      方法参数列表
	 * @return  方法执行结果
	 * @throws Throwable    异常
	 */
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		//新增某些功能
		long beforeTime = System.currentTimeMillis();
		System.out.println("获取数据前动态添加功能......");
		Object result = method.invoke(target, args);
		long afterTime = System.currentTimeMillis();
		System.out.println("获取数据后动态添加功能......");
		System.out.println("耗时" + (afterTime-beforeTime) + "毫秒");
		return result;
	}
}
