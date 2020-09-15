package com.isoft.boots.controller;

import com.isoft.boots.entity.Part;
import com.isoft.boots.service.PartService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 手机配件表(Part)表控制层
 *
 * @author PaulFrank
 * @since 2020-09-15 10:51:33
 */
@RestController
@RequestMapping("part")
public class PartController {
    /**
     * 服务对象
     */
    @Resource
    private PartService partService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public Part selectOne(Integer id) {
        return this.partService.queryById(id);
    }

}