package com.money.fimsystem.common.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public enum ResponseType {

    SUCCESS(200,"Successful","JSON String of process item.Refer to following sample response"),
    BAD_REQUEST(400,"Bad Request","Error message"),
    UNAUTHORIZED(401,"用户名或密码错误","Error message"),
    UNACCESS_DENIED(403,"没有权限访问","Error message"),
    SERVER_ERRROR(500,"Failed,Internal Server Error","Error,message");


    @Getter
    private int code;
    @Getter
    private String message;
    @Getter
    private String desc;
}
