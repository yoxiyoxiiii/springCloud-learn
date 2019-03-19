package com.example.cloudeurekaclient;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

/**
 * eureka 客户端
 * @EnableEurekaClient
 * 会将服务注册中eureka 注册中心
 */
@RestController
@SpringBootApplication
@EnableEurekaClient
public class CloudEurekaClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(CloudEurekaClientApplication.class, args);
	}

	@Value("${server.port}")
	String port;

	@RequestMapping("/hi")
	public String home(@RequestParam(value = "name", defaultValue = "forezp") String name) throws InterruptedException {
		//hystrix 熔断机制测试
		Random random = new Random();
		int i = random.nextInt(5000);
		System.out.println("sleep = " + i + " ms ");
		Thread.sleep(i);
		return "hi " + name + " ,i am from port:" + port;
	}

}
