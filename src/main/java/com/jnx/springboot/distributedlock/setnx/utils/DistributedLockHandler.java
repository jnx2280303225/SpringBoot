package com.jnx.springboot.distributedlock.setnx.utils;

import com.jnx.springboot.distributedlock.setnx.entity.Lock;

/**
 * redis分布式锁工具类接口
 *
 * @author 蒋楠鑫
 * @date 2019-11-22
 */
public interface DistributedLockHandler {

	/**
	 * 获取分布式锁
	 *
	 * @param lock           锁对象
	 * @param timeOut        等待超时时间(ms)
	 * @param tryInterval    尝试间隔时间(ms)
	 * @param lockExpireTime 持有锁的过期时间(ms)
	 * @return 是否获取到锁
	 */
	boolean getLock(Lock lock, long timeOut, long tryInterval, long lockExpireTime);

	/**
	 * 采取默认的配置获取锁
	 *
	 * @param lock 锁对象
	 * @return 是否获取到锁
	 */
	boolean getLock(Lock lock);

	/**
	 * 释放分布式锁
	 *
	 * @param lock 锁对象
	 */
	void releaseLock(Lock lock);
}
