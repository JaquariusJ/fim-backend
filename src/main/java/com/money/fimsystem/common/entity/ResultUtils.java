package com.money.fimsystem.common.entity;


import com.money.fimsystem.common.enums.ResultCode;

public class ResultUtils {

    public static ResultResponse success(){
        return new ResultResponse(ResultCode.SUCCESS.getCode(),ResultCode.SUCCESS.getValue());
    }

    public static ResultResponse success(Object object){
        return new ResultResponse(ResultCode.SUCCESS.getCode(),ResultCode.SUCCESS.getValue(),object);
    }


    public static ResultResponse fail(Object object){
        return new ResultResponse(ResultCode.FAIL.getCode(),ResultCode.FAIL.getValue(),object);
    }
}
