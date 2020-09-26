package com.springboot.project.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;

import java.io.Serializable;
import java.util.Date;

import static com.baomidou.mybatisplus.annotation.FieldFill.INSERT;
import static com.baomidou.mybatisplus.annotation.FieldFill.INSERT_UPDATE;

@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("users")
public class User implements Serializable {
    private static final long serialVersionUID = 1L;

    @TableId(value = "userId",type = IdType.UUID)
    private String userId;//用户id

    private String userCode;//用户账号

    private String userName;//用户姓名

    private String userPassword;//用户密码

    private String role;//角色

    private String salt;//加密盐

    private String email;

    private String phoneNumber;

    private int status;//帐号状态 0：使用中 1：已注销

    @TableField(fill = INSERT)
    private Date createTime;

    private Date lastLoginTime;

    @TableField(fill = INSERT_UPDATE)
    private Date lastUpdateTime;

}
