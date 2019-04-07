package com.spring.cloud.ribbonhystrix.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.spring.cloud.ribbonhystrix.Command.HelloCommand;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

/**
 * @Author MCC
 * @Create 2019/4/8 2:32
 */
@Service
@Slf4j
public class HelloService {
    @Autowired
    RestTemplate restTemplate;
    @Value("${hello.server.name}")
    private String helloServerName;

    @HystrixCommand(fallbackMethod = "helloFallBack")
    public String helloService(String id){
        log.info("请求地址{}", helloServerName + "/hello");
        String abc="456";
        return restTemplate.getForEntity(helloServerName + "/hello", String.class).getBody();
    }

    public String helloFallBack(String id,Throwable e) {
        log.info("请求地址{},出错", helloServerName + "/hello");
        log.info("出错{}", e.getMessage());
        log.info("出错id{}",id);
        return "Error";
    }

    public String helloService1() {
        log.info("请求地址{}", helloServerName + "/hello");
        return new HelloCommand(restTemplate,helloServerName + "/hello").execute();
    }


}
