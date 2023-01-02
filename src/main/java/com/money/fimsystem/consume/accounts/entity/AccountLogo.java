package com.money.fimsystem.consume.accounts.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * <p>
 * 
 * </p>
 *
 * @author wujian
 * @since 2023-01-01
 */
@Data
@ApiModel(value="AccountLogo对象", description="")
public class AccountLogo {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "id")
    @TableId(value = "id", type = IdType.ASSIGN_ID)
    private Long id;

    @ApiModelProperty(value = "用户id")
    private Long userid;

    @ApiModelProperty(value = "类别标签")
    private String title;

    @ApiModelProperty(value = "支出/收入")
    private Integer type;

    @ApiModelProperty(value = "分类")
    private Integer category;

    @ApiModelProperty(value = "图片名称")
    private String logoName;

    @ApiModelProperty(value = "是否自定义")
    private Integer isCustom;


}
