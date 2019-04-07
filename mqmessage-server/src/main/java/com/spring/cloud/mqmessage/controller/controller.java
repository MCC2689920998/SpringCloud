package com.spring.cloud.mqmessage.controller;

import com.spring.cloud.mqmessage.sender.SinkSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author MCC
 * @Create 2019/4/8 0:14
 */
@RestController
public class controller {

    @Autowired
    SinkSender sinkSender;

    @RequestMapping(path = "/senMessage",method = RequestMethod.GET )
    public String senMessage(){
        sinkSender.output().send(MessageBuilder.
                withPayload("From sinkSender")
                .build());
        return "hello";
    }

}
