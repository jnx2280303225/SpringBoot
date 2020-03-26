package com.jnx.springboot.distributedlock.setnx.controller;

import com.jnx.springboot.common.msg.Result;
import com.jnx.springboot.distributedlock.setnx.entity.Lock;
import com.jnx.springboot.distributedlock.setnx.utils.DistributedLockHandler;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 分布式锁测试控制器层 --- 基于redis原生java代码
 * @author 蒋楠鑫
 * @date 2019-10-18
 */
@RestController
@RequestMapping("setnx")
@Api(tags = "分布式锁基于redis原生java代码")
public class IndexController {
	
	/**
	 * 分布式锁工具类
	 */
	@Autowired
	private DistributedLockHandler distributedLockHandler;
	
	@ApiOperation("分布式锁测试")
	@GetMapping("index")
	public Result<String> index(){
		Lock lock = new Lock();
		lock.setName("自定义锁");
		lock.setValue("我是分布式锁");
		if (distributedLockHandler.getLock(lock)){
			System.out.println("hello world");
			try {
				Thread.sleep(5000L);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			distributedLockHandler.releaseLock(lock);
			return Result.ok("获取到了锁,执行了方法xxx");
		}
		return Result.error("没有获取到锁,直接返回",null);
	}

}
