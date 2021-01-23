package com.money.fimsystem.common.enums;

import lombok.Data;


public enum ResultCode {
    SUCCESS(200,"success"),
    FAIL(400,"request error");

    int code;
    String value;


    ResultCode(int code,String value){
        this.code = code;
        this.value = value;
    }

    ResultCode(String value){
        this.code = code;
        this.value = value;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
