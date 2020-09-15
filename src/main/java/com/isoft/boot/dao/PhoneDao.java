package com.isoft.boot.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.isoft.boot.entity.Phone;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface PhoneDao extends BaseMapper<Phone> {
    //根据品牌查询手机
    @Select("select * from hw where brand_name like #{brandKey}")
    public Phone getPhones(@Param("brand_name") String brandKey);
    //根据关键字查询手机
    @Select("select * from hw where brand_name like #{brandKey}")
    public Phone getPhoneName(@Param("hw_name") String brandKey);

}
