package com.pramy.demo.mybatis;

import com.pramy.demo.mybatis.po.Person;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import java.util.Random;
import static org.assertj.core.api.Java6Assertions.*;
/**
 * IntelliJ IDEA 17
 * Created by Pramy on 2017/10/5.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class RedisConfigureTest {


    @LocalServerPort
    private int port;
    @Autowired
    private TestRestTemplate restTemplate;

    private MultiValueMap<Object, Object> form = new LinkedMultiValueMap<>();

    private static final String ADDRESS="http://localhost:";
    @Test
    public void test() {
        long productId = 9;
        System.out.println(port);
        Person product = restTemplate.getForObject(ADDRESS+ port + "/select.do?id=" + productId, Person.class);
        System.out.println(product);
        assertThat(product.getAge()).isEqualTo(18);
        Person newProduct = new Person();
        int newPrice = new Random().nextInt();
        newProduct.setName("new name");
        newProduct.setAge(newPrice);
        form.add("name","???");
        restTemplate.postForObject(ADDRESS + port + "/insert.do", form,Person.class);
        Person testProduct = restTemplate.getForObject(ADDRESS + port + "/select.do?id=" + productId, Person.class);
        System.out.println(testProduct);
        assertThat(testProduct.getAge()).isEqualTo(18);
    }

}