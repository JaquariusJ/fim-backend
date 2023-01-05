package com.money.fimsystem.config;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import com.money.fimsystem.auth.LoginManager;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Slf4j
@Component
public class MyMetaObjectHandler implements MetaObjectHandler {

    @Override
    public void insertFill(MetaObject metaObject) {
        this.strictInsertFill(metaObject,"createTime",LocalDateTime.class,LocalDateTime.now());
        log.info("==================insert==============user:"+LoginManager.getCurrentUserId());
        this.strictInsertFill(metaObject,"createUser",Long.class, LoginManager.getCurrentUserId());

    }

    @Override
    public void updateFill(MetaObject metaObject) {
        log.info("==================update==============user:"+LoginManager.getCurrentUser());
        this.strictUpdateFill(metaObject,"updateTime",LocalDateTime.class,LocalDateTime.now());
        this.strictUpdateFill(metaObject,"updateUser",Long.class, LoginManager.getCurrentUserId());

    }
}
