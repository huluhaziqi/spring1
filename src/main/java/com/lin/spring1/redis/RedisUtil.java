package com.lin.spring1.redis;

import redis.clients.jedis.JedisPoolConfig;
import redis.clients.jedis.JedisSentinelPool;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class RedisUtil {

    private final static String REDIS_HOST = "10.2.155.157";
    private final static Integer REDIS_PORT = 6379;
    private final static Integer REDIS_MaxActive = 200;
    private final static Integer REDIS_MaxIdle = 1000;
    private final static Integer REDIS_MaxWait = 512;
    private final static Integer REDIS_ConnTimeout = 2000;
    private final static Integer REDIS_RetryNum = 3;
    private final static String SENTINEL_HOST_1 = "10.2.155.157:26381";
    private final static String SENTINEL_HOST_2 = "10.2.155.157:26380";
    private final static String SENTINEL_HOST_3 = "10.2.155.157:26379";
    private final static String CLUSTER_NAME = "master";

    public RedisUtil() {
    }

    private static Map<String, JedisSentinelPool> map = new HashMap<>();

    private static JedisSentinelPool getPool() {
        String key = REDIS_HOST + ":" + REDIS_PORT;
        Set<String> sentinels = new HashSet<>();
        String host1 = SENTINEL_HOST_1;
        String host2 = SENTINEL_HOST_2;
        sentinels.add(host1);
        sentinels.add(host2);
        JedisSentinelPool jedisSentinelPool = null;
        if (!map.containsKey(key)) {
            JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
            jedisPoolConfig.setMaxTotal(REDIS_MaxActive);
            jedisPoolConfig.setMaxIdle(REDIS_MaxIdle);
            jedisPoolConfig.setMaxWaitMillis(REDIS_MaxWait);
            jedisPoolConfig.setTestOnBorrow(true);
            jedisPoolConfig.setTestOnReturn(true);
        } else {
            jedisSentinelPool = map.get(key);
        }
        return jedisSentinelPool;
    }

}
