package com.isoft.boot.controller;

import com.isoft.boot.bean.ResponseData;
import com.isoft.boot.entity.Phone;
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
@RequestMapping("/phone")
public class PhoneController {
    @Autowired
    PhoneService phoneService;
    @GetMapping("getById/{id}")
    public ResponseData getById(@NotNull(message = "查询的ID为空") @PathVariable("id")Integer id){
        Phone phone = phoneService.getById(id);
        return new ResponseData(
                phone==null?ResponseData.STATUS_FAIL:ResponseData.STATUS_OK,
                phone==null?"查询失败":"查询成功",
                phone
        );
    }
    @GetMapping("getAll")
    public ResponseData getAll(){
        List<Phone> list = phoneService.getAll();
        return new ResponseData(
                list==null?ResponseData.STATUS_FAIL:ResponseData.STATUS_OK,
                list==null?"查询失败":"查询成功",
                list

        );
    }
    @PostMapping("getMore")
    public ResponseData getMore(@RequestBody Map<String,String> map){
        List<Phone> phones = phoneService.getPhones(map.get("brandname"));
        System.out.println(map.get("brandname"));//null
        return new ResponseData(
                phones == null ? ResponseData.STATUS_FAIL:ResponseData.STATUS_OK,
                phones == null ? "查询失败":"查询成功",
                phones
        );

    }
    @PostMapping("getMorePhone")
    public ResponseData getMorePhone(@RequestBody Map<String,String> map){
        List<Phone> phones = phoneService.getPhoneName(map.get("hwname"));
        System.out.println(map.get("hwname"));//null
        return new ResponseData(
                phones == null ? ResponseData.STATUS_FAIL:ResponseData.STATUS_OK,
                phones == null ? "查询失败":"查询成功",
                phones
        );

    }
    @PostMapping("add")
    public ResponseData add(@Validated @RequestBody Phone phone){
        boolean b = phoneService.insert(phone);
        return new ResponseData(
                b?ResponseData.STATUS_OK:ResponseData.STATUS_FAIL,
                b?"添加成功":"添加失败",
                b
        );

    }
    @DeleteMapping("delById/{id}")
    public ResponseData delById(@NotNull(message = "ID为空")@PathVariable("id")Integer id){
        boolean b = phoneService.delById(id);
        return new ResponseData(
                b?ResponseData.STATUS_OK:ResponseData.STATUS_FAIL,
                b?"删除成功":"删除失败",
                b
        );
    }
    @DeleteMapping("delByIds")
    public ResponseData delByIds(@NotEmpty(message = "要删除的数据ids为空") @RequestBody Map<String,List<Integer>> map){
        boolean b = phoneService.delByIds(map.get("ids"));
        return new ResponseData(
                b?ResponseData.STATUS_OK:ResponseData.STATUS_FAIL,
                b?"删除成功":"删除失败",
                b
        );
    }
    @PutMapping("update")
    public ResponseData update(@Validated @RequestBody Phone phone){
        System.out.println(phone);
        Phone ResultPhone = phoneService.update(phone);
//        System.out.println(ResultPhone);
        return new ResponseData(
                ResultPhone!= null ? ResponseData.STATUS_OK:ResponseData.STATUS_FAIL,
                ResultPhone!= null ? "更新成功":"更新失败",
                ResultPhone
        );

    }

}
