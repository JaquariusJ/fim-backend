package com.money.fimsystem.consume.accounts.mapstruct;

import com.money.fimsystem.consume.accounts.entity.AccountDetail;
import com.money.fimsystem.consume.accounts.entity.AccountLogo;
import com.money.fimsystem.consume.accounts.vo.AccountDetailVo;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AccountDetailMS {

    @Mapping(source = "accountLogo",target = "accountLogo")
    @Mapping(source = "accountDetail.id",target = "id")
    @Mapping(source = "accountDetail.userid",target = "userid")
    AccountDetailVo toVo(AccountDetail accountDetail,AccountLogo accountLogo);

}
