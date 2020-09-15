package com.isoft.boots.service;

import com.isoft.boots.entity.Hw;

import java.util.List;

/**
 * 手机商品表(Hw)表服务接口
 *
 * @author PaulFrank
 * @since 2020-09-15 10:51:08
 */
public interface HwService {

    /**
     * 通过ID查询单条数据
     *
     * @param hwId 主键
     * @return 实例对象
     */
    Hw queryById(Integer hwId);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<Hw> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param hw 实例对象
     * @return 实例对象
     */
    Hw insert(Hw hw);

    /**
     * 修改数据
     *
     * @param hw 实例对象
     * @return 实例对象
     */
    Hw update(Hw hw);

    /**
     * 通过主键删除数据
     *
     * @param hwId 主键
     * @return 是否成功
     */
    boolean deleteById(Integer hwId);

}