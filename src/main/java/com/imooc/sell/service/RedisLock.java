package com.imooc.sell.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

/**
 * Created by 廖师兄
 * 2017-08-07 23:55
 */
@Component
@Slf4j
public class RedisLock {

    @Autowired
    private StringRedisTemplate redisTemplate;

    /**
     * 加锁
     * @param key
     * @param value 当前时间+超时时间
     * @return
     */
    public boolean lock(String key, String value) {
        if(redisTemplate.opsForValue().setIfAbsent(key, value)) {//setnx
            return true;
        }
        //currentValue=A   这两个线程的value都是B  其中一个线程拿到锁
        //对于n个获得当前值的线程，不管这个值是新的还是旧的，都会只有一个线程返回true
        //对于刚要进入方法的n个线程，要么等锁过期，要么等解锁
        String currentValue = redisTemplate.opsForValue().get(key);
        //如果锁过期
        if (!StringUtils.isEmpty(currentValue)
                && Long.parseLong(currentValue) < System.currentTimeMillis()) {
            //获取上一个锁的时间
            //设置值前的n个获得旧值的线程处于同一竞争条件
            //设置值后的n个获得新值的线程判断过不了，锁刷新了时间没过期
            String oldValue = redisTemplate.opsForValue().getAndSet(key,  value);
            if (!StringUtils.isEmpty(oldValue) && oldValue.equals(currentValue)) {
                return true;
            }
        }

        return false;
    }

    /**
     * 解锁
     * @param key
     * @param value
     */
    public void unlock(String key, String value) {//锁没过期时，防止死锁和提高效率，尽早让其它线程获得锁
        try {
            String currentValue = redisTemplate.opsForValue().get(key);
            if (!StringUtils.isEmpty(currentValue) && currentValue.equals(value)) {
                redisTemplate.opsForValue().getOperations().delete(key);
            }
        }catch (Exception e) {
            log.error("【redis分布式锁】解锁异常, {}", e);
        }
    }

}
