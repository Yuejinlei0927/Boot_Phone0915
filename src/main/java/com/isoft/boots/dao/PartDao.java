package com.isoft.boots.dao;

import com.isoft.boots.entity.Part;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 手机配件表(Part)表数据库访问层
 *
 * @author PaulFrank
 * @since 2020-09-15 10:51:33
 */
public interface PartDao {

    /**
     * 通过ID查询单条数据
     *
     * @param partId 主键
     * @return 实例对象
     */
    Part queryById(Integer partId);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<Part> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param part 实例对象
     * @return 对象列表
     */
    List<Part> queryAll(Part part);

    /**
     * 新增数据
     *
     * @param part 实例对象
     * @return 影响行数
     */
    int insert(Part part);

    /**
     * 修改数据
     *
     * @param part 实例对象
     * @return 影响行数
     */
    int update(Part part);

    /**
     * 通过主键删除数据
     *
     * @param partId 主键
     * @return 影响行数
     */
    int deleteById(Integer partId);

}