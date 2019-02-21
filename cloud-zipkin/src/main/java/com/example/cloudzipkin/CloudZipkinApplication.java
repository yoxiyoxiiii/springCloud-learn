package com.example.cloudzipkin;

import brave.sampler.Sampler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * zipkin 链路跟踪
 * 测试
 */
@Slf4j
@RestController
@SpringBootApplication
public class CloudZipkinApplication {

	public static void main(String[] args) {
		SpringApplication.run(CloudZipkinApplication.class, args);
	}

	@Autowired
	private RestTemplate restTemplate;

	@Bean
	public RestTemplate getRestTemplate(){
		return new RestTemplate();
	}

	@RequestMapping("/hi")
	public String callHome(){
		log.info("calling trace service-hi  ");
		return restTemplate.getForObject("http://localhost:1600/miya", String.class);
	}

	@RequestMapping("/info")
	public String info(){
		log.info("calling trace service-hi ");
		return "i'm service-hi";

	}
	@Bean
	public Sampler defaultSampler() {
		return Sampler.ALWAYS_SAMPLE;
	}

	//
	public void timer() {

	}

}
