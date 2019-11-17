package com.example.springboot.rest.springbootrestdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
//
@EnableDiscoveryClient
public class SpringbootRestDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootRestDemoApplication.class, args);
	}

}
