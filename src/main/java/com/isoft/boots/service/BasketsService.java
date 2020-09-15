package com.isoft.boots.service;

import com.isoft.boots.entity.Baskets;

import java.util.List;

/**
 * 订单表(Baskets)表服务接口
 *
 * @author PaulFrank
 * @since 2020-09-15 10:50:28
 */
public interface BasketsService {

    /**
     * 通过ID查询单条数据
     *
     * @param basketIds 主键
     * @return 实例对象
     */
    Baskets queryById(Integer basketIds);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<Baskets> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param baskets 实例对象
     * @return 实例对象
     */
    Baskets insert(Baskets baskets);

    /**
     * 修改数据
     *
     * @param baskets 实例对象
     * @return 实例对象
     */
    Baskets update(Baskets baskets);

    /**
     * 通过主键删除数据
     *
     * @param basketIds 主键
     * @return 是否成功
     */
    boolean deleteById(Integer basketIds);

}