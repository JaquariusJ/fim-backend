package com.money.fimsystem.business.test.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {


    @RequestMapping("/success")
    public String success(){
        return "success";
    }

    @RequestMapping("/r1")
    public String r1(){
        return "r1";
    }

    @RequestMapping("/r2")
    public String r2(){
        return "r2";
    }

}
