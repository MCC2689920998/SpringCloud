package com.spring.cloud.ribbonhystrix.controller;

import com.spring.cloud.ribbonhystrix.service.HelloService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @Author MCC
 * @Create 2019/4/8 0:14
 */
@RestController
@Slf4j
public class Controller {

    @Autowired
    RestTemplate restTemplate;
    @Autowired
    HelloService helloService;
    @Value("${hello.server.name}")
    private String helloServerName;

    @RequestMapping(path = "/sendMessage", method = RequestMethod.GET)
    public String senMessage() {
        log.info("请求地址{}",helloServerName+"/hello");
        return restTemplate.getForEntity(helloServerName + "/hello", String.class).getBody();
    }

    @RequestMapping(path = "/sendUser", method = RequestMethod.GET)
    public String senUser() {
        try {
            return helloService.helloService("123");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "1";
    }

    @RequestMapping(path = "/sendHello", method = RequestMethod.GET)
    public String sendHello() {
        return helloService.helloService1();
    }
}
