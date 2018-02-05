package com.pramy.demo.mybatisplus;

import com.baomidou.mybatisplus.plugins.PerformanceInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@MapperScan("com.pramy.demo.mybatisplus.dao")
@SpringBootApplication
public class MybatisPlusApplication {

	public static void main(String[] args) {
		SpringApplication.run(MybatisPlusApplication.class, args);
	}
	@Bean
	@Profile({"dev","test"})
	public PerformanceInterceptor performanceInterceptor() {
		PerformanceInterceptor per = new PerformanceInterceptor();
		per.setMaxTime(100);
		return per;
	}
}
