package com.lin.spring1.redis;


import com.lin.spring1.redis.annonimate.RedisAnnotation;
import com.lin.spring1.redis.utils.LockUtil;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import redis.clients.jedis.Jedis;

import java.lang.reflect.Method;
import java.util.UUID;

@Aspect
@Component
public class JedisAspect {

    private static final Logger logger = LoggerFactory.getLogger(JedisAspect.class);

    private static final long maxExpireTime = 60 * 1000L;
    private static final long waitTime = 1 * 1000L;
    private static final long maxDelayTime = 10 * 1000L;

    @Autowired
    private JedisService jedisService;


    @Around(value = "@annotation(redisAnnotation)")
    public Object invoke(ProceedingJoinPoint pjp, RedisAnnotation redisAnnotation) throws Throwable {
        Class<?> clazz = pjp.getClass();
        MethodSignature methodSignature = (MethodSignature) pjp.getSignature();
        Method method = methodSignature.getMethod();
        String className = clazz.getName();
        String methodName = method.getName();
        logger.info("clazzName {}, methodName {}, redisAnnotation.value {}", className, method, redisAnnotation.value());
        if (StringUtils.isEmpty(redisAnnotation.value())) {
            return pjp.proceed();
        }
        Jedis jedis = jedisService.getJedis();
        long expireTime = (redisAnnotation.expires() >= 0) ? redisAnnotation.expires() : maxExpireTime;
        String value = UUID.randomUUID().toString();
        try {
            if (redisAnnotation.justOnce()) {
                if (LockUtil.tryGetLock(jedis, redisAnnotation.value(), value, expireTime)) {
                    return doJob(pjp, redisAnnotation.value(), value, maxDelayTime);
                }
            } else {
                while (!LockUtil.tryGetLock(jedis, redisAnnotation.value(), value, expireTime)) {
                    Thread.sleep(waitTime);
                }
                return doJob(pjp, redisAnnotation.value(), value, 0);
            }
        } finally {
            jedis.close();
        }
        return null;
    }


    private Object doJob(ProceedingJoinPoint pjp, String key, String requestId, long maxDelayTime) throws Throwable {
        Object object = pjp.proceed();
        Thread.sleep(maxDelayTime);
        Jedis jedis = jedisService.getJedis();
        try {
            LockUtil.tryRelease(jedis, key, requestId);
        } finally {
            jedis.close();
        }
        return object;
    }

}
