package com.money.fimsystem.consume.accounts.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.money.fimsystem.common.utils.PageHelperUtils;
import com.money.fimsystem.consume.accounts.entity.AccountDetail;
import com.money.fimsystem.consume.accounts.entity.AccountLogo;
import com.money.fimsystem.consume.accounts.mapper.AccountDetailMapper;
import com.money.fimsystem.consume.accounts.mapstruct.AccountDetailMS;
import com.money.fimsystem.consume.accounts.service.IAccountDetailService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.money.fimsystem.consume.accounts.service.IAccountLogoService;
import com.money.fimsystem.consume.accounts.vo.AccountDetailVo;
import com.money.fimsystem.exceptions.DataException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

/**
* <p>
    *  服务实现类
    * </p>
*
* @author wujian
* @since 2023-01-03
*/
@Service
@Slf4j
public class AccountDetailServiceImpl extends ServiceImpl<AccountDetailMapper, AccountDetail> implements IAccountDetailService {

    @Autowired
    private AccountDetailMS accountDetailMS;

    @Autowired
    private IAccountLogoService accountLogoService;

    @Override
    public PageInfo<AccountDetailVo> pageList(AccountDetail accountDetail, int pageNo, int pageNum) {
        //查询分页消费记录
        PageHelper.startPage(pageNo, pageNum);
        List<AccountDetail> accountDetails = this.baseMapper.selectList(new LambdaQueryWrapper<AccountDetail>(accountDetail)
                .orderByDesc(AccountDetail::getAccountDate).orderByDesc(AccountDetail::getCreateTime));
        PageInfo<AccountDetail> accountDetailsPageInfo = new PageInfo<>(accountDetails);

        //查询该用户所有的logo
        List<AccountLogo> logos = accountLogoService.list(new LambdaQueryWrapper<AccountLogo>().eq(AccountLogo::getUserid,accountDetail.getUserid()));
        Map<Long, AccountLogo> logoMap = logos.stream().collect(Collectors.toMap(AccountLogo::getId, e -> e));
        //转成VO
        List<AccountDetailVo> accountDetailVos = accountDetails.stream().map(detail -> {
            Long logoid = detail.getLogoid();
            if (!logoMap.containsKey(logoid)) {
                log.error("记录:{} 出现不存在的logoid: {}", detail.getId(), logoid);
                throw new DataException("数据异常,logoid:" + logoid);
            }
            AccountLogo accountLogo = logoMap.get(logoid);
            return accountDetailMS.toVo(detail, accountLogo);
        }).collect(Collectors.toList());
        return PageHelperUtils.pageDO2pageVO(accountDetailsPageInfo, accountDetailVos);
    }
}
