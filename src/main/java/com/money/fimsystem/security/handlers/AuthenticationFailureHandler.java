package com.money.fimsystem.security.handlers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//@Component
//@Slf4j
//public class AuthenticationFailureHandler implements AuthenticationEntryPoint{
//
//    @Override
//    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException, ServletException {
//        String url = request.getRequestURL().toString();
//        log.error("执行了 {} 认证被拦截,认证失败： {}",url,authException.getMessage());
//        throw new RuntimeException(authException);
//    }
//}
