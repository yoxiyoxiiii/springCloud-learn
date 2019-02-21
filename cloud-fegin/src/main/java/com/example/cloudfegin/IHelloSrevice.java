package com.example.cloudfegin;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 声明fegin 接口
 * 指定调用的服务
 * fallback fegin 默认使用hystrix ，fallback 指定熔断处理
 */
@FeignClient(name = "EUREKA-CLIENT",fallback = IHelloSreviceFallback.class)
public interface IHelloSrevice {

    /**
     * 接口声明
     * @param name
     * @return
     */
    @RequestMapping("/hi")
    String home(@RequestParam(value = "name", defaultValue = "forezp") String name);
}
