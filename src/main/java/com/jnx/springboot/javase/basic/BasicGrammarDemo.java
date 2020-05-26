package com.jnx.springboot.javase.basic;

/**
 * JavaSE测试案例
 *
 * @author 蒋楠鑫
 * @date 2019-10-17
 */
public class BasicGrammarDemo {

	public static void main(String[] args) {
		//1.测试位运算
		bitOperation();
	}

	private static void bitOperation() {
		int a = -6;
		int length = 32;
		for (int i = 0; i < length; i++) {
			int t = (a & 0x80000000 >>> i) >>> (31 - i);
			System.out.print(t);
		}

	}

}
