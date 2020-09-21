package com.kyj.cooltiger.customer.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * @author liduan
 * Description: Redis工具类
 * date: 2020/9/15 15:36
 */
@Component
public class RedisUtils {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    /**
     * 获取字符串类型值
     *
     * @param key 键
     * @return
     */
    public String get(String key) {
        return stringRedisTemplate.opsForValue().get(key);
    }

    /**
     * 插入字符串类型值
     *
     * @param key   键
     * @param value 值
     */
    public void set(String key, String value) {
        stringRedisTemplate.opsForValue().set(key, value);
    }

    /**
     * 插入字符串类型值并设置过期时间
     *
     * @param key   键
     * @param value 值
     * @param time  时间（分钟）
     */
    public void set(String key, String value, Long time) {
        stringRedisTemplate.opsForValue().set(key, value, time, TimeUnit.MINUTES);
    }

    /**
     * 根据key删除
     *
     * @param key 键
     * @return
     */
    public Boolean delete(String key) {
        return stringRedisTemplate.delete(key);
    }

    /**
     * 根据key获取过期时间
     *
     * @param key 键
     * @return
     */
    public Long getExpire(String key) {
        return stringRedisTemplate.getExpire(key);
    }

    /**
     * 判断key是否存在
     *
     * @param key
     * @return
     */
    public Boolean hasKey(String key) {
        return stringRedisTemplate.hasKey(key);
    }

    /**
     * 给key设置过期时间
     *
     * @param key      键
     * @param timeout  过期时间
     * @param timeUnit 时间单位
     * @return
     */
    public Boolean expire(String key, Long timeout, TimeUnit timeUnit) {
        return stringRedisTemplate.expire(key, timeout, timeUnit);
    }

}
