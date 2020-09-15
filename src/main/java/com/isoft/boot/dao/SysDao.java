package com.isoft.boot.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.isoft.boot.entity.Sys;
import com.isoft.boot.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface SysDao extends BaseMapper<Sys> {
    @Select("select * from sys where sys_name=#{name} and sys_pass=#{pass}")
    public Sys login(@Param("name") String name , @Param("pass")String pass) ;

    @Select("select count(*) from sys where sys_name=#{name}")
    public int checkName(@Param("name")String name);
    //根据关键字查询手机
    @Select("select * from sys where sys_name like #{brandKey}")
    public Sys getSyss(@Param("sys_name") String brandKey);
}
