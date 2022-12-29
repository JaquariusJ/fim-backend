package com.money.fimsystem.user.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.money.fimsystem.user.entity.User;
import com.money.fimsystem.user.mapper.UserMapper;
import com.money.fimsystem.user.service.IUserService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;

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

    @Override
    public void registryUser(User user) {
        LocalDate birthday = user.getBirthday();
        LocalDate now = LocalDate.now();
        Period between = Period.between(birthday, now);
        int age = between.getYears();
        user.setAge(age);
        this.save(user);
    }

    @Override
    public List<User> getUserByName(String username) {
        return baseMapper.selectList(new LambdaQueryWrapper<User>().eq(User::getUsername, username));
    }
}
