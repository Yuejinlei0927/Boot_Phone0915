package com.isoft.boot.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.isoft.boot.dao.SysDao;
import com.isoft.boot.entity.Sys;
import com.isoft.boot.entity.User;
import com.isoft.boot.service.SysService;
import com.isoft.boot.util.IntegerUtil;
import com.isoft.boot.util.MD5Util;
import com.isoft.boot.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Transactional
@Service
public class SysServiceImpl implements SysService {
    @Autowired
    SysDao sysDao;
    @Override
    public boolean insert(Sys sys) {
        if(sys==null|| StringUtil.isEmpty(sys.getSysname())||StringUtil.isEmpty(sys.getSyspass())){
           return false;
        }
        return sysDao.insert(sys)>0;
    }

    @Override
    public boolean delById(Integer id) {
        if(!IntegerUtil.checkId(id)){
            return false;
        }
        return sysDao.deleteById(id)>0;
    }

    @Override
    public boolean delByIds(List<Integer> ids) {
        if(ids==null||ids.size()==0){
            return false;
        }
        for (Integer id : ids) {
           if(!IntegerUtil.checkId(id)){
               return false;
           }
        }
        return sysDao.deleteBatchIds(ids)>0;
    }

    @Override
    public Sys update(Sys sys) {
        if(sys==null||!IntegerUtil.checkId(sys.getId())){
            return null;
        }
        int i = sysDao.updateById(sys);
        if(i>0){
            return sysDao.selectById(sys.getId());
        }
        return null;
    }

    @Override
    public List<Sys> getAll() {
        return sysDao.selectList(null);
    }

    @Override
    public Sys getById(Integer id) {
        if(!IntegerUtil.checkId(id)){
            return null;
        }
        return sysDao.selectById(id);
    }

    @Override
    public List<Sys> getSyss(String brand) {
        Map<String,String > map = new HashMap<>();
        map.put("sysname",brand);
        QueryWrapper<Sys> wrapper = new QueryWrapper<>();
        wrapper.like("sys_name",brand);
        return sysDao.selectList(wrapper);
    }

    @Override
    public Map<String, Object> getSys(String name, String pass) {
        Map<String,Object> map = new HashMap<>();
        String msg;
        if(StringUtil.isEmpty(name)||StringUtil.isEmpty(pass)){
            msg = "账号或密码为空！";
        }else {
            //先检查名字是否存在
            int namecount =  sysDao.checkName(name);
            if(namecount==0){
                msg = "账号不存在";
            }else{
                //如果存在 校验账号密码是否正确
                Sys sys = sysDao.login(name, pass);
                if(sys==null){
                    msg = "密码错误!";
                }else {
                    msg = "密码正确 登陆成功！";
                    map.put("data",sys);
                }

            }
        }
        map.put("msg",msg);
        return map;
    }
}

