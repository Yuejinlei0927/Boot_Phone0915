package com.isoft.boot.service;

import com.isoft.boot.bean.Basketss;
import com.isoft.boot.entity.*;

import java.util.List;

public interface BasketService {
//    Basket getById(Integer id);
//    List<Basket> getAll();
//    boolean insert(Basket basket);
//    boolean delById(Integer id);
    boolean delByIds(List<Integer> ids);
    Basket update(Basket basket);
    Phone getPhoneid(Integer id);
    User getUserid(Integer id);
    Part getPartid(Integer id);
    Basket getBasketid(Integer id);
    List<Basket> selectAll();
    boolean insert(Basket basket);
    boolean delById(Integer id);
    List<Basket> selectBack(Integer id);
    List<Basket> selectBack2(Integer id);
    List<Basket> getByUserId(Integer user_ids);
    List<User> getByUserName(String username);
}
