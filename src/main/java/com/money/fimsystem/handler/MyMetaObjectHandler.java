package com.money.fimsystem.handler;

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
        boolean isvalue = metaObject.hasSetter("createTime");
        if(!isvalue){
            this.setInsertFieldValByName("createTime", LocalDateTime.now(),metaObject);
        }
        this.setInsertFieldValByName("createBy",metaObject.getValue("createBy"),metaObject);

    }

    @Override
    public void updateFill(MetaObject metaObject) {
        Object updateTime = this.getFieldValByName("updateTime", metaObject);
        if(updateTime == null){
            this.setUpdateFieldValByName("updateTime", LocalDateTime.now(),metaObject);
        }

        this.setUpdateFieldValByName("updateBy",metaObject.getValue("updateBy"),metaObject);


    }
}
