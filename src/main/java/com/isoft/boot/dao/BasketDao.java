package com.isoft.boot.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.isoft.boot.bean.Basketss;
import com.isoft.boot.entity.Basket;
import com.isoft.boot.entity.Part;
import com.isoft.boot.entity.Phone;
import com.isoft.boot.entity.User;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Mapper
public interface BasketDao extends BaseMapper<Basket> {

    @Select("select * from hw where hw_id = #{hwid}")
    public Phone getPhoneid(@Param("hw_id") Integer id);

    @Select("select * from user where user_id = #{userid}")
    public User getUserid(@Param("user_id") Integer id);

    @Select("select * from part where part_id = #{partid}")
    public Part getPartid(@Param("part_id") Integer id);

    @Select("select * from baskets where basket_ids = #{basketid}")
    public Basket getBasketid(@Param("basket_ids") Integer id);

    @Select("select * from user where user_name like #{username}")
    public List<User> getByUserName(String username);


    @Select("select * from baskets")
    public List<Basket> selectAll();

    @Select("select * from baskets where hw_ids = #{hwids} ")
    public List<Basket> selectBack(Integer id);

    @Select("select * from baskets where part_ids = #{partids} ")
    public List<Basket> selectBack2(Integer id);


    @Select("select * from baskets where user_ids = #{user_ids}")
    public List<Basket> getByUserId(@Param("user_ids") Integer user_ids);


}
