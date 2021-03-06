package com.isoft.boots.service;

import com.isoft.boots.entity.Brand;

import java.util.List;

/**
 * 手机品牌表(Brand)表服务接口
 *
 * @author PaulFrank
 * @since 2020-09-15 10:50:55
 */
public interface BrandService {

    /**
     * 通过ID查询单条数据
     *
     * @param brandId 主键
     * @return 实例对象
     */
    Brand queryById(Integer brandId);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<Brand> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param brand 实例对象
     * @return 实例对象
     */
    Brand insert(Brand brand);

    /**
     * 修改数据
     *
     * @param brand 实例对象
     * @return 实例对象
     */
    Brand update(Brand brand);

    /**
     * 通过主键删除数据
     *
     * @param brandId 主键
     * @return 是否成功
     */
    boolean deleteById(Integer brandId);

}