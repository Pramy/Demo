package com.pramy.demo.mybatis;

import com.ulisesbocchio.jasyptspringboot.annotation.EnableEncryptableProperties;
import org.jasypt.util.text.BasicTextEncryptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

@MapperScan("com.pramy.demo.mybatis.dao")
@SpringBootApplication
public class MybatisApplication {

    public static void main(String[] args) {
//        SpringApplication.run(MybatisApplication.class, args);
        BasicTextEncryptor basicTextEncryptor = new BasicTextEncryptor();
        basicTextEncryptor.setPassword("pramy");
        System.out.println(basicTextEncryptor.encrypt("root"));
        System.out.println(basicTextEncryptor.encrypt("jdbc:mysql://localhost:3306/test?useSSL=false"));
    }


}
