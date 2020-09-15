package com.isoft.boot.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.isoft.boot.dao.PhoneDao;
import com.isoft.boot.entity.Phone;
import com.isoft.boot.service.PhoneService;
import com.isoft.boot.util.IntegerUtil;
import com.isoft.boot.util.StringUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Slf4j
@Service
@Transactional
public class PhoneServiceImpl implements PhoneService {
    @Autowired
    PhoneDao phoneDao;
    @Override
    public boolean insert(Phone phone) {
        if(phone==null|| StringUtil.isEmpty(phone.getHwname())||StringUtil.isEmpty(phone.getBrandname())||IntegerUtil.checkId(phone.getHwid())){
            return false;
        }
        return phoneDao.insert(phone)>0;
    }


    @Override
    public boolean delById(Integer id) {
        if(!IntegerUtil.checkId(id)){
            return false;
        }
        return phoneDao.deleteById(id)>0;
    }

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
        return phoneDao.deleteBatchIds(ids)>0;
    }

    @Override
    public Phone update(Phone phone) {
        if(phone==null||!IntegerUtil.checkId(phone.getHwid())){
            return null;
        }
        int i = phoneDao.updateById(phone);
        if(i>0){
          return phoneDao.selectById(phone.getHwid());
        }
        return null;
    }

    @Override
    public List<Phone> getAll() {
        return phoneDao.selectList(null);
    }

    @Override
    public Phone getById(Integer id) {
        if(!IntegerUtil.checkId(id)){
            return null;
        }
        return phoneDao.selectById(id);
    }

    @Override
    public List<Phone> getPhones(String brand) {
        Map<String,String > map = new HashMap<>();
        map.put("brandname",brand);
        QueryWrapper<Phone> wrapper = new QueryWrapper<>();
        wrapper.like("brand_name",brand);
        return phoneDao.selectList(wrapper);
    }

    @Override
    public List<Phone> getPhoneName(String brand) {
        Map<String,String > map = new HashMap<>();
        map.put("hwname",brand);
        QueryWrapper<Phone> wrapper = new QueryWrapper<>();
        wrapper.like("hw_name",brand);
        return phoneDao.selectList(wrapper);
    }
}
