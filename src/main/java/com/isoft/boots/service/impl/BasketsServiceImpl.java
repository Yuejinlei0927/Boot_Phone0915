package com.isoft.boots.service.impl;

import com.isoft.boots.dao.BasketsDao;
import com.isoft.boots.entity.Baskets;
import com.isoft.boots.service.BasketsService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 订单表(Baskets)表服务实现类
 *
 * @author PaulFrank
 * @since 2020-09-15 10:50:29
 */
@Service("basketsService")
public class BasketsServiceImpl implements BasketsService {
    @Resource
    private BasketsDao basketsDao;

    /**
     * 通过ID查询单条数据
     *
     * @param basketIds 主键
     * @return 实例对象
     */
    @Override
    public Baskets queryById(Integer basketIds) {
        return this.basketsDao.queryById(basketIds);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    @Override
    public List<Baskets> queryAllByLimit(int offset, int limit) {
        return this.basketsDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param baskets 实例对象
     * @return 实例对象
     */
    @Override
    public Baskets insert(Baskets baskets) {
        this.basketsDao.insert(baskets);
        return baskets;
    }

    /**
     * 修改数据
     *
     * @param baskets 实例对象
     * @return 实例对象
     */
    @Override
    public Baskets update(Baskets baskets) {
        this.basketsDao.update(baskets);
        return this.queryById(baskets.getBasketIds());
    }

    /**
     * 通过主键删除数据
     *
     * @param basketIds 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer basketIds) {
        return this.basketsDao.deleteById(basketIds) > 0;
    }
}