package com.isoft.boots.dao;

import com.isoft.boots.entity.News;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 手机资讯表(News)表数据库访问层
 *
 * @author PaulFrank
 * @since 2020-09-15 10:51:17
 */
public interface NewsDao {

    /**
     * 通过ID查询单条数据
     *
     * @param newsId 主键
     * @return 实例对象
     */
    News queryById(Integer newsId);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<News> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param news 实例对象
     * @return 对象列表
     */
    List<News> queryAll(News news);

    /**
     * 新增数据
     *
     * @param news 实例对象
     * @return 影响行数
     */
    int insert(News news);

    /**
     * 修改数据
     *
     * @param news 实例对象
     * @return 影响行数
     */
    int update(News news);

    /**
     * 通过主键删除数据
     *
     * @param newsId 主键
     * @return 影响行数
     */
    int deleteById(Integer newsId);

}