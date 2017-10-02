package com.pramy.demo.thymeleaf.controller;

import com.pramy.demo.thymeleaf.po.Person;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * IntelliJ IDEA 17
 * Created by Pramy on 2017/10/2.
 */
@Controller
@SpringBootApplication
public class PersonController {

    @RequestMapping("/")
    public String index(Model model) {
        Person single = new Person("aa", 11);
        Person p1 = new Person("xx", 11);
        Person p2 = new Person("yy", 22);
        Person p3 = new Person("zz", 33);
        List<Person> people = new ArrayList<>();
        people.add(p1);
        people.add(p2);
        people.add(p3);

        model.addAttribute("singlePerson", single);
        model.addAttribute("people", people);

        return "index";
    }

    public static void main(String[] args) {
        SpringApplication.run(PersonController.class, args);
    }
}
