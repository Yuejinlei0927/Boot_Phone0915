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
@TableName("news")
public class News implements Serializable {
    @TableId(type = IdType.AUTO,value = "news_id")
    @Digits(integer = 5,fraction = 0,message = "ID应该为正整数")
    @Min(message = "最小值为1",value = 1)
    private Integer newsid;
    @TableField(value = "news_title")
    private String newstitle;
    @TableField(value = "news_content")
    @NotBlank(message = "资讯内容为空")
    private String newscontent;
    @TableField(value = "news_from")
    private String newsfrom;
    @TableField(value = "news_time")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date newstime;
    @TableField(value = "news_detail")
    private String newsdetail;
    @TableField(value = "news_up")
    private String newsup;
    @TableField(value = "news_down")
    private String newsdown;

}
