package com.spring.cloud.mqmessage.receiver;

import com.spring.cloud.mqmessage.entity.User;
import com.spring.cloud.mqmessage.sender.SinkSender;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;

/**
 * @Author MCC
 * @Create 2019/4/7 21:10
 */
@EnableBinding(value ={Sink.class} )
@Slf4j
public class SinkReceiver1 {

    @StreamListener(Sink.INPUT)
    public void receive(User user) {
        System.out.println("Receive :" + user);
        log.info("Receive :" + user);
    }
}
