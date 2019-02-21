package com.example.cloudzuul;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.cloud.netflix.zuul.EnableZuulServer;

/**
 * @EnableZuulProxy 启用 zuul 网关
 */
@EnableZuulProxy
@EnableEurekaClient
@SpringBootApplication
public class CloudZuulApplication {

	public static void main(String[] args) {
		SpringApplication.run(CloudZuulApplication.class, args);
	}

}
