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
		UserWithoutVersion userWithoutVersion = new UserWithoutVersion();
		userWithoutVersion.setUserNo("20200526");
		userWithoutVersion.setName("未显示指定serialVersionUID");
		// 有serialVersionUID
		User user = new User();
		user.setUserNo("20200526");
		user.setName("指定serialVersionUID，并手动修改");
		// 分别写入文件
		ObjectOutputStream outputStream = null;
		try {
			FileOutputStream userWithoutVersionFile = new FileOutputStream(fileDir + "userWithoutVersionFile");
			FileOutputStream userFile = new FileOutputStream(fileDir + "user");
			outputStream = new ObjectOutputStream(userWithoutVersionFile);
			outputStream.writeObject(userWithoutVersion);
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
