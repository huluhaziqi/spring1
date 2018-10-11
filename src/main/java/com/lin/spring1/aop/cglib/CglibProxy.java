package com.lin.spring1.aop.cglib;

import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class CglibProxy implements MethodInterceptor {
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("before ----->");
        methodProxy.invokeSuper(o,objects);
        System.out.println("after ->>>>>>>");
        return null;
    }
}
