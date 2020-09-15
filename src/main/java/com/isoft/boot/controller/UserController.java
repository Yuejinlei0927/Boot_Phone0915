package com.isoft.boot.controller;

import com.isoft.boot.bean.ResponseData;
import com.isoft.boot.entity.Phone;
import com.isoft.boot.entity.Sys;
import com.isoft.boot.entity.User;
import com.isoft.boot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;
    @GetMapping("getById/{id}")
    public ResponseData getById(@NotNull(message = "查询的id为空") @PathVariable("id")Integer id){
        User user = userService.getById(id);
        return new ResponseData(
                user==null?ResponseData.STATUS_FAIL:ResponseData.STATUS_OK,
                user==null?"查询失败":"查询成功",
                user
        );
    }
    @GetMapping("getAll")
    public ResponseData getAll(){
        List<User> list = userService.getAll();
        System.out.println(list);
        return new ResponseData(
                list==null?ResponseData.STATUS_FAIL:ResponseData.STATUS_OK,
                list==null?"查询失败":"查询成功",
                list
        );
    }
    @PostMapping("getMore")
    public ResponseData getMore(@RequestBody Map<String,String> map){
        List<User> users = userService.getUser(map.get("username"));
        System.out.println(map.get("username"));
        return new ResponseData(
                users == null ? ResponseData.STATUS_FAIL:ResponseData.STATUS_OK,
                users == null ? "查询失败":"查询成功",
                users
        );

    }

    @PostMapping("add")
    public ResponseData add(@Validated @RequestBody User user){
        boolean b = userService.insert(user);
        return new ResponseData(
                b?ResponseData.STATUS_OK:ResponseData.STATUS_FAIL,
                b?"添加成功":"添加失败",
                b
        );
    }

    @DeleteMapping("delById/{id}")
    public ResponseData delById(@NotNull(message = "id为空")@PathVariable("id") Integer id){
        boolean b = userService.delById(id);
        return new ResponseData(
                b?ResponseData.STATUS_OK:ResponseData.STATUS_FAIL,
                b?"删除成功":"删除失败",
                b
        );
    }
    @DeleteMapping("delByIds")
    public ResponseData delByIds(@NotEmpty(message = "要删除的数据集合ids为空") @RequestBody Map<String,
            List<Integer>> map){
        boolean b = userService.delByIds(map.get("ids"));
        return new ResponseData(
                b?ResponseData.STATUS_OK:ResponseData.STATUS_FAIL,
                b?"删除成功":"删除失败",
                b
        );
    }
    @PutMapping("update")
    public ResponseData update(@Validated @RequestBody User user){
        User ResultUser = userService.update(user);
        return new ResponseData(
                ResultUser!= null ? ResponseData.STATUS_OK:ResponseData.STATUS_FAIL,
                ResultUser!= null ? "更新成功":"更新失败",
                ResultUser
        );

    }
    @PostMapping("login")
    public ResponseData login(@RequestBody Map<String,String> getInfo, HttpSession session){

        System.out.println(getInfo);
        Map<String,Object> map = userService.getUser(getInfo.get("username"),getInfo.get(
                "userpass"));
        Object obj1 ;
        List<User> list = userService.getAll();
        System.out.println("list:"+list);
        for (User user : list) {

            if(user.getUsername() == getInfo.get("username")/*&&user.getUserpass()==getInfo.get(
                    "userpass")*/){
                System.out.println("user:"+user);
            };

        }

        Object obj = map.get("data");
        if(obj!=null){
            //校验成功
            session.setAttribute("User",obj);

        }
        System.out.println(obj);
        return new ResponseData(obj!=null?"001":"002", (String)map.get("msg"),obj);
    }
}
