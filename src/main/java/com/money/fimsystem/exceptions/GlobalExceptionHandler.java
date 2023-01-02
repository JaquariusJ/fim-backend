package com.money.fimsystem.exceptions;

import com.money.fimsystem.common.entity.ResponseResult;
import com.money.fimsystem.common.entity.ResponseType;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@Slf4j
@ResponseBody
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(AuthenticationException.class)
    public ResponseResult authenticationException(AuthenticationException e){
        log.error("没有通过认证：{}",e.getMessage());
        return ResponseResult.failed(ResponseType.UNAUTHORIZED);
    }

    @ExceptionHandler(AccessDeniedException.class)
    public ResponseResult accessDeniedException(AccessDeniedException e){
        log.error("没有权限访问：{}",e.getMessage());
        return ResponseResult.failed(ResponseType.UNACCESS_DENIED,e.getMessage());
    }

    @ExceptionHandler(Exception.class)
    public ResponseResult exception( Exception e){
        log.error("全局异常处理器拦截：{}",e.getMessage());
        ExceptionUtils.printRootCauseStackTrace(e);
        return ResponseResult.failed(ResponseType.SERVER_ERRROR,e.getMessage());
    }
}
