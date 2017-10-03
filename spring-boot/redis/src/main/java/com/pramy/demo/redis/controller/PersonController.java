package com.pramy.demo.redis.controller;

import com.pramy.demo.redis.po.Person;
import com.pramy.demo.redis.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * IntelliJ IDEA 17
 * Created by Pramy on 2017/10/3.
 */
@RestController
public class PersonController {

    public static long id=0;

    @Autowired
    DemoService demoService;

    @RequestMapping("/put")
    public Person put(Person person) {
        System.out.println(person);
        return demoService.save(person);
    }

    @RequestMapping("/able")
    public Person cacheable(Person person) {
        System.out.println(person);
        return demoService.findOne(person);
    }

    @RequestMapping("/evit")
    public String evit(Long id) {
        demoService.remove(id);
        return "OK";
    }


    @RequestMapping("/hello")
    public String index() {
        return "Hello World";
    }
}
