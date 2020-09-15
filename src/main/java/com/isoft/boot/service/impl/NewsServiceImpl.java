package com.isoft.boot.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.isoft.boot.dao.NewsDao;
import com.isoft.boot.entity.Brand;
import com.isoft.boot.entity.News;
import com.isoft.boot.service.NewsService;
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
public class NewsServiceImpl implements NewsService {
    @Autowired
     NewsDao newsDao;
    @Override
    public boolean insert(News news) {
        if(news==null){
            return false;
        }
        return newsDao.insert(news)>0;
    }

    @Override
    public boolean delById(Integer id) {
        if(!IntegerUtil.checkId(id)){
            return false;
        }
        return newsDao.deleteById(id)>0;
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
        return newsDao.deleteBatchIds(ids)>0;
    }

    @Override
    public News update(News news) {
        if(news==null||!IntegerUtil.checkId(news.getNewsid())){
            return null;
        }
        int r = newsDao.updateById(news);
        if(r>0){
            return newsDao.selectById(news.getNewsid()) ;
        }
            return null;
    }

    @Override
    public List<News> getAll() {
        return newsDao.selectList(null);
    }

    @Override
    public News getById(Integer id) {
        if(!IntegerUtil.checkId(id)){
            return null;
        }
        return newsDao.selectById(id);
    }

    @Override
    public List<News> getNews(String brand) {
        Map<String,String > map = new HashMap<>();
        map.put("newstitle",brand);
        QueryWrapper<News> wrapper = new QueryWrapper<>();
        wrapper.like("news_title",brand);
        return newsDao.selectList(wrapper);
    }
}
