package com.isoft.boot.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.isoft.boot.bean.Basketss;
import com.isoft.boot.dao.*;
import com.isoft.boot.entity.*;
import com.isoft.boot.service.BasketService;
import com.isoft.boot.service.BrandService;
import com.isoft.boot.util.IntegerUtil;
import com.isoft.boot.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.constraints.Digits;
import javax.validation.constraints.Min;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Transactional
@Service
public class BasketServiceImpl implements BasketService {
    @Autowired
    BasketDao basketDao;
    @Autowired
    PhoneDao phoneDao;
    @Autowired
    UserDao userDao;
    @Autowired
    PartDao partDao;


    @Override
    public boolean delByIds(List<Integer> ids) {
        if(ids==null||ids.size()==0){
            return false;
        }
        for (Integer id : ids) {
            if(!IntegerUtil.checkId(id)){
                return false ;
            }
        }
        return basketDao.deleteBatchIds(ids)>0;
    }

    @Override
    public Basket update(Basket basket) {
        if(basket==null||!IntegerUtil.checkId(basket.getBasketids())){
            return null;
        }
        int i = basketDao.updateById(basket);
        if(i>0){
            return basketDao.selectById(basket.getBasketids());
        }
        return null;
    }

    @Override
    public Phone getPhoneid(Integer id) {
        return phoneDao.selectById(id);
    }

    @Override
    public User getUserid(Integer id) {
        return userDao.selectById(id);
    }

    @Override
    public Part getPartid(Integer id) {
        return partDao.selectById(id);
    }

    @Override
    public Basket getBasketid(Integer id) {
        return basketDao.selectById(id);
    }

    @Override
    public List<Basket> selectAll() {
        return basketDao.selectAll();
    }

    @Override
    public boolean insert(Basket basket) {
        return basketDao.insert(basket)>0;
    }

    @Override
    public boolean delById(Integer id) {
        if(!IntegerUtil.checkId(id)){
            return false;
        }
        return basketDao.deleteById(id)>0;
    }

    @Override
    public List<Basket> selectBack(Integer id) {
        return basketDao.selectBack(id);
    }

    @Override
    public List<Basket> selectBack2(Integer id) {
        return basketDao.selectBack2(id);
    }

    @Override
    public List<Basket> getByUserId(Integer user_ids) {
        return basketDao.getByUserId(user_ids);
    }

    @Override
    public List<User> getByUserName(String username) {
        return basketDao.getByUserName(username);
    }
}
