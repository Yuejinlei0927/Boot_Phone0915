package com.isoft.boot.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.isoft.boot.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface UserDao extends BaseMapper<User> {
    @Select("SELECT * from user where user_name=#{name} and user_pass=#{pass}")
    public User login(@Param("name") String name , @Param("pass")String pass) ;

    @Select("select count(*) from user where user_name=#{name}")
    public int checkName(@Param("name")String name);
    //根据关键字查询手机
    @Select("select * from user where user_name like #{brandKey}")
    public User getUser(@Param("user_name") String brandKey);

}
