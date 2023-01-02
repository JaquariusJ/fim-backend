package com.money.fimsystem.consume.enums;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum AccountDefaultItemEnum {

//    娱乐
    DINE_TOGETHER("聚餐", AccountTypeEnum.PAY, AccountCategoryEnum.ENTERTAINMENT,"jucan"),
    BOARD_GAME("桌游", AccountTypeEnum.PAY, AccountCategoryEnum.ENTERTAINMENT,"zhuoyou"),
//    饮食
    BREAKFAST("早餐", AccountTypeEnum.PAY, AccountCategoryEnum.REPAST,"zaocan"),
    LUNCH("午餐", AccountTypeEnum.PAY, AccountCategoryEnum.REPAST,"wucan"),
    DINNER("晚餐", AccountTypeEnum.PAY, AccountCategoryEnum.REPAST,"wancan"),
// 医疗
    MEDICINAL("药物", AccountTypeEnum.PAY, AccountCategoryEnum.MEDICAL,"yaowu"),
    HOSPITAL("住院", AccountTypeEnum.PAY, AccountCategoryEnum.MEDICAL,"zhuyuan")
    ;


    private String title;

    private AccountTypeEnum type;

    private AccountCategoryEnum category;

    private String iconName;


}
