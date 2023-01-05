package com.money.fimsystem.consume.accounts.entity;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class AccountTotal {

    private BigDecimal totalPay;

    private BigDecimal totalIncome;


}
