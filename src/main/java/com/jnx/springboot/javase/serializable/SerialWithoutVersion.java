package com.jnx.springboot.javase.serializable;

import java.io.FileInputStream;
import java.io.ObjectInputStream;

/**
 * 演示实现Serializable接口但不显示提供serialVersionUID的情况
 * 现象：没有显示指定serialVersionUID时，对象可以正常序列化，
 * 但是如果手动修改文件中的属性，再进行反序列化，就会报错
 * 结论：如果实现了Serializable接口但没有显示指定serialVersionUID，
 * 系统在执行序列化时会自动生成一个serialVersionUID，当我们更改文件后进行反序列化时，
 * 文件的serialVersionUID已经发生了改变，与之前对象serialVersionUID不一致，导致反序列化失败
 *
 * @author 蒋楠鑫
 * @date 2020/5/26
 */
public class SerialWithoutVersion {

	public static void main(String[] args) {
		String fileName = "./src/main/resources/file/userWithoutVersionFile";
		// 将对象进行反序列化
		ObjectInputStream inputStream;
		try {
			inputStream = new ObjectInputStream(new FileInputStream(fileName));
			UserWithoutVersion userWithoutVersion = (UserWithoutVersion) inputStream.readObject();
			System.out.println(userWithoutVersion);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
