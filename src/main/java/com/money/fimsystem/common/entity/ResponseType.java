package com.money.fimsystem.common.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum ResponseType {

    SUCCESS(200,"Successful","JSON String of process item.Refer to following sample response"),
    BAD_REQUEST(400,"Bad Request","Error message"),
    UNAUTHORIZED(401,"用户名或密码错误","Error message"),
    UNACCESS_DENIED(403,"没有权限访问","Error message"),
    SERVER_ERRROR(500,"Failed,Internal Server Error","Error,message");


    private int code;
    private String message;
    private String desc;
}
