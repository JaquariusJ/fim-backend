package com.money.fimsystem.user.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.money.fimsystem.minio.ObjectMemory;
import com.money.fimsystem.user.entity.User;
import com.money.fimsystem.user.service.IUserService;
import com.money.fimsystem.common.entity.ResponseBuilder;
import com.money.fimsystem.common.entity.ResultResponse;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.assertj.core.util.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@RestController
@Slf4j
@RequestMapping("/registry")
public class RegisterController {

    @Autowired
    private IUserService userService;

    @Autowired
    private ObjectMemory objectMemory;

    @RequestMapping("/createUser")
    public ResultResponse createUser(@RequestBody User user){
        userService.registryUser(user);
        return ResponseBuilder.success(user);
    }


    @PostMapping("/uploadUserHeadImg")
    public ResultResponse uploadHeadImg(MultipartFile multipartFile) throws IOException {
        InputStream fileInputStream = multipartFile.getInputStream();
        return ResponseBuilder.success();
    }


    @RequestMapping("/checkUserExist")
    public ResultResponse checkUserExist(@RequestParam("username")String username){
        List<User> existUsers = userService.getUserByName(username);
        boolean exist = !Objects.isNull(existUsers) && existUsers.size() > 0;
        return ResponseBuilder.success(exist);
    }






}

