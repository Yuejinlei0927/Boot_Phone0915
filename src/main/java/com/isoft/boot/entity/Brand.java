package com.isoft.boot.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.Digits;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Validated
@TableName("brand")
public class Brand implements Serializable {
    @TableId(type = IdType.AUTO,value = "brand_id")
    @Digits(integer = 5,fraction = 0,message = "品牌id应该是正整数")
    @Min(message = "最小值是1",value = 1)
    private Integer id;

    @TableField("brand_name")
    @NotBlank(message = "品牌名称不能为空")
    private String brandName;
    @TableField("brand_desc ")
    private String brandDesc;
    @TableField("brand_img ")
    private String brandImg;
}
