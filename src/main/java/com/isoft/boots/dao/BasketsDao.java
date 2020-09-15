package com.isoft.boots.dao;

import com.isoft.boots.entity.Baskets;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 订单表(Baskets)表数据库访问层
 *
 * @author PaulFrank
 * @since 2020-09-15 10:50:27
 */
public interface BasketsDao {

    /**
     * 通过ID查询单条数据
     *
     * @param basketIds 主键
     * @return 实例对象
     */
    Baskets queryById(Integer basketIds);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<Baskets> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param baskets 实例对象
     * @return 对象列表
     */
    List<Baskets> queryAll(Baskets baskets);

    /**
     * 新增数据
     *
     * @param baskets 实例对象
     * @return 影响行数
     */
    int insert(Baskets baskets);

    /**
     * 修改数据
     *
     * @param baskets 实例对象
     * @return 影响行数
     */
    int update(Baskets baskets);

    /**
     * 通过主键删除数据
     *
     * @param basketIds 主键
     * @return 影响行数
     */
    int deleteById(Integer basketIds);

}