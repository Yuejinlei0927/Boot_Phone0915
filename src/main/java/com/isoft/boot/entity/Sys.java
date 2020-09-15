package com.isoft.boot.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Digits;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("sys")
public class Sys implements Serializable {
    @TableId(type = IdType.AUTO,value = "id")
    @Digits(integer = 5,fraction = 0,message = "管理员ID应该为正整数")
    @Min(message = "最小值为1",value = 1)
    private Integer id;
    @TableField(value = "sys_name")
    @NotBlank(message = "管理员用户为空")
    private String sysname;
    @TableField(value = "sys_pass")
    @NotBlank(message = "管理员密码为空")
    private String syspass;
    @TableField(value = "sys_role")
    private String sysrole;
    @TableField(value = "sys_img")
    private String sysimg;

}
