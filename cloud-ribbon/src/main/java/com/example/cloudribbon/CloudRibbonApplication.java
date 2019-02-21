package com.example.cloudribbon;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * 负载均衡
 * ribbon
 * 默认轮询
 * @EnableHystrix 使用熔断机制，防止服务雪崩
 */
@EnableHystrix
@EnableEurekaClient
@SpringBootApplication
public class CloudRibbonApplication {

	public static void main(String[] args) {
		SpringApplication.run(CloudRibbonApplication.class, args);
	}

	/**
	 * RestTemplate http 访问接口
	 * @LoadBalanced 开启负载均衡的功能。
	 * @return
	 */
	@Bean
	@LoadBalanced
	RestTemplate restTemplate() {
		return new RestTemplate();
	}

}
