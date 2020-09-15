package com.isoft.boot.controller;

import com.isoft.boot.bean.ResponseData;
import com.isoft.boot.entity.Part;
import com.isoft.boot.entity.Phone;
import com.isoft.boot.service.PartService;
import com.isoft.boot.service.PhoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin
@RequestMapping("/part")
public class PartController {
    @Autowired
    PartService partService;
    @GetMapping("getById/{id}")
    public ResponseData getById(@NotNull(message = "查询的ID为空") @PathVariable("id")Integer id){
        Part part = partService.getById(id);
        return new ResponseData(
                part==null?ResponseData.STATUS_FAIL:ResponseData.STATUS_OK,
                part==null?"查询失败":"查询成功",
                part
        );
    }
    @GetMapping("getAll")
    public ResponseData getAll(){
        List<Part> list = partService.getAll();
        return new ResponseData(
                list==null?ResponseData.STATUS_FAIL:ResponseData.STATUS_OK,
                list==null?"查询失败":"查询成功",
                list

        );
    }
    @PostMapping("getMore")
    public ResponseData getMore(@RequestBody Map<String,String> map){
        List<Part> parts = partService.getParts(map.get("partname"));
        System.out.println(map.get("partname"));//null
        return new ResponseData(
                parts == null ? ResponseData.STATUS_FAIL:ResponseData.STATUS_OK,
                parts == null ? "查询失败":"查询成功",
                parts
        );

    }
    @PostMapping("add")
    public ResponseData add(@Validated @RequestBody Part part){
        boolean b = partService.insert(part);
        return new ResponseData(
                b?ResponseData.STATUS_OK:ResponseData.STATUS_FAIL,
                b?"添加成功":"添加失败",
                b
        );

    }
    @DeleteMapping("delById/{id}")
    public ResponseData delById(@NotNull(message = "ID为空")@PathVariable("id")Integer id){
        boolean b = partService.delById(id);
        return new ResponseData(
                b?ResponseData.STATUS_OK:ResponseData.STATUS_FAIL,
                b?"删除成功":"删除失败",
                b
        );
    }
    @DeleteMapping("delByIds")
    public ResponseData delByIds(@NotEmpty(message = "要删除的数据ids为空") @RequestBody Map<String,List<Integer>> map){
        boolean b = partService.delByIds(map.get("ids"));
        return new ResponseData(
                b?ResponseData.STATUS_OK:ResponseData.STATUS_FAIL,
                b?"删除成功":"删除失败",
                b
        );
    }
    @PutMapping("update")
    public ResponseData update(@Validated @RequestBody Part part){
        System.out.println(part);
        Part ResultPart = partService.update(part);
//        System.out.println(ResultPhone);
        return new ResponseData(
                ResultPart!= null ? ResponseData.STATUS_OK:ResponseData.STATUS_FAIL,
                ResultPart!= null ? "更新成功":"更新失败",
                ResultPart
        );

    }

}
