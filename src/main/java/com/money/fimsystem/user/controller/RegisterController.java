package com.money.fimsystem.user.controller;

import com.fasterxml.jackson.annotation.ObjectIdGenerator;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.money.fimsystem.common.constants.GLOBAL_CONST;
import com.money.fimsystem.common.entity.ResponseResult;
import com.money.fimsystem.minio.ObjectMemory;
import com.money.fimsystem.user.entity.User;
import com.money.fimsystem.user.observer.RegistryUserSubject;
import com.money.fimsystem.user.service.IUserService;
import io.lettuce.core.ScriptOutputType;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.velocity.shaded.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@RestController
@Slf4j
@RequestMapping("/registry")
public class RegisterController {

    @Autowired
    private IUserService userService;

    @Autowired
    private ObjectMemory objectMemory;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private RegistryUserSubject registryUserSubject;

    @RequestMapping("/createUser")
    public ResponseResult createUser(@RequestBody User user){
        String password = user.getPassword();
        String passWordEncoder = passwordEncoder.encode(password);
        user.setPassword(passWordEncoder);
        userService.registryUser(user);
        //通知观察者进行后续动作
        registryUserSubject.notifyObservers(user);
        return ResponseResult.success(user);
    }


    @PostMapping("/uploadUserHeadImg")
    public ResponseResult uploadHeadImg(@RequestParam("file")MultipartFile multipartFile) throws Exception {
        InputStream fileInputStream = multipartFile.getInputStream();
        String oldName = multipartFile.getOriginalFilename();
        String extension = FilenameUtils.getExtension(oldName);
        String uuid = UUID.randomUUID().toString();
        String newFileName = StringUtils.join(uuid, ".", extension);
        String minioPath = Paths.get(GLOBAL_CONST.MINIO_USER_HEADIMG_PREFIX, newFileName).toString();
        objectMemory.uploadFile(minioPath,fileInputStream,multipartFile.getSize());
        return ResponseResult.success(newFileName);
    }


    @RequestMapping("/checkUserExist")
    public ResponseResult checkUserExist(@RequestParam("username")String username){
        List<User> existUsers = userService.getUserByName(username);
        boolean exist = !Objects.isNull(existUsers) && existUsers.size() > 0;
        return ResponseResult.success(exist);
    }



}

