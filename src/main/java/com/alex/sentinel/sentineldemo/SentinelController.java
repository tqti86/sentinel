package com.alex.sentinel.sentineldemo;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Alex on 2020-03-26
 */
@RestController
public class SentinelController {

    @SentinelResource(value = "say")
    @GetMapping("say")
    public String sayHello(){
        System.out.println("hello world");
        return "sayHello";
    }

    @SentinelResource(value = "say2")
    @GetMapping("say2")
    public String sayHello2(){
        System.out.println("hello world");
        return "sayHello";
    }
}
