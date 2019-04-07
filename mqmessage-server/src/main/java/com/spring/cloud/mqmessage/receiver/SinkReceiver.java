package com.spring.cloud.mqmessage.receiver;

import com.spring.cloud.mqmessage.sender.SinkSender;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.cloud.stream.messaging.Source;

/**
 * @Author MCC
 * @Create 2019/4/7 21:10
 */
@EnableBinding(value ={Sink.class, SinkSender.class} )
@Slf4j
public class SinkReceiver {

    @StreamListener(Sink.INPUT)
    public void receive(Object o) {
        System.out.println("Receive :" + o);
        log.info("Receive :" + o);
    }
}
