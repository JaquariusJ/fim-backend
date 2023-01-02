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
 * @since 2022-12-31
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ApiModel(value="AccountDetail对象", description="")
public class AccountDetail extends BaseObject {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.ASSIGN_ID)
    private Long id;

    private Long userid;

    private Long accountCategoryId;

    private String accountMask;

    private LocalDate accountDate;

    private BigDecimal accountMount;


}
