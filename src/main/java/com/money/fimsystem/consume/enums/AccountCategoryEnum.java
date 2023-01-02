package com.money.fimsystem.consume.enums;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum AccountCategoryEnum {

    ENTERTAINMENT("娱乐","entertainment",0),
    REPAST("饮食","repast",1),
    MEDICAL("医疗","medical",2),
    STUDY("培训","study",3),
    TRAFFIC("交通","traffic",4),
    SHOPPING("购物","shopping",5),
    TRAD("日用","trad",6),
    SNACKS("零食","snacks",7),
    RENTING("租房","renting",8),
    PERSONAL("个人","personal",9),
    HOME("家居","home",10),
    FAMILY("家庭","family",11),
    FITNESS("健身","fitness",12),
    WORK("办公","work",13),
    INCOME("收入","income",14),
    PET("宠物","pet",15),
    BUSINESS("交易","business",16),

    OTHER("其他","other",-1);




    private String title;

    private String name;

    private Integer code;

}
