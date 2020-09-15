package com.isoft.boots.service;

import com.isoft.boots.entity.Sys;

import java.util.List;

/**
 * 管理员表(Sys)表服务接口
 *
 * @author PaulFrank
 * @since 2020-09-15 10:51:51
 */
public interface SysService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Sys queryById(Integer id);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<Sys> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param sys 实例对象
     * @return 实例对象
     */
    Sys insert(Sys sys);

    /**
     * 修改数据
     *
     * @param sys 实例对象
     * @return 实例对象
     */
    Sys update(Sys sys);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

}