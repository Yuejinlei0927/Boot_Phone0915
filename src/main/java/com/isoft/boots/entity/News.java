package com.isoft.boots.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 手机资讯表(News)实体类
 *
 * @author PaulFrank
 * @since 2020-09-15 10:51:17
 */
public class News implements Serializable {
    private static final long serialVersionUID = 384594756227786353L;

    private Integer newsId;

    private String newsTitle;

    private String newsContent;

    private String newsFrom;

    private Date newsTime;

    private String newsDetail;

    private String newsUp;

    private String newsDown;


    public Integer getNewsId() {
        return newsId;
    }

    public void setNewsId(Integer newsId) {
        this.newsId = newsId;
    }

    public String getNewsTitle() {
        return newsTitle;
    }

    public void setNewsTitle(String newsTitle) {
        this.newsTitle = newsTitle;
    }

    public String getNewsContent() {
        return newsContent;
    }

    public void setNewsContent(String newsContent) {
        this.newsContent = newsContent;
    }

    public String getNewsFrom() {
        return newsFrom;
    }

    public void setNewsFrom(String newsFrom) {
        this.newsFrom = newsFrom;
    }

    public Date getNewsTime() {
        return newsTime;
    }

    public void setNewsTime(Date newsTime) {
        this.newsTime = newsTime;
    }

    public String getNewsDetail() {
        return newsDetail;
    }

    public void setNewsDetail(String newsDetail) {
        this.newsDetail = newsDetail;
    }

    public String getNewsUp() {
        return newsUp;
    }

    public void setNewsUp(String newsUp) {
        this.newsUp = newsUp;
    }

    public String getNewsDown() {
        return newsDown;
    }

    public void setNewsDown(String newsDown) {
        this.newsDown = newsDown;
    }

}