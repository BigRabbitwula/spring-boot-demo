package com.gy.controller;

import com.gy.api.Test;
import com.gy.vo.UserVO;
import org.apache.activemq.command.ActiveMQTopic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.util.HashMap;
import javax.jms.Destination;

/**
 * @Description 用户接口类
 * @Author guyu
 * @Date 2019/1/11 18:10
 * @Version 1.0
 * @Precept 千里之行，始于足下
 */
@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private JedisPool jedisPool;

    @Autowired
    private JmsTemplate jmsTemplate;

    /**
     * 获取用户信息接口
     * @Author guyu
     * @Date 2019/1/11 18:10
     */
    @RequestMapping("/getUserInfo.do")
    public Object getUserInfo(){
        HashMap<String,Object> result = new HashMap<>();
        Test test = new Test();
        result.put("code",0);
        result.put("data",test);
        try{
            Jedis jedis = jedisPool.getResource();
            jedis.set("guyu","hello word");
            String aa = jedis.get("guyu");
            System.out.println(aa);
        }catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }

    @RequestMapping("sendMqMessage.do")
    public Object sendMqMessage(){
        Destination destination = new ActiveMQTopic("testTopic3");
        jmsTemplate.convertAndSend(destination,"mq成功啦");
        return new UserVO();
    }

    @JmsListener(destination = "testTopic3")
    public void Listener2(String context){
        System.out.println("listener2 get message :"+context);
    }


}
