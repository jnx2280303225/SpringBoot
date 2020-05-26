package com.jnx.springboot.javase.serializable;

import java.io.FileInputStream;
import java.io.ObjectInputStream;

/**
 * 演示手动修改serialVersionUID会有什么后果
 * 现象：将对象序列化之后，手动修改对象中的serialVersionUID的值，
 * 再进行反序列化，就会因为serialVersionUID不匹配而序列化失败
 * 结论：serialVersionUID作为对象序列化的唯一值，不能随意更改，
 * 一旦更改就会导致无法反序列化，尤其是在系统版本升级过程中，
 * 要做到旧版本兼容，就不能修改serialVersionUID的值
 *
 * @author 蒋楠鑫
 * @date 2020/5/26
 */
public class ChangeVersion {

	public static void main(String[] args) {
		String fileName = "./src/main/resources/file/user.txt";
		// 将对象进行反序列化
		ObjectInputStream inputStream = null;
		try {
			inputStream = new ObjectInputStream(new FileInputStream(fileName));
			User user = (User) inputStream.readObject();
			System.out.println(user);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
