package com.isoft.boot.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.isoft.boot.util.phone;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.Digits;
import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("user")
public class User implements Serializable {
    @TableId(type = IdType.AUTO,value = "user_id")
    @Digits(integer = 5,fraction = 0,message = "ID应该为正整数")
    @Min(message = "最小值为1",value = 1)
    private Integer userid;
    @TableField(value = "user_name")
    @NotBlank(message = "用户名为空")
    private String username;
    @TableField(value = "user_pass")
    @NotBlank(message = "用户密码为空")
    private String userpass;
    @TableField(value = "user_email")
    @Email(message = "请输入正确的邮箱地址")
    private String  useremail;
    @TableField(value = "adddatetime")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date adddatetime;
    @TableField(value = "user_tel")
    @phone
    private String usertel;
}
