package com.zineb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient 
public class ServiceProfesseursApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServiceProfesseursApplication.class, args);
	}

}
