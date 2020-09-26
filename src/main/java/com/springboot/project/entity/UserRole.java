package com.springboot.project.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("userRole")
public class UserRole implements Serializable {
    private static final long serialVersionUID=1L;

    @TableId(value = "userRoleId", type = IdType.UUID)
    private Integer userRoleId;

    private Integer userId;

    private Integer roleId;

}
