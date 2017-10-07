package com.pramy.demo.mybatis;


import com.pramy.demo.mybatis.util.ApplicationContextHolder;
import org.apache.ibatis.cache.Cache;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.cache.RedisCache;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * IntelliJ IDEA 17
 * Created by Pramy on 2017/10/5.
 */
public class MyRedisCache implements Cache {
    private static final Logger logger = LoggerFactory.getLogger(RedisCache.class);
    private final ReadWriteLock readWriteLock = new ReentrantReadWriteLock();
    private final String id; // cache instance id
    private RedisTemplate<Object,Object> redisTemplate;
    private static final long EXPIRE_TIME_IN_MINUTES = 10; // redis过期时间
    public MyRedisCache(String id) {
        if (id == null) {
            throw new IllegalArgumentException("Cache instances require an ID");
        }
        this.id = id;
    }
    @Override
    public String getId() {
        return id;
    }
    /**
     * Put query result to redis
     *
     * @param key
     * @param value
     */
    @Override
    @SuppressWarnings("unchecked")
    public void putObject(Object key, Object value) {
        RedisTemplate redisTemplate = getRedisTemplate();
        ValueOperations opsForValue = redisTemplate.opsForValue();
        opsForValue.set(key, value, EXPIRE_TIME_IN_MINUTES, TimeUnit.MINUTES);
        logger.debug("Put query result to redis");
    }
    /**
     * Get cached query result from redis
     *
     * @param key
     * @return
     */
    @Override
    public Object getObject(Object key) {
        RedisTemplate redisTemplate = getRedisTemplate();
        ValueOperations opsForValue = redisTemplate.opsForValue();
        logger.debug("Get cached query result from redis");
        return opsForValue.get(key);
    }
    /**
     * Remove cached query result from redis
     *
     * @param key
     * @return
     */
    @Override
    @SuppressWarnings("unchecked")
    public Object removeObject(Object key) {
        RedisTemplate redisTemplate = getRedisTemplate();
        redisTemplate.delete(key);
        logger.debug("Remove cached query result from redis");
        return null;
    }
    /**
     * Clears this cache instance
     */
    @Override
    public void clear() {
        RedisTemplate redisTemplate = getRedisTemplate();
        redisTemplate.execute((RedisCallback) connection -> {
            connection.flushDb();
            return null;
        });
        logger.debug("Clear all the cached query result from redis");
    }
    @Override
    public int getSize() {
        return 0;
    }
    @Override
    public ReadWriteLock getReadWriteLock() {
        return readWriteLock;
    }
    private RedisTemplate getRedisTemplate() {
        if (redisTemplate == null) {
            RedisConnectionFactory redisFactory = ApplicationContextHolder.getBean("redisConnectionFactory");
            JedisConnectionFactory factory = jedisFactoryBuild(redisFactory);
            Jackson2JsonRedisSerializer<Object> jackson2JsonRedisSerializer = ApplicationContextHolder.getBean("jackson2JsonRedisSerializer");
            redisTemplate = new RedisTemplate<>();
            redisTemplate.setConnectionFactory(factory);
            redisTemplate.setValueSerializer(jackson2JsonRedisSerializer);
            redisTemplate.setKeySerializer(jackson2JsonRedisSerializer);
            redisTemplate.afterPropertiesSet();
        }
        return redisTemplate;
    }
    private JedisConnectionFactory jedisFactoryBuild(RedisConnectionFactory redisConnectionFactory){
        JedisConnectionFactory factory = new JedisConnectionFactory();
        JedisConnectionFactory redisFactory = (JedisConnectionFactory) redisConnectionFactory;
        factory.setHostName(redisFactory.getHostName());
        factory.setClientName(redisFactory.getClientName());
        factory.setConvertPipelineAndTxResults(redisFactory.getConvertPipelineAndTxResults());
        factory.setDatabase(1);
        factory.setPassword(redisFactory.getPassword());
        factory.setPoolConfig(redisFactory.getPoolConfig());
        factory.setPort(redisFactory.getPort());
        factory.setShardInfo(redisFactory.getShardInfo());
        factory.setTimeout(redisFactory.getTimeout());
        factory.setUsePool(redisFactory.getUsePool());
        factory.setUseSsl(false);
        factory.afterPropertiesSet();
        return factory;
    }
}
