package com.money.fimsystem.auth.service.impl;

import com.money.fimsystem.auth.entity.User;
import com.money.fimsystem.auth.mapper.UserMapper;
import com.money.fimsystem.auth.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
* <p>
    *  服务实现类
    * </p>
*
* @author wujian
* @since 2022-12-26
*/
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {


}
