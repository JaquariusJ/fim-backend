package com.money.fimsystem.auth.filter;

import com.money.fimsystem.common.intercepters.HeaderMapRequestWrapper;
import com.money.fimsystem.auth.utils.JwtUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Slf4j
public class AddUserIdHeaderFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        HeaderMapRequestWrapper requestWrapper = new HeaderMapRequestWrapper(request);
        String token = requestWrapper.getHeader("token");
        //token为空，直接放行去做认证
        if(StringUtils.isBlank(token)){
            filterChain.doFilter(requestWrapper,response);
            return;
        }
        String userId = JwtUtils.getUserIdByJwtToken(token);
        //userId为空
        if(StringUtils.isNotBlank(userId)){
            log.info("添加userId {}",userId);
            requestWrapper.addHeader("userId", userId);
        }
        filterChain.doFilter(requestWrapper,response);
    }
}
