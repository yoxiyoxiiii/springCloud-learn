package com.example.cloudeureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * eureka注册中心
 * @author Administrator
 * @EnableEurekaServer
 * 开启
 */
@SpringBootApplication
@EnableEurekaServer
public class CloudEurekaApplication {

	public static void main(String[] args) {
		SpringApplication.run(CloudEurekaApplication.class, args);
	}

}
