package com.jnx.springboot.designpatterns.proxy;

import java.lang.reflect.Proxy;

/**
 * jdk动态代理模式:客户端
 *
 * @author 蒋楠鑫
 * @date 2020-01-08
 */
public class MyClient {

	public static void main(String[] args) {
		ISubject iSubject = new SubjectImpl();
		//获取代理对象
		ISubject proxy = (ISubject) Proxy.newProxyInstance(MyClient.class.getClassLoader(), new Class[]{ISubject.class}, new MyInvocationHandler(iSubject));
		proxy.getData();
	}
}
