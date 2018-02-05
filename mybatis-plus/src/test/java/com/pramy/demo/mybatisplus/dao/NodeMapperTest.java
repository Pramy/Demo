package com.pramy.demo.mybatisplus.dao;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.pramy.demo.mybatisplus.po.Node;
import org.apache.ibatis.session.RowBounds;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * IntelliJ IDEA 17
 * Created by Pramy on 2018/2/4.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class NodeMapperTest {


    @Autowired
    private NodeMapper nodeMapper;
    @Test
    public void test() {
        System.out.println(nodeMapper);
    }

    @Test
    public void insert(){
        Node node = new Node();
        node.setName("三级节点节点");
        node.setParentId(5);
        System.out.println(nodeMapper.insert(node));
    }
    @Test
    public void select(){
        EntityWrapper<Node> warp = new EntityWrapper<>();
        warp.like("name","%二%");
        System.out.println(warp.getSqlSegment());
        List<Node> list = nodeMapper.selectPage(
                new Page<Node>(1,3),warp);
        System.out.println(list);
    }
}