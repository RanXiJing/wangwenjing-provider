package com.bwei;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class WangwenjingProviderApplication {

	public static void main(String[] args) {
		SpringApplication.run(WangwenjingProviderApplication.class, args);
	}
}
