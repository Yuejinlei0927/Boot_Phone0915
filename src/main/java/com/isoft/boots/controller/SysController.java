package com.isoft.boots.controller;

import com.isoft.boots.entity.Sys;
import com.isoft.boots.service.SysService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 管理员表(Sys)表控制层
 *
 * @author PaulFrank
 * @since 2020-09-15 10:51:51
 */
@RestController
@RequestMapping("sys")
public class SysController {
    /**
     * 服务对象
     */
    @Resource
    private SysService sysService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public Sys selectOne(Integer id) {
        return this.sysService.queryById(id);
    }

}