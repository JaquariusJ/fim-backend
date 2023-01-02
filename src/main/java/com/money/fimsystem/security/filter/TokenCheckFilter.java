package com.money.fimsystem.security.filter;

import com.money.fimsystem.common.constants.REDIS_CONST;
import com.money.fimsystem.common.utils.JsonUtils;
import com.money.fimsystem.common.utils.SpringUtils;
import com.money.fimsystem.redis.RedisClient;
import com.money.fimsystem.security.utils.JwtUtils;
import com.money.fimsystem.security.vo.AuthUserDetails;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collection;
import java.util.Objects;

@Slf4j
public class TokenCheckFilter extends OncePerRequestFilter {


    private final RedisClient redisClient = SpringUtils.getBean(RedisClient.class);

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
       log.info("过滤器被执行了.....");
        String token = request.getHeader("token");
        //判断token是否为空
        if(StringUtils.isEmpty(token)){
            //放行，并不再解析token
            filterChain.doFilter(request,response);
            return;
        }
        //解析token
        String userId = null;
        //如果解析失败，说明token失效
        try {
            userId = JwtUtils.getUserIdByJwtToken(token);
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new RuntimeException("token 不合法");
        }
        //从redis中获取用户信息
        String key = REDIS_CONST.TOKEN_PREFIX +userId;
        String userDetailStr = redisClient.get(key);
        if(StringUtils.isBlank(userDetailStr)){
            throw new RuntimeException("token 失效");
        }
        AuthUserDetails userDetails = JsonUtils.parseObject(userDetailStr,AuthUserDetails.class);
        if(Objects.isNull(userDetails)){
            throw new RuntimeException("token 失效");
        }
        Collection<? extends GrantedAuthority> authorities = userDetails.getAuthorities();
        //将用户信息放到SecurityContextHolder中
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(userDetails, null, authorities);
        SecurityContextHolder.getContext().setAuthentication(authenticationToken);
        //放行
        filterChain.doFilter(request, response);
    }
}