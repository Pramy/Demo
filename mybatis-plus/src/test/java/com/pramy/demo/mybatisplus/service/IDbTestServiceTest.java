package com.pramy.demo.mybatisplus.service;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.pramy.demo.mybatisplus.MybatisPlusApplicationTests;
import com.pramy.demo.mybatisplus.po.Node;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.*;

/**
 * IntelliJ IDEA 17
 * Created by Pramy on 2018/2/5.
 */
public class IDbTestServiceTest extends MybatisPlusApplicationTests{

    @Autowired
    private INodeService service;

    private static Logger logger = LoggerFactory.getLogger(IDbTestServiceTest.class);
    @Test
    public void select() throws InterruptedException {
//        System.out.println(service.selectList(new EntityWrapper<Node>().eq("parent_id",1)));
        Node node = new Node();
        node.setId(1);
        System.out.println(service.selectById(1));
    }

}