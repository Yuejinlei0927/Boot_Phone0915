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
@TableName("part")
public class Part implements Serializable {
    @TableId(type = IdType.AUTO,value = "part_id")
    @Digits(integer = 5,fraction = 0,message = "ID是正整数")
    @Min(message = "最小值为1",value = 1)
    private Integer partid;
    @TableField(value = "part_name")
    @NotBlank(message = "配件名称为空")
    private String partname;
    @TableField(value = "part_price")
    private Integer partprice;
    @TableField(value = "part_count")
    private Integer partcount;
    @TableField(value = "part_sales")
    private Integer partsales;
    @TableField(value = "part_desc")
    private String partdesc;
    @TableField(value = "part_img")
    private String partimg;
    @TableField(value = "img_l")
    private String imgl;
    @TableField(value = "img_r")
    private String imgr;


}
