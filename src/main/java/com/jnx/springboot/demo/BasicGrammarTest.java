package com.jnx.springboot.demo;

/**
 * JavaSE测试案例
 * @author 蒋楠鑫
 * @date 2019-10-17
 */
public class BasicGrammarTest {
	
	public static void main(String[] args) {
		测试();
	}
	
	private static void 测试(){
		int a = -6;
		for(int i = 0;i < 32; i++){
			int t = (a & 0x80000000 >>> i) >>> (31-i);
			System.out.print(t);
		}
		
	}
	
}
