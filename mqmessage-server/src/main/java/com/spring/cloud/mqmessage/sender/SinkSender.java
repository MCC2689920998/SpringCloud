package com.spring.cloud.mqmessage.sender;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.MessageChannel;


/**
 * @Author MCC
 * @Create 2019/4/7 22:33
 */
public interface SinkSender {

    @Output(Source.OUTPUT)
    MessageChannel output();
}
