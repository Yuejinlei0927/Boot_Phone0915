package com.isoft.boot.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.isoft.boot.dao.UserDao;
import com.isoft.boot.entity.Brand;
import com.isoft.boot.entity.Sys;
import com.isoft.boot.entity.User;
import com.isoft.boot.service.UserService;
import com.isoft.boot.util.IntegerUtil;
import com.isoft.boot.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Service
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    UserDao userDao;


    @Override
    public boolean insert(User user) {
        if(user==null|| StringUtil.isEmpty(user.getUsername())||StringUtil.isEmpty(user.getUserpass())){

            return false;
        }

        return userDao.insert(user)>0;
    }

    @Override
    public boolean delById(Integer id) {
        if(!IntegerUtil.checkId(id)){
            return false;
        }
        return userDao.deleteById(id)>0;
    }

    @Override
    public boolean delByIds(List<Integer> ids) {
        if(ids==null||ids.size()==0){
            return false;
        } for (Integer id : ids) {
          if(!IntegerUtil.checkId(id)) {
              return false;
          }
        }
        return userDao.deleteBatchIds(ids)>0;
    }

    @Override
    public User update(User user) {
        if(user==null){
            return null;
        }
        int i = userDao.updateById(user);
        if(i>0){

            return userDao.selectById(user.getUserid());

        }
        return null;

    }

    @Override
    public List<User> getAll() {
        return userDao.selectList(null);
    }

    @Override
    public User getById(Integer id) {
        if(!IntegerUtil.checkId(id)){
            return null;
        }
        return userDao.selectById(id);
    }

    @Override
    public List<User> getUser(String brand) {
        Map<String,String > map = new HashMap<>();
        map.put("username",brand);
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.like("user_name",brand);
        return userDao.selectList(wrapper);
    }

    @Override
    public Map<String, Object> getUser(String name, String pass) {
        Map<String,Object> map = new HashMap<>();
        String msg;
        if(StringUtil.isEmpty(name)||StringUtil.isEmpty(pass)){
            msg = "账号或密码为空！";
        }else {
            //先检查名字是否存在
            int namecount =  userDao.checkName(name);
            if(namecount==0){
                msg = "账号不存在";
            }else{
                //如果存在 校验账号密码是否正确
                User user = userDao.login(name, pass);
                if(user==null){
                    msg = "密码错误!";
                }else {
                    msg = "密码正确 登陆成功！";
                    map.put("data",user);
                    System.out.println(user);
                }

            }
        }
         map.put("msg",msg);
         return map;
    }
}
