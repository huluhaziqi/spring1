package com.lin.spring1.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

@Aspect
@Configuration
public class MyAspect {

    @Pointcut("execution(* com.lin.spring1.Controller.*.*(..))")
    public void check() {
    }


    @Around("check()")
    public Object function(ProceedingJoinPoint joinPoint) throws Throwable{
        RequestAttributes ra = RequestContextHolder.getRequestAttributes();
        ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) ra;
        HttpServletRequest request = servletRequestAttributes.getRequest();
        HttpServletResponse response = servletRequestAttributes.getResponse();
        Map<String, String[]> params = request.getParameterMap();
        if (params.containsKey("noSign") && params.get("noSign")[0].equals("lxb")) {
            return joinPoint.proceed();
        }else{
            System.out.println("failed");
        }
        return null;
    }
}
