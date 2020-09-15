package com.isoft.boots.service;

import com.isoft.boots.entity.Part;

import java.util.List;

/**
 * 手机配件表(Part)表服务接口
 *
 * @author PaulFrank
 * @since 2020-09-15 10:51:33
 */
public interface PartService {

    /**
     * 通过ID查询单条数据
     *
     * @param partId 主键
     * @return 实例对象
     */
    Part queryById(Integer partId);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<Part> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param part 实例对象
     * @return 实例对象
     */
    Part insert(Part part);

    /**
     * 修改数据
     *
     * @param part 实例对象
     * @return 实例对象
     */
    Part update(Part part);

    /**
     * 通过主键删除数据
     *
     * @param partId 主键
     * @return 是否成功
     */
    boolean deleteById(Integer partId);

}