package com.jnx.springboot.distributedlock.redlock.utils;

import com.jnx.springboot.distributedlock.redlock.service.WorkService;
import org.redisson.Redisson;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;

import java.util.concurrent.TimeUnit;

/**
 * 锁管理工具类
 * @author 蒋楠鑫
 * @date 2019-11-12
 */
public class RedisLocker {
	
	/**
	 * 锁名称前缀
	 */
	private final static String PREFIX = "lock";
	/**
	 * 持有锁的过期时间 --- 20s
	 */
	private final static long LOCK_TIME = 20;
	/**
	 * 超时等待时间 --- 5s
	 */
	private final static long TIME_OUT = 5;
	
	/**
	 * 使用默认过期时间加锁
	 * @param lockName  锁名称
	 * @param workService   要执行的服务层逻辑
	 */
	public static void lock(String lockName, WorkService workService) throws Exception {
		lock(lockName,workService,LOCK_TIME);
	}
	
	/**
	 * 自定义过期时间加锁
	 * @param lockName  锁名称
	 * @param workService   要执行的服务层逻辑
	 * @param lockTime  锁的过期时间
	 */
	public static void lock(String lockName, WorkService workService, long lockTime) throws Exception {
		//连接Redisson
		RedissonClient redissonClient = Redisson.create();
		//获取锁工具类
		RLock lock = redissonClient.getLock(PREFIX + lockName);
		//判断是否获取到锁
		boolean isSuccess = lock.tryLock(TIME_OUT, lockTime, TimeUnit.SECONDS);
		if (isSuccess){
			workService.saveData();
		} else {
			throw new Exception("未获取到锁!");
		}
	}
}
