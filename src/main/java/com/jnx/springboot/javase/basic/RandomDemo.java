package com.jnx.springboot.javase.basic;

import java.util.Random;
import java.util.Scanner;

/**
 * 从0-n之前取k个不重复的随机数
 *
 * @author 蒋楠鑫
 * @date 2020-02-26
 */
public class RandomDemo {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("请输入一个正整数:");
		int n = scanner.nextInt();
		System.out.println("请输入要产生的随机数个数:");
		int k = scanner.nextInt();
		//将0-n放入一个数组中
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = i;
		}
		//进行k次随机,每次随机取i到n-1的随机索引index,将arr[i]和arr[index]交换
		Random random = new Random();
		for (int i = 0; i < k; i++) {
			//随机数取索引
			int index = random.nextInt(n - i) + i;
			int temp = arr[i];
			arr[i] = arr[index];
			arr[index] = temp;
		}
		System.out.println("产生的" + k + "个随机数为:");
		System.out.print("[");
		//拼接字符串
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < k; i++) {
			sb.append(arr[i]).append(",");
		}
		//去掉最后一个逗号
		sb.deleteCharAt(sb.length() - 1);
		System.out.print(sb.toString() + "]");
	}

}
