package com.jnx.springboot.javase.basic;

import java.util.*;

/**
 * 找出一个字符串中出现次数最多的字母,如果没有字母返回null,如果次数相同返回ascii更小的
 *
 * @author 蒋楠鑫
 * @date 2020-02-08
 */
public class StringDemo {

	public static void main(String[] args) {
		String string = "ddddaaaass1111111111111";
		if (string.isEmpty()) {
			return;
		}
		//遍历字符串将字符和次数放入HashMap
		String s = string.toLowerCase();
		Map<Character, Integer> map = new HashMap<>(s.length());
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			//不是字母就跳过
			if (!Character.isLetter(c)) {
				continue;
			}
			//统计次数
			if (map.containsKey(c)) {
				int count = map.get(c);
				count++;
				map.put(c, count);
			} else {
				map.put(c, 1);
			}
		}
		//非空判断
		if (map.isEmpty()) {
			return;
		}
		//找出次数最大值及最大值对应的字母集合
		int max = Collections.max(map.values());
		Set<Character> set = new HashSet<>();
		for (Map.Entry<Character, Integer> entry : map.entrySet()) {
			if (entry.getValue().equals(max)) {
				set.add(entry.getKey());
			}
		}
		//获取ascii最小的
		Character max1 = Collections.min(set);
		System.out.println(max1);
	}

}
