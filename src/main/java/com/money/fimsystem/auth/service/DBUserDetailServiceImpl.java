package com.money.fimsystem.auth.service;

import com.money.fimsystem.auth.vo.AuthUserDetails;
import com.money.fimsystem.user.entity.User;
import com.money.fimsystem.user.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.*;

@Service
public class DBUserDetailServiceImpl implements UserDetailsService {

    @Autowired
    private IUserService userService;
    @Override
    public UserDetails loadUserByUsername(String username){
        List<User> users = userService.getUserByName(username);
        if(CollectionUtils.isEmpty(users)){
            throw new RuntimeException("用户不存在");
        }
        List<String> list = new ArrayList<>(Arrays.asList("read","edit","insert","delete"));
        return new AuthUserDetails(users.get(0),list);
    }
}
