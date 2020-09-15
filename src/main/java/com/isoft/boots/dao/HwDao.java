package com.isoft.boots.dao;

import com.isoft.boots.entity.Hw;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 手机商品表(Hw)表数据库访问层
 *
 * @author PaulFrank
 * @since 2020-09-15 10:51:08
 */
public interface HwDao {

    /**
     * 通过ID查询单条数据
     *
     * @param hwId 主键
     * @return 实例对象
     */
    Hw queryById(Integer hwId);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<Hw> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param hw 实例对象
     * @return 对象列表
     */
    List<Hw> queryAll(Hw hw);

    /**
     * 新增数据
     *
     * @param hw 实例对象
     * @return 影响行数
     */
    int insert(Hw hw);

    /**
     * 修改数据
     *
     * @param hw 实例对象
     * @return 影响行数
     */
    int update(Hw hw);

    /**
     * 通过主键删除数据
     *
     * @param hwId 主键
     * @return 影响行数
     */
    int deleteById(Integer hwId);

}