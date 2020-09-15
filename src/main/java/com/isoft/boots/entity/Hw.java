package com.isoft.boots.entity;

import java.io.Serializable;

/**
 * 手机商品表(Hw)实体类
 *
 * @author PaulFrank
 * @since 2020-09-15 10:51:08
 */
public class Hw implements Serializable {
    private static final long serialVersionUID = 559411168429841138L;

    private Integer hwId;

    private String brandName;

    private String hwName;

    private Integer hwPrice;

    private Integer hwCount;

    private Integer hwSales;

    private String hwViews;

    private String hwImg;

    private String imgL;

    private String imgR;


    public Integer getHwId() {
        return hwId;
    }

    public void setHwId(Integer hwId) {
        this.hwId = hwId;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public String getHwName() {
        return hwName;
    }

    public void setHwName(String hwName) {
        this.hwName = hwName;
    }

    public Integer getHwPrice() {
        return hwPrice;
    }

    public void setHwPrice(Integer hwPrice) {
        this.hwPrice = hwPrice;
    }

    public Integer getHwCount() {
        return hwCount;
    }

    public void setHwCount(Integer hwCount) {
        this.hwCount = hwCount;
    }

    public Integer getHwSales() {
        return hwSales;
    }

    public void setHwSales(Integer hwSales) {
        this.hwSales = hwSales;
    }

    public String getHwViews() {
        return hwViews;
    }

    public void setHwViews(String hwViews) {
        this.hwViews = hwViews;
    }

    public String getHwImg() {
        return hwImg;
    }

    public void setHwImg(String hwImg) {
        this.hwImg = hwImg;
    }

    public String getImgL() {
        return imgL;
    }

    public void setImgL(String imgL) {
        this.imgL = imgL;
    }

    public String getImgR() {
        return imgR;
    }

    public void setImgR(String imgR) {
        this.imgR = imgR;
    }

}