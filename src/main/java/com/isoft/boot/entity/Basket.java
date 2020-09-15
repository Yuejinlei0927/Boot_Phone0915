package com.isoft.boot.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.Digits;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Validated
@TableName("baskets")
public class Basket implements Serializable {
    @TableId(type = IdType.AUTO, value = "basket_ids")
    @Digits(integer = 5, fraction = 0, message = "ID应该为正整数")
    @Min(message = "最小值为1", value = 1)
    private Integer basketids;
    @TableField(value = "hw_ids")
    private Integer hwids;
    @TableField(value = "user_ids")
    private Integer userids;
    @TableField(value = "part_ids")
    private Integer partids;
    @TableField(value = "count_ids")
    private Integer countids;
    @TableField(value = "status_ids")
    private String statusids;
    @TableField(value = "back_ids")
    private String backids;
    @TableField(value = "adddatetime")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date adddatetime;

  }