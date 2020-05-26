package com.jnx.springboot.javase.serializable;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/**
 * 将两个序列化实体类写入到文件
 * 分别用来演示1.实现Serializable接口但不显示提供serialVersionUID
 * 2.手动修改serialVersionUID会有什么后果
 *
 * @author 蒋楠鑫
 * @date 2020/5/26
 */
public class OutputObject {

	public static void main(String[] args) {
		String fileDir = "./src/main/resources/file/";
		// 没有serialVersionUID
		UserNoVersion userNoVersion = new UserNoVersion();
		userNoVersion.setUserNo("20200526");
		userNoVersion.setName("未显示指定serialVersionUID");
		userNoVersion.setAge(25);
		// 有serialVersionUID
		User user = new User();
		user.setUserNo("20200526");
		user.setName("指定serialVersionUID，并手动修改");
		user.setAge(25);
		// 分别写入文件
		ObjectOutputStream outputStream = null;
		try {
			FileOutputStream userNoVersionFile = new FileOutputStream(fileDir + "userNoVersionFile.txt");
			FileOutputStream userFile = new FileOutputStream(fileDir + "user.txt");
			outputStream = new ObjectOutputStream(userNoVersionFile);
			outputStream.writeObject(userNoVersion);
			outputStream = new ObjectOutputStream(userFile);
			outputStream.writeObject(user);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (outputStream != null) {
				try {
					outputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
