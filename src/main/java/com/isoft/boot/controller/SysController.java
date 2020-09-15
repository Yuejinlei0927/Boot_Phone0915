package com.isoft.boot.controller;

import com.isoft.boot.bean.ResponseData;
import com.isoft.boot.entity.Sys;
import com.isoft.boot.entity.User;
import com.isoft.boot.service.SysService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.xml.ws.Response;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin
@RequestMapping("/sys")
public class SysController {
    @Autowired
    SysService sysService;
    @GetMapping("getById/{id}")
    public ResponseData getById(@NotNull(message = "查询的id为空") @PathVariable("id")Integer id){
        Sys sys = sysService.getById(id);
        return new ResponseData(
                sys==null?ResponseData.STATUS_FAIL:ResponseData.STATUS_OK,
                sys==null?"查询失败":"查询成功",
                sys
        );
    }
    @GetMapping("getAll")
    public ResponseData getAll(){
        List<Sys> list = sysService.getAll();
        return new ResponseData(
                list==null?ResponseData.STATUS_FAIL:ResponseData.STATUS_OK,
                list==null?"查询失败":"查询成功",
                list
        );
    }
    @PostMapping("getMore")
    public ResponseData getMore(@RequestBody Map<String,String> map){
        List<Sys> syss = sysService.getSyss(map.get("sysname"));
        System.out.println(map.get("sysname"));
        return new ResponseData(
                syss == null ? ResponseData.STATUS_FAIL:ResponseData.STATUS_OK,
                syss == null ? "查询失败":"查询成功",
                syss
        );

    }

    @PostMapping("add")
    public ResponseData add(@Validated @RequestBody Sys sys){
        boolean b = sysService.insert(sys);
        return new ResponseData(
                b?ResponseData.STATUS_OK:ResponseData.STATUS_FAIL,
                b?"添加成功":"添加失败",
                b
        );
    }
    @DeleteMapping("delById/{id}")
    public ResponseData delById(@NotNull(message = "id为空")@PathVariable("id") Integer id){
        boolean b = sysService.delById(id);
        return new ResponseData(
                b?ResponseData.STATUS_OK:ResponseData.STATUS_FAIL,
                b?"删除成功":"删除失败",
                b
        );
    }
    @DeleteMapping("delByIds")
    public ResponseData delByIds(@NotEmpty(message = "要删除的数据集合ids为空") @RequestBody Map<String,
            List<Integer>> map){
        boolean b = sysService.delByIds(map.get("ids"));
        return new ResponseData(
                b?ResponseData.STATUS_OK:ResponseData.STATUS_FAIL,
                b?"删除成功":"删除失败",
                b
        );
    }
    @PutMapping("update")
    public ResponseData update(@Validated @RequestBody Sys sys){
        Sys ResultSys = sysService.update(sys);
        return new ResponseData(
                ResultSys!= null ? ResponseData.STATUS_OK:ResponseData.STATUS_FAIL,
                ResultSys!= null ? "更新成功":"更新失败",
                ResultSys
        );

    }
    @PostMapping("login")
    public ResponseData login(@RequestBody Map<String,String> getInfo, HttpSession session){

        System.out.println(getInfo);
        Map<String,Object> map = sysService.getSys(getInfo.get("sysname"),getInfo.get("syspass"));
        Object obj = map.get("data");
        if(obj!=null){
            //校验成功
            session.setAttribute("sysUser",obj);

        }
        return new ResponseData(obj!=null?"001":"002", (String)map.get("msg"),obj);
    }
}
