package com.money.fimsystem.consume.accounts.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AccountCategory {

    private String title;

    private String name;

    private Integer code;
}
