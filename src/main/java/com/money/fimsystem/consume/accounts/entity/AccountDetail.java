package com.money.fimsystem.consume.accounts.entity;

import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.IdType;
import java.time.LocalDate;
import com.baomidou.mybatisplus.annotation.TableId;
import com.money.fimsystem.common.entity.BaseObject;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

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
@ApiModel(value="AccountDetail对象", description="")
public class AccountDetail extends BaseObject {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.ASSIGN_ID)
    private Long id;

    @ApiModelProperty(value = "用户id")
    private Long userid;

    @ApiModelProperty(value = "logoid")
    private Long logoid;

    @ApiModelProperty(value = "备注信息")
    private String mask;

    @ApiModelProperty(value = "记账日期")
    private LocalDate accountDate;

    @ApiModelProperty(value = "金额")
    private BigDecimal mount;


}
