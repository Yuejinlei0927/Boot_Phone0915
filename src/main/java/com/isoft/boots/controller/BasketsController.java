package com.isoft.boots.controller;

import com.isoft.boots.entity.Baskets;
import com.isoft.boots.service.BasketsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 订单表(Baskets)表控制层
 *
 * @author PaulFrank
 * @since 2020-09-15 10:50:30
 */
@RestController
@RequestMapping("baskets")
public class BasketsController {
    /**
     * 服务对象
     */
    @Resource
    private BasketsService basketsService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public Baskets selectOne(Integer id) {
        return this.basketsService.queryById(id);
    }

}