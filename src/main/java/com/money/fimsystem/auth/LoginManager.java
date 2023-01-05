package com.money.fimsystem.auth;


import com.money.fimsystem.auth.vo.AuthUserDetails;
import com.money.fimsystem.user.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.apache.tomcat.websocket.AuthenticationException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Slf4j
@Service
public class LoginManager {

    private static LoginManager instance;

    @PostConstruct
    public void init() {
        instance = this;
    }

    public static User getCurrentUser() {
        User defaultUser = new User();
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null) {
            return defaultUser;
        }
        Object principal = authentication.getPrincipal();
        if (!(principal instanceof AuthUserDetails)) {
            //匿名用户
            return defaultUser;
        }
        AuthUserDetails userDetails = (AuthUserDetails) authentication.getPrincipal();
        if (userDetails == null) {
            return defaultUser;
        }
        return userDetails.getUser();
    }

    public static Long getCurrentUserId(){
        return getCurrentUser().getId();
    }


    public static String getCurrentUserName(){
        return getCurrentUser().getUsername();
    }
}
