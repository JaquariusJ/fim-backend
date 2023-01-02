package com.money.fimsystem.redis;

import com.money.fimsystem.common.utils.JsonUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ZSetOperations;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

@Component
public class RedisClient {
    @Autowired
    private StringRedisTemplate stringRedisTemplate;
    @SuppressWarnings("rawtypes")
    @Autowired
    private RedisTemplate redisTemplate;

    /**
     * 是否存在key
     *
     * @param key
     * @return
     */
    public Boolean hasKey(String key) {
        return stringRedisTemplate.hasKey(key);
    }


    /**
     * 获取keys
     */
    public Set<String> getKeys(String pattern) {
        return stringRedisTemplate.keys(pattern);
    }

    /**
     * key重命名
     */
    public boolean rename(String oldKey, String newKey) {
        return stringRedisTemplate.renameIfAbsent(oldKey, newKey);
    }

    /**
     * 保存多个key
     *
     * @param map
     */
    public void setKeys(Map<String, String> map) {
        stringRedisTemplate.opsForValue().multiSet(map);
    }

    public <T> List<T> getKeys(Collection<String> keys, Class<T> tClass) {
        List<String> stringList = stringRedisTemplate.opsForValue().multiGet(keys);
        List<T> ret = stringList.stream().map(str -> {
            if (StringUtils.isNotBlank(str)) {
                return JsonUtils.parseObject(str, tClass);
            }
            return null;
        }).filter(Objects::nonNull).collect(Collectors.toList());
        return ret;
    }

    /**
     * 保存对象
     *
     * @param key
     * @param value
     */
    public void set(String key, Object value) {
        set(key, JsonUtils.toJSONString(value));
    }

    /**
     * 保存对象
     *
     * @param key
     * @param value
     */
    public void set(String key, Object value, Long timeout, TimeUnit timeUnit) {
        set(key, JsonUtils.toJSONString(value), timeout, timeUnit);
    }

    /**
     * 获取对象
     *
     * @param key
     */
    public <T> T getBean(String key, Class<T> clazz) {
        String json = get(key);
        if (StringUtils.isBlank(json)) {
            return null;
        }
        return (T) JsonUtils.parseObject(json, clazz);
    }

    /**
     * 保存字符串
     *
     * @param key
     * @param value
     */
    public void set(String key, String value) {
        stringRedisTemplate.opsForValue().set(key, value);
    }

    /**
     * 保存字符串并设置有效时间
     *
     * @param key
     * @param value
     * @param timeout
     * @param timeUnit
     */
    public void set(String key, String value, Long timeout, TimeUnit timeUnit) {
        stringRedisTemplate.opsForValue().set(key, value, timeout, timeUnit);
    }

    /**
     * 获取字符串
     *
     * @param key
     * @return
     */
    public String get(String key) {
        return stringRedisTemplate.opsForValue().get(key);
    }

    /**
     * 保存int数据
     *
     * @param key
     * @param value
     */
    public void set(String key, Integer value) {
        redisTemplate.opsForValue().set(key, value);
    }

    /**
     * 保存Integer数据并设置有效时间
     *
     * @param key
     * @param value
     * @param timeout
     * @param timeUnit
     */
    public void set(String key, Integer value, Long timeout, TimeUnit timeUnit) {
        redisTemplate.opsForValue().set(key, value, timeout, timeUnit);
    }

    /**
     * 获取Integer数据
     *
     * @param key
     * @return
     */
    public Integer getInt(String key) {
        return (Integer) redisTemplate.opsForValue().get(key);
    }

    /**
     * 保存Long数据
     *
     * @param key
     * @param value
     */
    public void set(String key, Long value) {
        redisTemplate.opsForValue().set(key, value);
    }

    /**
     * 保存Long数据并设置有效时间
     *
     * @param key
     * @param value
     * @param timeout
     * @param timeUnit
     */
    public void set(String key, Long value, Long timeout, TimeUnit timeUnit) {
        redisTemplate.opsForValue().set(key, value, timeout, timeUnit);
    }

    /**
     * 获取Long数据
     *
     * @param key
     * @return
     */
    public Long getLong(String key) {
        return (Long) redisTemplate.opsForValue().get(key);
    }

    /**
     * 保存List
     *
     * @param key
     * @param value
     */
    public <T> void set(String key, List<T> value) {
        redisTemplate.opsForList().rightPush(key, value);
    }

    /**
     * 获取List
     *
     * @param key
     * @return
     */
    public <T> List<T> getList(String key) {
        return (List<T>) redisTemplate.opsForList().rightPop(key);
    }

    /**
     * 获取List
     *
     * @param key
     * @return
     */
    public <T> List<T> getList(String key, Long timeout, TimeUnit timeUnit) {
        return (List<T>) redisTemplate.opsForList().rightPop(key, timeout, timeUnit);
    }

    /**
     * 保存Set
     *
     * @param key
     * @param value
     */
    public <T> void set(String key, Set<T> value) {
        redisTemplate.opsForSet().add(key, value);
    }

    /**
     * 获取Set
     *
     * @param key
     * @return
     */
    public <T> Set<T> getSet(String key) {
        return (Set<T>) redisTemplate.opsForSet().pop(key);
    }

    /**
     * 保存Map item
     *
     * @param key
     * @param value
     */
    public void put(String key, String hashKey, Object value) {
        redisTemplate.opsForHash().put(key, hashKey, value);
    }

    /**
     * 保存Map
     *
     * @param key
     * @param value
     */
    public void putAll(String key, Map<?, ?> value) {
        redisTemplate.opsForHash().putAll(key, value);
    }

    /**
     * 获取Map
     *
     * @param key
     * @return
     */
    public <T, E> Map<T, E> getMap(String key) {
        return redisTemplate.opsForHash().entries(key);
    }

    /**
     * 删除
     *
     * @param key
     * @return
     */
    public Boolean delete(Object key) {
        return redisTemplate.delete(key);
    }

    /**
     * 删除多个
     *
     * @param keys
     * @return
     */
    public Long delete(Collection keys) {
        return stringRedisTemplate.delete(keys);
    }

    public void addZSet(String key, String orderId, double score) {
        stringRedisTemplate.opsForZSet().add(key, orderId, score);
    }

    public void addZSet(String key, Set<ZSetOperations.TypedTuple<String>> members) {
        stringRedisTemplate.opsForZSet().add(key, members);
    }

    public Set<ZSetOperations.TypedTuple<String>> getZSet(String key, double score) {
        Set<ZSetOperations.TypedTuple<String>> tuples = stringRedisTemplate.opsForZSet().rangeByScoreWithScores(key, 0, score);
        return tuples;
    }

    public long deleteZSet(String key, String orderId) {
        return stringRedisTemplate.opsForZSet().remove(key, orderId);
    }
}
