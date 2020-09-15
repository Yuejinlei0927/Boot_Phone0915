package com.isoft.boot.service;

import com.isoft.boot.entity.Phone;
import com.isoft.boot.entity.Sys;

import java.util.List;

public interface PhoneService {
    boolean insert(Phone phone);
    boolean delById(Integer id);
    boolean delByIds(List<Integer> ids);
    Phone update(Phone phone);
    List<Phone> getAll();
    Phone getById(Integer id);
    List<Phone> getPhones(String brand);
    List<Phone> getPhoneName(String brand);
}
