package com.money.fimsystem.user.service;

import com.money.fimsystem.user.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
* <p>
    *  服务类
    * </p>
*
*/
public interface IUserService extends IService<User> {

    void registryUser(User user);

    List<User> getUserByName(String username);
}
