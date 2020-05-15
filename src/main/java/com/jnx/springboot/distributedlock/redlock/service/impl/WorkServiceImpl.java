package com.jnx.springboot.distributedlock.redlock.service.impl;

import com.jnx.springboot.distributedlock.redlock.service.WorkService;
import org.springframework.stereotype.Service;

/**
 * 实际业务的服务层接口实现类
 *
 * @author 蒋楠鑫
 * @date 2019-11-12
 */
@Service
public class WorkServiceImpl implements WorkService {

	/**
	 * 保存数据
	 *
	 * @throws InterruptedException 线程中断异常
	 */
	@Override
	public void saveData() throws InterruptedException {
		Thread.sleep(10000);
		System.out.println("往数据库插入了一条数据");
	}

}
