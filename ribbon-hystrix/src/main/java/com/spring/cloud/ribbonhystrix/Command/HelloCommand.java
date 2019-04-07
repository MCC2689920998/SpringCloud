package com.spring.cloud.ribbonhystrix.Command;

import com.netflix.hystrix.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.client.RestTemplate;

/**
 * @Author MCC
 * @Create 2019/4/8 2:47
 */
@Slf4j
public class HelloCommand extends HystrixCommand<String> {
    private RestTemplate restTemplate;
    private String url;

    public HelloCommand(RestTemplate restTemplate,String url) {
        // //最少配置:指定命令组名(CommandGroup)
        // super(HystrixCommandGroupKey.Factory.asKey("ExampleGroup"));
        super(Setter.withGroupKey(HystrixCommandGroupKey.Factory.asKey("ExampleGroup"))
                .andCommandKey(HystrixCommandKey.Factory.asKey("query"))
                .andThreadPoolKey(HystrixThreadPoolKey.Factory.asKey("ExampleThreadPool"))
                .andThreadPoolPropertiesDefaults(HystrixThreadPoolProperties.Setter().withCoreSize(20))//服务线程池数量
                .andCommandPropertiesDefaults(HystrixCommandProperties.Setter()
                        .withCircuitBreakerErrorThresholdPercentage(60) //熔断器关闭到打开阈值
                        .withCircuitBreakerSleepWindowInMilliseconds(3000)//熔断器打开到关闭的时间窗长度
                ));
        this.url = url;
        this.restTemplate = restTemplate;

    }


    @Override
    protected String run() throws Exception {
        return restTemplate.getForEntity(url,String.class).getBody();
    }

    @Override
    protected String getFallback() {
        log.info("请求地址{},出错", url);
        return "Error";
    }

}
