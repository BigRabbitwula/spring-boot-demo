package com.gy.listeners;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

/**
 * 消息监听类
 * @author guyu
 */
@Component
public class TestListener {

    @JmsListener(destination = "testTopic3")
    public void consumer(String context){
        System.out.println("listener get message:"+context);
    }

    public void test(int c){
        System.out.println(c);
        try{
            int a = 1;
            a+=2;
            System.out.println(a);
        }catch (Exception e){

        }

    }
}
