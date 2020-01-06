package com.jnx.springboot.distributedlock.redlock.service;

/**
 * 实际业务的服务层接口
 * @author 蒋楠鑫
 * @date 2019-11-12
 */
public interface WorkService {
	
	/**
	 * 保存数据
	 */
	void saveData() throws InterruptedException;
}
