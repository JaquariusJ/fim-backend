package com.money.fimsystem.config;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
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
        String createUser = (String) metaObject.getValue("userid");
        this.strictInsertFill(metaObject,"createUser",String.class,createUser);

    }

    @Override
    public void updateFill(MetaObject metaObject) {
        this.strictInsertFill(metaObject,"updateTime",LocalDateTime.class,LocalDateTime.now());
        String updateUser = (String) metaObject.getValue("userid");
        this.strictInsertFill(metaObject,"updateUser",String.class,updateUser);

    }
}
