package com.money.fimsystem.common.entity;

import lombok.Data;

@Data
public class ResultResponse<T> {

    private int code;
    private String message;
    private T data;



    public ResultResponse(int code, String message) {
        this.code = code;
        this.message = message;
    }


    public ResultResponse(int code, String value, T object) {
        this.code = code;
        this.message = value;
        this.data = object;
    }
}
