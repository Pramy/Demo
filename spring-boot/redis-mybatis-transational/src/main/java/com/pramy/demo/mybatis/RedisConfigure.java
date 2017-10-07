package com.pramy.demo.mybatis;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.pramy.demo.mybatis.po.Person;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;

import java.lang.reflect.Method;
import java.util.Objects;

/**
 * IntelliJ IDEA 17
 * Created by Pramy on 2017/10/3.
 */
@Configuration
@EnableCaching
public class RedisConfigure extends CachingConfigurerSupport {


    /**
     * 自定义默认的id生成器的生成规则
     * @return KeyGenerator
     */
    @Bean
    public KeyGenerator keyGenerator() {
        return (Object target, Method method, Object... params)->{
            StringBuilder sb = new StringBuilder();
            sb.append(target.getClass().getName())
              .append(".");
            for (Object o:params
                 ) {
                if(o instanceof Person){
                    sb.append(((Person)o).getId());
                }
            }
            return sb.toString();
        };
    }

    /**
     * 设置缓存的过期时间，单位为秒
     * @return RedisCacheManager
     */
    @Bean
    public CacheManager cacheManager(RedisTemplate redisTemplate) {
        RedisCacheManager rcm = new RedisCacheManager(redisTemplate);
        rcm.setDefaultExpiration(600);
        return rcm;
    }

    /**
     * 创建redis的连接，默认使用database 0
     * @return redisTemplate
     */
    @Bean
    public RedisTemplate<Object,Object> redisTemplate(RedisConnectionFactory factory,Jackson2JsonRedisSerializer jackson2JsonRedisSerializer){
        RedisTemplate<Object,Object> redisTemplate = new RedisTemplate<>();
        redisTemplate.setConnectionFactory(factory);
        redisTemplate.setValueSerializer(jackson2JsonRedisSerializer);
        redisTemplate.setKeySerializer(jackson2JsonRedisSerializer);
        redisTemplate.afterPropertiesSet();
        return redisTemplate;
    }

    /**
     * 定义 redis的序列化模式
     * @return jackson2JsonRedisSerializer
     */
    @Bean Jackson2JsonRedisSerializer<Object> jackson2JsonRedisSerializer(){
        Jackson2JsonRedisSerializer<Object> jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer<>(Object.class);
        ObjectMapper om = new ObjectMapper();
        om.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
        om.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
        jackson2JsonRedisSerializer.setObjectMapper(om);
        return jackson2JsonRedisSerializer;
    }
}
