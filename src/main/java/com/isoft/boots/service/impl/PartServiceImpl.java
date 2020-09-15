package com.isoft.boots.service.impl;

import com.isoft.boots.dao.PartDao;
import com.isoft.boots.entity.Part;
import com.isoft.boots.service.PartService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 手机配件表(Part)表服务实现类
 *
 * @author PaulFrank
 * @since 2020-09-15 10:51:33
 */
@Service("partService")
public class PartServiceImpl implements PartService {
    @Resource
    private PartDao partDao;

    /**
     * 通过ID查询单条数据
     *
     * @param partId 主键
     * @return 实例对象
     */
    @Override
    public Part queryById(Integer partId) {
        return this.partDao.queryById(partId);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    @Override
    public List<Part> queryAllByLimit(int offset, int limit) {
        return this.partDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param part 实例对象
     * @return 实例对象
     */
    @Override
    public Part insert(Part part) {
        this.partDao.insert(part);
        return part;
    }

    /**
     * 修改数据
     *
     * @param part 实例对象
     * @return 实例对象
     */
    @Override
    public Part update(Part part) {
        this.partDao.update(part);
        return this.queryById(part.getPartId());
    }

    /**
     * 通过主键删除数据
     *
     * @param partId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer partId) {
        return this.partDao.deleteById(partId) > 0;
    }
}