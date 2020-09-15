package com.isoft.boots.entity;

import java.io.Serializable;

/**
 * 手机配件表(Part)实体类
 *
 * @author PaulFrank
 * @since 2020-09-15 10:51:33
 */
public class Part implements Serializable {
    private static final long serialVersionUID = -64878898359958548L;

    private Integer partId;

    private String partName;

    private Integer partPrice;

    private Integer partCount;

    private Integer partSales;

    private String partDesc;

    private String partImg;

    private String imgL;

    private String imgR;


    public Integer getPartId() {
        return partId;
    }

    public void setPartId(Integer partId) {
        this.partId = partId;
    }

    public String getPartName() {
        return partName;
    }

    public void setPartName(String partName) {
        this.partName = partName;
    }

    public Integer getPartPrice() {
        return partPrice;
    }

    public void setPartPrice(Integer partPrice) {
        this.partPrice = partPrice;
    }

    public Integer getPartCount() {
        return partCount;
    }

    public void setPartCount(Integer partCount) {
        this.partCount = partCount;
    }

    public Integer getPartSales() {
        return partSales;
    }

    public void setPartSales(Integer partSales) {
        this.partSales = partSales;
    }

    public String getPartDesc() {
        return partDesc;
    }

    public void setPartDesc(String partDesc) {
        this.partDesc = partDesc;
    }

    public String getPartImg() {
        return partImg;
    }

    public void setPartImg(String partImg) {
        this.partImg = partImg;
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