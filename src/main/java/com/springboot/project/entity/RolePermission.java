package com.springboot.project.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

import static com.baomidou.mybatisplus.annotation.FieldFill.INSERT;

@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("rolePermission")
public class RolePermission implements Serializable {
    private static final long serialVersionUID=1L;

    @TableId(value = "rolePermissionId", type = IdType.AUTO)
    private Integer rolePermissionId;

    private Integer roleId;

    private Integer permissionId;

    @TableField(fill = INSERT)
    private Date createTime;

}
