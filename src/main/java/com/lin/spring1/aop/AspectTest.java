package com.lin.spring1.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AspectTest {

    @Around("execution(* com.lin.spring1.Controller.TestController.*(..))")
    public Object around(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("test01 begin");
        Object result = pjp.proceed();
        System.out.println("test01 end");
        return result;
    }
}
