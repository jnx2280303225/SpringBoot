package com.jnx.springboot.distributedlock.setnx.utils;

import com.jnx.springboot.distributedlock.setnx.entity.Lock;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.concurrent.TimeUnit;

/**
 * redis分布式锁工具类
 * @author 蒋楠鑫
 * @date 2019-10-18
 */
@Component
public class DistributedLocker implements DistributedLockHandler{
	
	/**
	 * 日志打印
	 */
	private static final Logger LOGGER = LoggerFactory.getLogger(DistributedLocker.class);
	/**
	 * 超时时间 --- 10秒
	 */
	private static final long TIME_OUT = 10*1000L;
	/**
	 * 尝试时间间隔 --- 20毫秒
	 */
	private static final long TRY_INTERVAL = 20L;
	/**
	 * 持有锁的过期时间 --- 20秒
	 */
	private static final long LOCK_EXPIRE_TIME = 20*1000L;
	
	/**
	 * redis缓存操作工具类
	 */
	@Autowired
	private StringRedisTemplate template;
	
	/**
	 * 获取分布式锁
	 * @param lock              锁对象
	 * @param timeOut           等待超时时间(ms)
	 * @param tryInterval       尝试间隔时间(ms)
	 * @param lockExpireTime    持有锁的过期时间(ms)
	 * @return  是否获取到锁
	 */
	@Override
	public boolean getLock(Lock lock, long timeOut, long tryInterval, long lockExpireTime){
		//锁对象非空判断
		if (lock == null || StringUtils.isEmpty(lock.getName()) || StringUtils.isEmpty(lock.getValue())){
			return false;
		}
		//获取锁的起始时间
		long startTime = System.currentTimeMillis();
		//重复尝试获取锁
		int i = 0;
		do {
			//第一次获取锁的时候判断redis是否包含该锁实体
			if (!template.hasKey(lock.getName())){
				//不包含该锁直接获取锁并放入redis
				ValueOperations<String, String> ops = template.opsForValue();
				ops.set(lock.getName(),lock.getValue(),lockExpireTime, TimeUnit.MILLISECONDS);
				return true;
			} else {
				i++;
				LOGGER.error("第" + i + "次尝试获取锁失败," + lock.getName() + "已被获取!");
			}
			//等待超时
			if (System.currentTimeMillis() - startTime > timeOut){
				LOGGER.error("等待超时:经过" + i + "次等待后仍无法获取锁!");
				return false;
			}
			try {
				//线程等待
				Thread.sleep(tryInterval);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		} while (template.hasKey(lock.getName()));
		return false;
	}
	
	/**
	 * 采取默认的配置获取锁
	 * @param lock      锁对象
	 * @return  是否获取到锁
	 */
	@Override
	public boolean getLock(Lock lock){
		return getLock(lock,TIME_OUT,TRY_INTERVAL,LOCK_EXPIRE_TIME);
	}
	
	/**
	 * 释放分布式锁
	 * @param lock      锁对象
	 */
	@Override
	public void releaseLock(Lock lock){
		if (lock != null && !StringUtils.isEmpty(lock.getName())){
			template.delete(lock.getName());
		}
	}
}
