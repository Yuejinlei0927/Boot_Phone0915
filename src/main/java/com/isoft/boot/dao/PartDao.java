package com.isoft.boot.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.isoft.boot.entity.Part;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface PartDao extends BaseMapper<Part> {
    //根据关键字查询配件
    @Select("select * from part where part_name like #{brandKey}")
    public Part getParts(@Param("part_name") String brandKey);

}
