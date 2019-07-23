package com.gy.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.lang.reflect.Array;
import java.util.ArrayList;

@Configuration
@PropertySource("classpath:redis.properties")
public class RedisConfig {

    @Value("${spring.redis.host}")
    private String host;

    @Value("${spring.redis.port}")
    private int port;

    @Value("${spring.redis.password}")
    private String password;

    @Value("${spring.redis.timeout}")
    private int timeOut;

    @Value("${spring.redis.jedis.pool.max-idle}")
    private int maxidle;

    @Value("${spring.redis.jedis.pool.max-wait}")
    private Long maxWaitMillis;

    @Value("${spring.redis.block-when-exhausted}")
    private boolean  blockWhenExhausted;

    @Bean
    public JedisPool redisPoolFactory(){
        JedisPoolConfig config = new JedisPoolConfig();
        config.setMaxIdle(maxidle);
        config.setMaxWaitMillis(maxWaitMillis);
        config.setBlockWhenExhausted(blockWhenExhausted);
        config.setJmxEnabled(true);
        JedisPool jedisPool = new JedisPool(config,host,port,timeOut,password);
        return jedisPool;
    }
}
