package com.money.fimsystem.accounts;

import com.money.fimsystem.common.utils.SpringUtils;
import com.money.fimsystem.consume.accounts.entity.AccountDetail;
import com.money.fimsystem.consume.accounts.entity.AccountLogo;
import com.money.fimsystem.consume.accounts.mapper.AccountDetailMapper;
import com.money.fimsystem.consume.accounts.mapper.AccountLogoMapper;
import com.money.fimsystem.consume.accounts.mapstruct.AccountDetailMS;
import com.money.fimsystem.consume.accounts.vo.AccountDetailVo;
import com.money.fimsystem.consume.enums.AccountCategoryEnum;
import com.money.fimsystem.consume.enums.AccountTypeEnum;
import com.money.fimsystem.redis.RedisClient;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.time.LocalDate;

@SpringBootTest
@RunWith(SpringRunner.class)
public class MapStrcutTest {


    @Autowired
    private AccountDetailMS detailMS;

    @Test
    public void test1(){
        AccountDetail accountDetail = new AccountDetail();
        accountDetail.setMask("1");
        accountDetail.setLogoid(1111l);
        accountDetail.setAccountDate(LocalDate.now());
        accountDetail.setId(1111l);
        accountDetail.setMount(BigDecimal.ONE);
        accountDetail.setUserid(1111l);
        AccountLogo accountLogo = new AccountLogo();
        accountLogo.setLogoName("2222");
        accountLogo.setTitle("2222");
        accountLogo.setIsCustom(1);
        accountLogo.setId(2222l);
        accountLogo.setType(0);
        accountLogo.setCategory(0);
        accountLogo.setUserid(222l);
        AccountDetailVo accountDetailVo = detailMS.toVo(accountDetail, accountLogo);
        System.out.println(accountDetailVo);
    }
}
