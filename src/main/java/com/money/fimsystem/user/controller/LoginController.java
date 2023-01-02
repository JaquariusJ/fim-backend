package com.money.fimsystem.user.controller;

import com.google.common.collect.Maps;
import com.money.fimsystem.common.constants.REDIS_CONST;
import com.money.fimsystem.common.entity.ResponseResult;
import com.money.fimsystem.redis.RedisClient;
import com.money.fimsystem.security.utils.JwtUtils;
import com.money.fimsystem.security.vo.AuthUserDetails;
import com.money.fimsystem.user.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@Slf4j
public class LoginController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private RedisClient redisClient;

    @RequestMapping("/login")
    public ResponseResult login(@RequestBody User user){
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword());
        Authentication authenticate = authenticationManager.authenticate(authenticationToken);
        if(authenticate == null){
            return ResponseResult.failed("认证失败");
        }
        AuthUserDetails authUserDetails = (AuthUserDetails)authenticate.getPrincipal();
        //根据用户获取token
        User authUser = authUserDetails.getUser();
        String token = JwtUtils.getJwtToken(String.valueOf(authUser.getId()), authUser.getUsername());
        Map<String, Object> tokenMap = Maps.newConcurrentMap();
        tokenMap.put("token",token);
        String key = REDIS_CONST.TOKEN_PREFIX + authUser.getId();
        redisClient.set(key,authUserDetails);
        return ResponseResult.success(tokenMap);
    }


    @GetMapping("/loginout")
    public ResponseResult loginOut(){
        //从SecurityContextHolder获取对象
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        AuthUserDetails userDetails = (AuthUserDetails) authentication.getPrincipal();
        User user = userDetails.getUser();
        Long id = user.getId();
        String key =  REDIS_CONST.TOKEN_PREFIX +id;
        //从redis删除用户信息
        redisClient.delete(key);
        return ResponseResult.success("注销成功");
    }

}
