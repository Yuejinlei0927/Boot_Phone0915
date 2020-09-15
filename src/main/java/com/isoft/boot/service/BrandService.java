package com.isoft.boot.service;

import com.isoft.boot.dao.BrandDao;
import com.isoft.boot.entity.Brand;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public interface BrandService {
    Brand getById(Integer id);
    List<Brand> getAll();
    boolean insert(Brand brand);
    boolean delById(Integer id);
    boolean delByIds(List<Integer> ids);
    Brand update(Brand brand);
    List<Brand> getBrands(String brand);
}