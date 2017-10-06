package com.pramy.demo.mybatis.controller;

import com.pramy.demo.mybatis.po.Person;
import com.pramy.demo.mybatis.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.rmi.activation.ActivationException;

/**
 * IntelliJ IDEA 17
 * Created by Pramy on 2017/10/5.
 */
@RestController
public class PersonController {

    @Autowired
    private PersonService personService;

    @PostMapping("insert.do")
    public Person insert(Person person) {
        return personService.insert(person);
    }

    @PostMapping("delete.do")
    public int delete(Long id){
        return personService.deleteByPrimaryKey(id);
    }

    @RequestMapping("select.do")
    public Person select(Long id){
        return personService.selectByPrimaryKey(id);
    }
}
