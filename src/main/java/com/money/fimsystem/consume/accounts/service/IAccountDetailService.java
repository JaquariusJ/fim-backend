package com.money.fimsystem.consume.accounts.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.github.pagehelper.PageInfo;
import com.money.fimsystem.consume.accounts.entity.AccountDetail;
import com.baomidou.mybatisplus.extension.service.IService;
import com.money.fimsystem.consume.accounts.vo.AccountDetailVo;

/**
* <p>
    *  服务类
    * </p>
*
*/
public interface IAccountDetailService extends IService<AccountDetail> {


    PageInfo<AccountDetailVo> pageList(AccountDetail accountDetail, int pageNo, int pageNum);
}
