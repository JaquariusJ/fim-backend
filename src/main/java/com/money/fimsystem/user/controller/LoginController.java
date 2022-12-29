package com.money.fimsystem.user.controller;

import com.money.fimsystem.user.entity.User;
import com.money.fimsystem.common.entity.ResponseBuilder;
import com.money.fimsystem.common.entity.ResultResponse;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class LoginController {

    @RequestMapping("/login")
    public ResultResponse login(@RequestBody User user){
        log.info(String.valueOf(user));
        if(!(StringUtils.equalsAnyIgnoreCase("admin",user.getUsername(),user.getPassword()))){
            return ResponseBuilder.fail("用户名或密码错误");
        }
        return ResponseBuilder.success("login success");
    }


}
