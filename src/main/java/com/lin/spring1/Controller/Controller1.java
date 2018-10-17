package com.lin.spring1.Controller;

import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Scope
public class Controller1 {

    @RequestMapping("/test1")
    public String health(){
        return "ok";
    }
}
