package com.lin.spring1.aop.java;

public class AsService implements Service {
    @Override
    public void add() {
        System.out.println("add");
    }

    @Override
    public void update() {
        System.out.println("update");
    }
}
