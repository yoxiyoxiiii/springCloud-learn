package com.example.cloudfegin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * fegin 远程调用
 * 默认集成ribbon和Hystrix
 * ribbon 使用轮询的模式
 */
@EnableFeignClients
@EnableEurekaClient
@SpringBootApplication
public class CloudFeginApplication {

	public static void main(String[] args) {
		SpringApplication.run(CloudFeginApplication.class, args);
	}

}
