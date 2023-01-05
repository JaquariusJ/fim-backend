package com.money.fimsystem.consume.accounts.service;

import com.money.fimsystem.consume.accounts.entity.AccountLogo;
import com.baomidou.mybatisplus.extension.service.IService;

/**
* <p>
    *  服务类
    * </p>
*
*/
public interface IAccountLogoService extends IService<AccountLogo> {


    boolean deleteById(Long id);
}
