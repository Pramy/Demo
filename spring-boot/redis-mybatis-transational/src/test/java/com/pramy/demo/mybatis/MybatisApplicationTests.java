package com.pramy.demo.mybatis;

import com.pramy.demo.mybatis.dao.PersonMapper;
import com.ulisesbocchio.jasyptspringboot.annotation.EnableEncryptableProperties;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@EnableEncryptableProperties
@RunWith(SpringRunner.class)
@SpringBootTest
public class MybatisApplicationTests {

	@Autowired
	private PersonMapper personMapper;
	@Value("${secret.property:no}")
	private String url;
	@Test
	public void contextLoads() {
		System.out.println(personMapper.selectByPrimaryKey(1L));
		System.out.println(url);
	}

}
