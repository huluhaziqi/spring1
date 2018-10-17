package com.lin.spring1.service;

import org.springframework.beans.factory.DisposableBean;

public class ExampleBean implements DisposableBean{
    @Override
    public void destroy() throws Exception {
        System.out.println("ExampleBean destroy !");
    }
}
