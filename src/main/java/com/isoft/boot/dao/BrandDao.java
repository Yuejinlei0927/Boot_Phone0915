package com.isoft.boot.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.isoft.boot.entity.Brand;
import com.isoft.boot.entity.Phone;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface BrandDao extends BaseMapper<Brand> {
    //根据关键字查询品牌
    @Select("select * from brand where brand_name like #{brandKey}")
    public Brand getBrands(@Param("brand_name") String brandKey);
}
