package com.money.fimsystem.consume.enums;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum AccountTypeEnum {

    PAY("pay","支出",0),
    INCOME("income","收入",1);

    private String name;

    private String alias;
    private Integer code;

}
