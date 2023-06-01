package com.ecommerce.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class GatewayApp {

	
	public static void main(String[] args) {
	SpringApplication.run(GatewayApp.class, args);	
	}
}
