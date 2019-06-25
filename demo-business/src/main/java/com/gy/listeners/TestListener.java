package com.gy.listeners;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

/**
 * 消息监听类
 * @author guyu
 */
@Component
public class TestListener {

    @JmsListener(destination = "testTopic")
    public void consumer(String context){
        System.out.println("listener get message:"+context);
    }
}
