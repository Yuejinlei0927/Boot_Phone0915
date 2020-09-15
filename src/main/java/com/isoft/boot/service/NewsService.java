package com.isoft.boot.service;

import com.isoft.boot.entity.News;
import com.isoft.boot.entity.Phone;

import java.util.List;

public interface NewsService {
    boolean insert(News news);
    boolean delById(Integer id);
    boolean delByIds(List<Integer> ids);
    News update(News news);
    List<News> getAll();
    News getById(Integer id);
    List<News> getNews(String brand);
}
