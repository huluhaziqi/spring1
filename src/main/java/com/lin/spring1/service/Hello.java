package com.lin.spring1.service;

public class Hello {

    private String message;

    private Test test;

    public void setMessage(String message){
        this.message = message;
    }
    public void getMessage(){
        System.out.println("Your Message : " + message);
    }
    public void init(){
        System.out.println("Bean is going through init.");
    }
    public void destroy() {
        System.out.println("Bean will destroy now.");
    }

    public Test getTest() {
        return test;
    }

    public void setTest(Test test) {
        this.test = test;
    }
}
