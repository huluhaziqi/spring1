package com.lin.spring1.aop.cglib;

public class Test {
    public static void main(String[] args) {
        System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles","true");
        CglibProxy cglibProxy = new CglibProxy();
        Base b = Factory.getInstance(cglibProxy);
        b.add();
    }
}
