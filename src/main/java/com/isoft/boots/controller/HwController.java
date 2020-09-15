package com.isoft.boots.controller;

import com.isoft.boots.entity.Hw;
import com.isoft.boots.service.HwService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 手机商品表(Hw)表控制层
 *
 * @author PaulFrank
 * @since 2020-09-15 10:51:08
 */
@RestController
@RequestMapping("hw")
public class HwController {
    /**
     * 服务对象
     */
    @Resource
    private HwService hwService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public Hw selectOne(Integer id) {
        return this.hwService.queryById(id);
    }

}