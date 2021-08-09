package com.eureka.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class SpringEurekaUserApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringEurekaUserApplication.class, args);
	}
}
