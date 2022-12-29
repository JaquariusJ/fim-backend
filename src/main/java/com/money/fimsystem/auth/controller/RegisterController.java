package com.money.fimsystem.auth.controller;

import com.money.fimsystem.auth.entity.User;
import com.money.fimsystem.auth.service.IUserService;
import com.money.fimsystem.common.entity.ResponseBuilder;
import com.money.fimsystem.common.entity.ResultResponse;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class RegisterController {

    @Autowired
    private IUserService userService;

    @RequestMapping("/registry")
    public ResultResponse register(@RequestBody User user){
        userService.save(user);
        //
        return ResponseBuilder.success("registry success");
    }








}

