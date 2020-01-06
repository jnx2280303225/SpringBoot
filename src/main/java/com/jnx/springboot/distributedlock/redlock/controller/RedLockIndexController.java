package com.jnx.springboot.distributedlock.redlock.controller;

import com.jnx.springboot.common.msg.Result;
import com.jnx.springboot.distributedlock.redlock.service.WorkService;
import com.jnx.springboot.distributedlock.redlock.utils.RedisLocker;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * redis推荐的redlock方式实现分布式锁
 * @author 蒋楠鑫
 * @date 2019-11-22
 */
@RestController
@RequestMapping("redlock")
@Api(tags = "redis推荐的redlock方式实现分布式锁")
public class RedLockIndexController {
	
	/**
	 * 处理业务的服务层
	 */
	@Autowired
	private WorkService workService;
	
	@ApiOperation("分布式锁测试")
	@GetMapping("index")
	public Result index(){
		try {
			RedisLocker.lock("测试",workService);
			return Result.ok("插入一条数据");
		} catch (Exception e) {
			e.printStackTrace();
			return Result.ok("未获取到锁!!!");
		}
	}
	
}
