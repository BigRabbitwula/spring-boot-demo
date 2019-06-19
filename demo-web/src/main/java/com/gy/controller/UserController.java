package com.gy.controller;

import com.gy.api.Test;
import com.gy.config.RedisConfig;
import com.gy.vo.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.util.HashMap;

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

    /**
     * 获取用户信息接口
     * @Author guyu
     * @Date 2019/1/11 18:10
     */
    @RequestMapping("/getUserInfo.do")
    @ResponseBody
    public Object getUserInfo(){
        HashMap result = new HashMap(3);
        UserVO vo = new UserVO();
        Test test = new Test();
        result.put("code",0);
        result.put("data",test);
        try{
            Jedis jedis = jedisPool.getResource();
//            jedis.set("guyu","hello word");
            String aa = jedis.get("guyu");
            System.out.println(aa);
        }catch (Exception e){
            e.printStackTrace();
        }

        return result;
    }
}
