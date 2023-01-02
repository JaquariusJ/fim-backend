package com.money.fimsystem.common.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ResponseResult<T> {

    private Integer code;

    private String message;

    private T data;


    public static <T> ResponseResult<T> success(T data){
        return new ResponseResult(ResponseType.SUCCESS.getCode(),ResponseType.SUCCESS.getMessage(),data);
    }

    public static ResponseResult success(){
        return new ResponseResult(ResponseType.SUCCESS.getCode(),ResponseType.SUCCESS.getMessage(),"");
    }

    public static ResponseResult failed(ResponseType responseType){
        return new ResponseResult(responseType.getCode(),responseType.getMessage(),"");
    }

    public static ResponseResult failed(ResponseType responseType, String e){
        return new ResponseResult(responseType.getCode(),responseType.getMessage(),e);
    }

    public static ResponseResult failed(String e){
        return new ResponseResult(ResponseType.SERVER_ERRROR.getCode(),ResponseType.SERVER_ERRROR.getMessage(),e);
    }

    public static ResponseResult failed(ResponseType responseType, Exception e){
        return new ResponseResult(responseType.getCode(),responseType.getMessage(),e.getMessage());
    }


}
