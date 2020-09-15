package com.isoft.boots.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 订单表(Baskets)实体类
 *
 * @author PaulFrank
 * @since 2020-09-15 10:50:19
 */
public class Baskets implements Serializable {
    private static final long serialVersionUID = -78246644533794470L;

    private Integer basketIds;

    private Integer hwIds;

    private Integer partIds;

    private Integer userIds;

    private Integer countIds;

    private String statusIds;

    private String backIds;

    private Date adddatetime;


    public Integer getBasketIds() {
        return basketIds;
    }

    public void setBasketIds(Integer basketIds) {
        this.basketIds = basketIds;
    }

    public Integer getHwIds() {
        return hwIds;
    }

    public void setHwIds(Integer hwIds) {
        this.hwIds = hwIds;
    }

    public Integer getPartIds() {
        return partIds;
    }

    public void setPartIds(Integer partIds) {
        this.partIds = partIds;
    }

    public Integer getUserIds() {
        return userIds;
    }

    public void setUserIds(Integer userIds) {
        this.userIds = userIds;
    }

    public Integer getCountIds() {
        return countIds;
    }

    public void setCountIds(Integer countIds) {
        this.countIds = countIds;
    }

    public String getStatusIds() {
        return statusIds;
    }

    public void setStatusIds(String statusIds) {
        this.statusIds = statusIds;
    }

    public String getBackIds() {
        return backIds;
    }

    public void setBackIds(String backIds) {
        this.backIds = backIds;
    }

    public Date getAdddatetime() {
        return adddatetime;
    }

    public void setAdddatetime(Date adddatetime) {
        this.adddatetime = adddatetime;
    }

}