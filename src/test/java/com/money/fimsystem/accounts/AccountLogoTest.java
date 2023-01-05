package com.money.fimsystem.accounts;

import com.money.fimsystem.common.utils.SpringUtils;
import com.money.fimsystem.consume.accounts.entity.AccountLogo;
import com.money.fimsystem.consume.accounts.mapper.AccountLogoMapper;
import com.money.fimsystem.consume.enums.AccountCategoryEnum;
import com.money.fimsystem.consume.enums.AccountTypeEnum;
import com.money.fimsystem.redis.RedisClient;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class AccountLogoTest {

    @Autowired
    private AccountLogoMapper accountLogoMapper;

    @Autowired
    private RedisClient redisClient;



    @Test
    public void insertData(){
        //支出
        AccountLogo l1 = new AccountLogo();
        l1.setUserid(0l);
        l1.setType(AccountTypeEnum.PAY.getCode());
        l1.setTitle("交通");
        l1.setCategory(AccountCategoryEnum.TRAFFIC.getCode());
        l1.setLogoName("taxi");
        l1.setIsCustom(0);
        accountLogoMapper.insert(l1);
    }

    @Test
    public void test1(){
        RedisClient bean = SpringUtils.getBean(RedisClient.class);
        System.out.println(bean);
        System.out.println(redisClient);
    }
}
