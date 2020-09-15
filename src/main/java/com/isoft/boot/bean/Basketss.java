package com.isoft.boot.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.validation.annotation.Validated;

import java.io.Serializable;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Validated
public class Basketss implements Serializable {
    public Integer basketids;
    public String username;
    public String shopname;
    public Integer shopprice;
    public Integer shopcount;
    public String status;
    public String back;
    public Date adddatetime;

    public Date getAdddatetime() {
        return adddatetime;
    }

    public void setAdddatetime(Date adddatetime) {
        this.adddatetime = adddatetime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getBack() {
        return back;
    }

    public void setBack(String back) {
        this.back = back;
    }

    public Integer getBasketids() {
        return basketids;
    }

    public void setBasketids(Integer basketids) {
        this.basketids = basketids;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getShopname() {
        return shopname;
    }

    public void setShopname(String shopname) {
        this.shopname = shopname;
    }

    public Integer getShopprice() {
        return shopprice;
    }

    public void setShopprice(Integer shopprice) {
        this.shopprice = shopprice;
    }

    public Integer getShopcount() {
        return shopcount;
    }

    public void setShopcount(Integer shopcount) {
        this.shopcount = shopcount;
    }
}
