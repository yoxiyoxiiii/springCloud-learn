package com.example.cloudfegin;

import org.springframework.stereotype.Component;

@Component
public class IHelloSreviceFallback implements IHelloSrevice {
    @Override
    public String home(String name) {
        return "hi,"+name+",sorry,error!";
    }
}
