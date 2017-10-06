package com.pramy.demo.mybatis.service;

import com.pramy.demo.mybatis.po.Person;

import java.rmi.activation.ActivationException;

/**
 * IntelliJ IDEA 17
 * Created by Pramy on 2017/10/5.
 */
public interface PersonService {

    int deleteByPrimaryKey(Long id);

    Person insert(Person record);

    Person selectByPrimaryKey(Long id);


}
