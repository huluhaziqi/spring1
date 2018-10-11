package com.lin.spring1.aop.cglib;

import org.springframework.cglib.proxy.Enhancer;

public class Factory {

    public static Base getInstance(CglibProxy cglibProxy){
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(Base.class);
        enhancer.setCallback(cglibProxy);
        return (Base) enhancer.create();
    }
}
