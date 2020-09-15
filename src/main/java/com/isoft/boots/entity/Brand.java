package com.isoft.boots.entity;

import java.io.Serializable;

/**
 * 手机品牌表(Brand)实体类
 *
 * @author PaulFrank
 * @since 2020-09-15 10:50:55
 */
public class Brand implements Serializable {
    private static final long serialVersionUID = 104375173362263183L;

    private Integer brandId;

    private String brandName;

    private String brandDesc;

    private String brandImg;


    public Integer getBrandId() {
        return brandId;
    }

    public void setBrandId(Integer brandId) {
        this.brandId = brandId;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public String getBrandDesc() {
        return brandDesc;
    }

    public void setBrandDesc(String brandDesc) {
        this.brandDesc = brandDesc;
    }

    public String getBrandImg() {
        return brandImg;
    }

    public void setBrandImg(String brandImg) {
        this.brandImg = brandImg;
    }

}