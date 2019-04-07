package com.spring.cloud.mqmessage.receiver;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.MessageChannel;

public interface Receiver<T> {

    void receive(T t);
}
