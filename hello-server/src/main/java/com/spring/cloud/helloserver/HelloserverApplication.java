package com.spring.cloud.helloserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;


@EnableEurekaClient
@SpringBootApplication
public class HelloserverApplication {

	public static void main(String[] args) {
		SpringApplication.run(HelloserverApplication.class, args);
	}

}
