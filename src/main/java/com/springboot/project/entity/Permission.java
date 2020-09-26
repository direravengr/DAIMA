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
import static com.baomidou.mybatisplus.annotation.FieldFill.INSERT_UPDATE;

@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("permission")
public class Permission implements Serializable {
    private static final long serialVersionUID=1L;

    @TableId(value = "permissionId", type = IdType.UUID)
    private Integer permissionId;

    private String title;

    private String action;

    private int status;

    @TableField(fill = INSERT)
    private Date createTime;

    @TableField(fill = INSERT_UPDATE)
    private Date lastUpdateTime;

}
