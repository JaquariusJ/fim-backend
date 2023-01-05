package com.money.fimsystem.consume.accounts.vo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.money.fimsystem.common.entity.BaseObject;
import com.money.fimsystem.consume.accounts.entity.AccountLogo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * <p>
 * 
 * </p>
 *
 * @author wujian
 * @since 2023-01-03
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class AccountDetailVo extends BaseObject {

    private static final long serialVersionUID = 1L;

    private Long id;

    @ApiModelProperty(value = "用户id")
    private Long userid;

    @ApiModelProperty(value = "logo")
    private AccountLogo accountLogo;

    @ApiModelProperty(value = "备注信息")
    private String mask;

    @ApiModelProperty(value = "记账日期")
    private LocalDate accountDate;

    @ApiModelProperty(value = "金额")
//    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private BigDecimal mount;


}
