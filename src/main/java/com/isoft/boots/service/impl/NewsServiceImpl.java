package com.isoft.boots.service.impl;

import com.isoft.boots.dao.NewsDao;
import com.isoft.boots.entity.News;
import com.isoft.boots.service.NewsService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 手机资讯表(News)表服务实现类
 *
 * @author PaulFrank
 * @since 2020-09-15 10:51:18
 */
@Service("newsService")
public class NewsServiceImpl implements NewsService {
    @Resource
    private NewsDao newsDao;

    /**
     * 通过ID查询单条数据
     *
     * @param newsId 主键
     * @return 实例对象
     */
    @Override
    public News queryById(Integer newsId) {
        return this.newsDao.queryById(newsId);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    @Override
    public List<News> queryAllByLimit(int offset, int limit) {
        return this.newsDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param news 实例对象
     * @return 实例对象
     */
    @Override
    public News insert(News news) {
        this.newsDao.insert(news);
        return news;
    }

    /**
     * 修改数据
     *
     * @param news 实例对象
     * @return 实例对象
     */
    @Override
    public News update(News news) {
        this.newsDao.update(news);
        return this.queryById(news.getNewsId());
    }

    /**
     * 通过主键删除数据
     *
     * @param newsId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer newsId) {
        return this.newsDao.deleteById(newsId) > 0;
    }
}