package com.isoft.boot.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.isoft.boot.dao.PartDao;
import com.isoft.boot.entity.Part;
import com.isoft.boot.entity.Phone;
import com.isoft.boot.service.PartService;
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
public class PartServiceImpl implements PartService {
    @Autowired
    PartDao partDao;
    @Override
    public boolean insert(Part part) {
        if(part==null|| StringUtil.isEmpty(part.getPartname())||IntegerUtil.checkId(part.getPartid())){
            return false;
        }
        return partDao.insert(part)>0;
    }

    @Override
    public boolean delById(Integer id) {
        if(!IntegerUtil.checkId(id)){
            return false;
        }
        return partDao.deleteById(id)>0;
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
        return partDao.deleteBatchIds(ids)>0;
    }

    @Override
    public Part update(Part part) {
        if(part==null||!IntegerUtil.checkId(part.getPartid())){
            return null;
        }
        int i = partDao.updateById(part);
        if(i>0){
          return partDao.selectById(part.getPartid());
        }
        return null;
    }

    @Override
    public List<Part> getAll() {
        return partDao.selectList(null);
    }

    @Override
    public Part getById(Integer id) {
        if(!IntegerUtil.checkId(id)){
            return null;
        }
        return partDao.selectById(id);
    }

    @Override
    public List<Part> getParts(String brand) {
        Map<String,String > map = new HashMap<>();
        map.put("partname",brand);
        QueryWrapper<Part> wrapper = new QueryWrapper<>();
        wrapper.like("part_name",brand);
        return partDao.selectList(wrapper);
    }
}
