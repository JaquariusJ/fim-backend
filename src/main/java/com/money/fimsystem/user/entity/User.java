package com.money.fimsystem.user.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.money.fimsystem.common.entity.BaseObject;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDate;

/**
 * <p>
 * 
 * </p>
 *
 * @author wujian
 * @since 2022-12-26
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ApiModel(value="User对象", description="")
public class User extends BaseObject {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.ASSIGN_ID)
    private Long id;

    private String username;

    private String password;

    private LocalDate birthday;

    private Integer age;

    private Integer sex;

    private String email;

    private Long iphone;

    private String headImg;


}
