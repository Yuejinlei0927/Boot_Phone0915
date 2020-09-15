package com.isoft.boot.service;

import com.isoft.boot.entity.Brand;
import com.isoft.boot.entity.Sys;

import java.util.List;
import java.util.Map;

public interface SysService {
    boolean insert(Sys sys);
    boolean delById(Integer id);
    boolean delByIds(List<Integer> ids);
    Sys update(Sys sys);
    List<Sys> getAll();
    Sys getById(Integer id);
    List<Sys> getSyss(String brand);
    //管理员登陆校验
    Map<String,Object> getSys(String name,String pass);
}
