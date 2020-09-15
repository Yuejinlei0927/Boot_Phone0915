package com.isoft.boot.service;

import com.isoft.boot.entity.Brand;
import com.isoft.boot.entity.Sys;
import com.isoft.boot.entity.User;

import java.util.List;
import java.util.Map;

public interface UserService {
    boolean insert(User user);
    boolean delById(Integer id);
    boolean delByIds(List<Integer> ids);
    User update(User user);
    List<User> getAll();
    User getById(Integer id);
    List<User> getUser(String brand);
    Map<String,Object> getUser(String name, String pass);

}
