package com.pramy.demo.mybatis.service;

import com.pramy.demo.mybatis.dao.PersonMapper;
import com.pramy.demo.mybatis.po.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * IntelliJ IDEA 17
 * Created by Pramy on 2017/10/5.
 */
@Service
public class PersonServiceImpl implements PersonService {

    @Autowired
    private PersonMapper personMapper;


    @Override
    public int deleteByPrimaryKey(Long id) {
        return personMapper.deleteByPrimaryKey(id);
    }

    /**
     * 1.spring boot 默认开启事务管理器
     * 2.Transactional 注解默认回滚RuntimeException或其子类，如果希望回滚其他Exception可以使用rollBackFor属性
     *   如果不希望回滚某种Exception的话可以使用noRollBackFor
     *
     */
    @Transactional
    @Override
    public Person insert(Person record) {
        personMapper.insert(record);
        return record;
    }

    @Cacheable(value = "person",key = "#id")
    @Override
    public Person selectByPrimaryKey(Long id) {
        System.out.println("从数据库查询");
        return personMapper.selectByPrimaryKey(id);
    }
}
