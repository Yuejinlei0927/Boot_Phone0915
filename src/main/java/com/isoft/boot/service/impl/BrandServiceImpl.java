package com.isoft.boot.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.isoft.boot.dao.BrandDao;
import com.isoft.boot.entity.Brand;
import com.isoft.boot.entity.Phone;
import com.isoft.boot.service.BrandService;
import com.isoft.boot.util.IntegerUtil;
import com.isoft.boot.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Transactional
@Service
public class BrandServiceImpl implements BrandService {
    @Autowired
    BrandDao brandDao;
    @Override
    public Brand getById(Integer id) {
        if(!IntegerUtil.checkId(id)){
            return null;
        }
        return brandDao.selectById(id);
    }

    @Override
    public List<Brand> getAll() {
        return brandDao.selectList(null);
    }

    @Override
    public boolean insert(Brand brand) {
        if(brand==null|| StringUtil.isEmpty(brand.getBrandName())){
            return false;
        }
        return brandDao.insert(brand)>0;
    }

    @Override
    public boolean delById(Integer id) {
        if(!IntegerUtil.checkId(id)){
            return false;
        }
        return brandDao.deleteById(id)>0;
    }

    @Override
    public boolean delByIds(List<Integer> ids) {
        if (ids==null||ids.size()==0) {
            return false;
        }
        for (Integer id : ids) {
            if(!IntegerUtil.checkId(id)){
                return false;
            }
        }

        return  brandDao.deleteBatchIds(ids)>0;
    }

    @Override
    public Brand update(Brand brand) {
        if(brand==null||!IntegerUtil.checkId(brand.getId())){
            return null;
        }
        int r = brandDao.updateById(brand);
        if(r>0){
            return brandDao.selectById(brand.getId());
        }
        return null;
    }

    @Override
    public List<Brand> getBrands(String brand) {
        Map<String,String > map = new HashMap<>();
        map.put("brandName",brand);
        QueryWrapper<Brand> wrapper = new QueryWrapper<>();
        wrapper.like("brand_name",brand);
        return brandDao.selectList(wrapper);
    }
}
