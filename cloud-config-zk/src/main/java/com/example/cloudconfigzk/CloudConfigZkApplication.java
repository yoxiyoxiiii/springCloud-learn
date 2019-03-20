package com.example.cloudconfigzk;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * springcloud 整合zk 去读zk 中的配置信息
 * /config/zk-config/from = value
 * 即 /config/zk-config/from 节点对应的值 是 value
 */
@RefreshScope
@RestController
@SpringBootApplication
public class CloudConfigZkApplication {

	public static void main(String[] args) {
		SpringApplication.run(CloudConfigZkApplication.class, args);
	}

	/**
	 * 读取 zk 配置中心的值
	 */
	@Value("${from}")
	private String from;

	@RequestMapping("/from")
	//动态修改配置文件的值。
	public String from() {
		return this.from;
	}

}
