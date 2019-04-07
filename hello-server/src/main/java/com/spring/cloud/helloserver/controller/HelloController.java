package com.spring.cloud.helloserver.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Random;

/**
 * @Author MCC
 * @Create 2019/4/3 21:24
 */
@RefreshScope
@RestController
@Slf4j
public class HelloController {

    @Value("${from}")
    String from;

    @Autowired
    private DiscoveryClient client;

    @RequestMapping(value = "/hello",method = RequestMethod.GET)
    public String index() throws InterruptedException {
        List<ServiceInstance> instances = client.getInstances("hello-server");
        int sleepTime = new Random().nextInt(3000);
        System.out.println(sleepTime);
        //Thread.sleep(sleepTime);
        log.info("服务数量",instances.size());
        return from;
    }

}
