package com.isoft.boots.service;

import com.isoft.boots.entity.News;

import java.util.List;

/**
 * 手机资讯表(News)表服务接口
 *
 * @author PaulFrank
 * @since 2020-09-15 10:51:18
 */
public interface NewsService {

    /**
     * 通过ID查询单条数据
     *
     * @param newsId 主键
     * @return 实例对象
     */
    News queryById(Integer newsId);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<News> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param news 实例对象
     * @return 实例对象
     */
    News insert(News news);

    /**
     * 修改数据
     *
     * @param news 实例对象
     * @return 实例对象
     */
    News update(News news);

    /**
     * 通过主键删除数据
     *
     * @param newsId 主键
     * @return 是否成功
     */
    boolean deleteById(Integer newsId);

}