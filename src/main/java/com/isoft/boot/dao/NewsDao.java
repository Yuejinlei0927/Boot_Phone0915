package com.isoft.boot.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.isoft.boot.entity.Brand;
import com.isoft.boot.entity.News;
import com.isoft.boot.entity.Phone;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface NewsDao extends BaseMapper<News> {
    //根据关键字查询资讯
    @Select("select * from news where news_title like #{brandKey}")
    public News getNews(@Param("news_title") String brandKey);
}
