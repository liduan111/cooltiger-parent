package com.kyj.cooltiger.cooltigeroauth.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import java.util.HashMap;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * @author guoxq
 * @version 1.0
 * @date 2020/7/27 14:22
 * redis 工具类
 */
@Component
public class RedisUtil {

    @Value("token.expirationMilliSeconds")
    private String expirationMilliSeconds;

    @Autowired
    private RedisTemplate redisTemplate;

    /**
     * 查询key支持模糊查询
     * @param key
     * @return
     */
    public Set<String> keys(String key){
        return redisTemplate.keys(key);
    }

    /**
     * 字符串获取值
     * @param key
     * @return
     */
    public Object get(String key){
        return  redisTemplate.opsForValue().get(key);
    }
    /**
     * 字符串存入值
     * 默认过期时间为2小时
     * @param key
     * */
    public void set(String key, String value){
        set(key,value,Long.parseLong(expirationMilliSeconds));
    }

    /**
     * 字符串存入值
     * @param expire 过期时间（毫秒计）
     * @param key
     * */
    public void set(String key, String value,long expire){
        redisTemplate.opsForValue().set(key,value, expire,TimeUnit.MILLISECONDS);
    }

    /**
     * 删出key
     * 这里跟下边deleteKey（）最底层实现都是一样的，应该可以通用
     * @param key
     * */
    public void delete(String key){
        redisTemplate.opsForValue().getOperations().delete(key);
    }

    /**
     * 添加单个
     * @param key    key
     * @param filed  filed
     * @param domain 对象
     */
    public void hset(String key,String filed,Object domain){
        hset(key,filed,domain,Long.parseLong(expirationMilliSeconds));
    }

    /**
     * 添加单个
     * @param key    key
     * @param filed  filed
     * @param domain 对象
     * @param expire 过期时间（毫秒计）
     */
    public void hset(String key,String filed,Object domain,long expire){
        redisTemplate.opsForHash().put(key, filed, domain);
        setKeyExpire(key,Long.parseLong(expirationMilliSeconds));
    }

    /**
     * 添加HashMap
     *
     * @param key    key
     * @param hashMap    要存入的hash表
     */
    public void hset(String key, HashMap<String,Object> hashMap){
        redisTemplate.opsForHash().putAll(key,hashMap);
        setKeyExpire(key,Long.parseLong(expirationMilliSeconds));
    }

    /**
     * 如果key存在就不覆盖
     * @param key
     * @param filed
     * @param domain
     */
    public void hsetAbsent(String key,String filed,Object domain){
        redisTemplate.opsForHash().putIfAbsent(key, filed, domain);
    }

    /**
     * 查询key和field所确定的值
     * @param key 查询的key
     * @param field 查询的field
     * @return HV
     */
    public Object hget(String key,String field) {
        return redisTemplate.opsForHash().get(key, field);
    }

    /**
     * 查询该key下所有值
     * @param key 查询的key
     * @return Map<HK, HV>
     */
    public Object hget(String key) {
        return redisTemplate.opsForHash().entries(key);
    }

    /**
     * 删除key下所有值
     *
     * @param key 查询的key
     */
    public void deleteKey(String key) {
        redisTemplate.opsForHash().getOperations().delete(key);
    }

    /**
     * 添加set集合
     * @param key
     * @param set
     * @param expire
     */
    public void sset(Object key,Set<?> set,long expire){
        redisTemplate.opsForSet().add(key,set);
        setKeyExpire(key,expire);
    }

    /**
     * 添加set集合
     * @param key
     * @param set
     */
    public void sset(Object key,Set<?> set){
        sset(key, set,Long.parseLong(expirationMilliSeconds));
    }

    /**
     * 判断key和field下是否有值
     * @param key 判断的key
     * @param field 判断的field
     */
    public Boolean hasKey(String key,String field) {
        return redisTemplate.opsForHash().hasKey(key,field);
    }

    /**
     * 判断key下是否有值
     * @param key 判断的key
     */
    public Boolean hasKey(String key) {
        return redisTemplate.opsForHash().getOperations().hasKey(key);
    }

    /**
     * 更新key的过期时间
     * @param key
     * @param expire
     */
    public void setKeyExpire(Object key,long expire){
        redisTemplate.expire(key,expire, TimeUnit.MILLISECONDS);
    }


}
