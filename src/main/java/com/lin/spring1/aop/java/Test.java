package com.lin.spring1.aop.java;

import java.lang.reflect.Proxy;

public class Test {
    public static void main(String[] args) {
        System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles","true");
        Service service = new AsService();
        MyInvocationHandler m = new MyInvocationHandler(service);
        Service service1 = (Service) Proxy.newProxyInstance(service.getClass().getClassLoader(),service.getClass().getInterfaces(),m);
        service1.add();
        service1.update();
    }
}
