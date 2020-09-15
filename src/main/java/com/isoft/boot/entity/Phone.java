package com.isoft.boot.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;
import java.io.Serializable;
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("hw")
public class Phone implements Serializable {
    @TableId(type = IdType.AUTO,value = "hw_id")
    @Digits(integer = 5,fraction = 0,message = "ID是正整数")
    @Min(message = "最小值为1",value = 1)
    private Integer hwid;
    @TableField(value = "brand_name")
    @NotBlank(message = "品牌名称为空")
    private String brandname;
    @TableField(value = "hw_name")
    @NotBlank(message = "手机名称为空")
    private String hwname;

    @TableField(value = "hw_price")
    private Integer hwprice;
    @TableField(value = "hw_count")
    private Integer hwcount;
    @TableField(value = "hw_sales")
    private Integer hwsales;
    @TableField(value = "hw_views")
    private String hwviews;
    @TableField(value = "hw_img")
    private String hwimg;
    @TableField(value = "img_l")
    private String imgl;
    @TableField(value = "img_r")
    private String imgr;

}
