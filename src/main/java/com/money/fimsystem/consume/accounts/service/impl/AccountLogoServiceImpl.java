package com.money.fimsystem.consume.accounts.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.money.fimsystem.consume.accounts.entity.AccountDetail;
import com.money.fimsystem.consume.accounts.entity.AccountLogo;
import com.money.fimsystem.consume.accounts.mapper.AccountLogoMapper;
import com.money.fimsystem.consume.accounts.service.IAccountDetailService;
import com.money.fimsystem.consume.accounts.service.IAccountLogoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
* <p>
    *  服务实现类
    * </p>
*
* @author wujian
* @since 2023-01-01
*/
@Service
public class AccountLogoServiceImpl extends ServiceImpl<AccountLogoMapper, AccountLogo> implements IAccountLogoService {


    @Autowired
    private IAccountDetailService accountDetailService;


    @Override
    public boolean deleteById(Long id) {
        //删除logo
        this.removeById(id);
        //删除账单
        return accountDetailService.remove(new LambdaQueryWrapper<AccountDetail>().eq(AccountDetail::getLogoid, id));

    }
}
