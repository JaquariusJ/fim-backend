package com.money.fimsystem.user.observer;

import com.money.fimsystem.consume.accounts.entity.AccountLogo;
import com.money.fimsystem.consume.accounts.service.IAccountLogoService;
import com.money.fimsystem.consume.enums.AccountDefaultItemEnum;
import com.money.fimsystem.user.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class InitAccountLogoUserObserver implements UserObserver<User> {

    @Autowired
    private IAccountLogoService accountLogoService;

    @Override
    public void handler(User user) {
        log.info("InitAccountLogoUserObserver 接收到新用户：{}",user);
        //获取所有默认的logo,初始化插入logo记录
        AccountDefaultItemEnum[] defaultItems = AccountDefaultItemEnum.values();
        List<AccountLogo> defaultLogos = new ArrayList<>();
        for (AccountDefaultItemEnum defaultItem : defaultItems) {
            AccountLogo logo = new AccountLogo();
            logo.setUserid(user.getId());
            logo.setTitle(defaultItem.getTitle());
            logo.setCategory(defaultItem.getCategory().getCode());
            logo.setType(defaultItem.getType().getCode());
            logo.setLogoName(defaultItem.getIconName());
            logo.setIsCustom(0);
            defaultLogos.add(logo);
        }
        accountLogoService.saveBatch(defaultLogos);
    }
}
