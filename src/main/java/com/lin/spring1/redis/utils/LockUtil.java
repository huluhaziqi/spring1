package com.lin.spring1.redis.utils;

import redis.clients.jedis.Jedis;

import java.util.Collections;

public class LockUtil {

    private static final String SUCCESS = "ok";
    private static final String SET_IF_NOT_EXIST = "NX";
    private static final String SET_WITH_EXPIRE_TIME = "PX";
    private static final Long RELEASE_SUCCESS = 1L;


    public static boolean tryGetLock(Jedis jedis, String lockKey, String requestId, Long expireTime) {
        String result = jedis.set(lockKey, requestId, SET_IF_NOT_EXIST, SET_WITH_EXPIRE_TIME, expireTime);
        if (result.equals(SUCCESS)) {
            return true;
        }
        return false;
    }


    public static boolean tryRelease(Jedis jedis, String lockKey, String requestId) {
        String script = "if redis.call('get',KEYS[1]) == ARGV[1] then return redis.call('del',KEYS[1]) else return 0 end";
        Object object = jedis.eval(script, Collections.singletonList(lockKey), Collections.singletonList(requestId));
        if (RELEASE_SUCCESS.equals(object)) {
            return true;
        }
        return false;
    }

}
