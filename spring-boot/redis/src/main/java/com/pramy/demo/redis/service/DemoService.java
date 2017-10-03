package com.pramy.demo.redis.service;

import com.pramy.demo.redis.po.Person;

/**
 * IntelliJ IDEA 17
 * Created by Pramy on 2017/10/3.
 */
public interface DemoService {

    Person save(Person person);

    void remove(Long id);

    Person findOne(Person person);
}
