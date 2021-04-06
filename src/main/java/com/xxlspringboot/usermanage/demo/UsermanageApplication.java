package com.xxlspringboot.usermanage.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@ComponentScan({"com.xxlspringboot.usermanage.controller", "com.xxlspringboot.usermanage.service",
		"com.xxlspringboot.usermanage.aop"})
@EntityScan("com.xxlspringboot.usermanage.entity")
@EnableJpaRepositories("com.xxlspringboot.usermanage.repository")
@SpringBootApplication
@EnableSwagger2
public class UsermanageApplication {

	public static void main(String[] args) {
		SpringApplication.run(UsermanageApplication.class, args);
	}

}
