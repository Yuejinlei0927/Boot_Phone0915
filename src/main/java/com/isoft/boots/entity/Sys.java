package com.isoft.boots.entity;

import java.io.Serializable;

/**
 * 管理员表(Sys)实体类
 *
 * @author PaulFrank
 * @since 2020-09-15 10:51:50
 */
public class Sys implements Serializable {
    private static final long serialVersionUID = -52908870420642742L;

    private Integer id;

    private String sysName;

    private String sysPass;

    private String sysRole;

    private String sysImg;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSysName() {
        return sysName;
    }

    public void setSysName(String sysName) {
        this.sysName = sysName;
    }

    public String getSysPass() {
        return sysPass;
    }

    public void setSysPass(String sysPass) {
        this.sysPass = sysPass;
    }

    public String getSysRole() {
        return sysRole;
    }

    public void setSysRole(String sysRole) {
        this.sysRole = sysRole;
    }

    public String getSysImg() {
        return sysImg;
    }

    public void setSysImg(String sysImg) {
        this.sysImg = sysImg;
    }

}