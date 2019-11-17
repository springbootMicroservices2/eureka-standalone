package com.example.springboot.rest.client.springbootrestclientdemo;

import java.io.IOException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestClientException;

import com.example.springboot.rest.client.springbootrestclientdemo.controller.ConsumerController;

@SpringBootApplication
public class SpringbootRestClientDemoApplication {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(SpringbootRestClientDemoApplication.class, args);

		ConsumerController consumerControllerClient = ctx.getBean(ConsumerController.class);
		System.out.println(consumerControllerClient);
		try {
			consumerControllerClient.getEmployee();
		} catch (RestClientException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Bean
	public ConsumerController consumerControllerClient() {
		return new ConsumerController();
	}

}
