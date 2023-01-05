package com.money.fimsystem.consume.accounts.service;

import com.github.pagehelper.PageInfo;
import com.money.fimsystem.consume.accounts.entity.AccountDetail;
import com.baomidou.mybatisplus.extension.service.IService;
import com.money.fimsystem.consume.accounts.entity.AccountTotal;
import com.money.fimsystem.consume.accounts.vo.AccountDetailVo;

/**
* <p>
    *  服务类
    * </p>
*
*/
public interface IAccountDetailService extends IService<AccountDetail> {


    PageInfo<AccountDetailVo> pageList(AccountDetail accountDetail, int pageNo, int pageNum);

    AccountTotal getTotalInfo(AccountDetail accountDetail);
}
