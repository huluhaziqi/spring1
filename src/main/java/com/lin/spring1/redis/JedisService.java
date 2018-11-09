package com.lin.spring1.redis;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;

@Service
public class JedisService {

    @Autowired
    private JedisConnectionFactory jedisConnectionFactory;

    private static final Logger logger = LoggerFactory.getLogger(JedisService.class);


    public Jedis getJedis(){
        RedisConnection jedisConnection = jedisConnectionFactory.getConnection();
        jedisConnection.select(0);
        return (Jedis) jedisConnection.getNativeConnection();
    }
}
