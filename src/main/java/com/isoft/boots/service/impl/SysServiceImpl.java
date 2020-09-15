package com.isoft.boots.service.impl;

import com.isoft.boots.dao.SysDao;
import com.isoft.boots.entity.Sys;
import com.isoft.boots.service.SysService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 管理员表(Sys)表服务实现类
 *
 * @author PaulFrank
 * @since 2020-09-15 10:51:51
 */
@Service("sysService")
public class SysServiceImpl implements SysService {
    @Resource
    private SysDao sysDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public Sys queryById(Integer id) {
        return this.sysDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    @Override
    public List<Sys> queryAllByLimit(int offset, int limit) {
        return this.sysDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param sys 实例对象
     * @return 实例对象
     */
    @Override
    public Sys insert(Sys sys) {
        this.sysDao.insert(sys);
        return sys;
    }

    /**
     * 修改数据
     *
     * @param sys 实例对象
     * @return 实例对象
     */
    @Override
    public Sys update(Sys sys) {
        this.sysDao.update(sys);
        return this.queryById(sys.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.sysDao.deleteById(id) > 0;
    }
}