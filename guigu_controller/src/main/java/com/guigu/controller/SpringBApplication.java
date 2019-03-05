package com.guigu.controller;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@MapperScan("com.guigu.dao.*")
//2开启事务注解
@EnableTransactionManagement
@ServletComponentScan
@SpringBootApplication(scanBasePackages = { "com.guigu.*" })
public class SpringBApplication {
	public static void main(String[] args) {
		// 启动Spring Boot项目的唯一入口
		SpringApplication sa = new SpringApplication(SpringBApplication.class);
		sa.run(args);
	}
}
