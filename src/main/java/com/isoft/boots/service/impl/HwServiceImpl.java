package com.isoft.boots.service.impl;

import com.isoft.boots.dao.HwDao;
import com.isoft.boots.entity.Hw;
import com.isoft.boots.service.HwService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 手机商品表(Hw)表服务实现类
 *
 * @author PaulFrank
 * @since 2020-09-15 10:51:08
 */
@Service("hwService")
public class HwServiceImpl implements HwService {
    @Resource
    private HwDao hwDao;

    /**
     * 通过ID查询单条数据
     *
     * @param hwId 主键
     * @return 实例对象
     */
    @Override
    public Hw queryById(Integer hwId) {
        return this.hwDao.queryById(hwId);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    @Override
    public List<Hw> queryAllByLimit(int offset, int limit) {
        return this.hwDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param hw 实例对象
     * @return 实例对象
     */
    @Override
    public Hw insert(Hw hw) {
        this.hwDao.insert(hw);
        return hw;
    }

    /**
     * 修改数据
     *
     * @param hw 实例对象
     * @return 实例对象
     */
    @Override
    public Hw update(Hw hw) {
        this.hwDao.update(hw);
        return this.queryById(hw.getHwId());
    }

    /**
     * 通过主键删除数据
     *
     * @param hwId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer hwId) {
        return this.hwDao.deleteById(hwId) > 0;
    }
}