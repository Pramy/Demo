package com.pramy.demo.redis.service;

import com.pramy.demo.redis.po.Person;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 * IntelliJ IDEA 17
 * Created by Pramy on 2017/10/3.
 */
@Service
public class DemoServiceImpl implements DemoService {



    @CachePut(value = "people")
    @Override
    public Person save(Person person) {
        System.out.println("为id,key为："+person.getId()+"做了缓存");
        return person;
    }

    @CacheEvict(value = "people",beforeInvocation = true,allEntries = true)
    @Override
    public void remove(Long id) {
        System.out.println("删除id,key为："+id+"做了缓存");
    }
    @Cacheable(value = "people")
    @Override
    public Person findOne(Person person) {
        System.out.println("为id,key为："+person.getId()+"做了缓存");
        return person;
    }
}
