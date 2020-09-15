package com.isoft.boot.controller;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.isoft.boot.bean.Basketss;
import com.isoft.boot.bean.ResponseData;
import com.isoft.boot.entity.*;
import com.isoft.boot.service.BasketService;
import com.isoft.boot.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.*;
import javax.xml.crypto.Data;
import java.util.*;

@RestController
@CrossOrigin
@RequestMapping("/basket")
public class BasketController {
    @Autowired
    BasketService basketService;
    @PostMapping("add")
    public ResponseData add(@Validated @RequestBody Basket basket){
        boolean b = basketService.insert(basket);
        System.out.println(basket);
        return new ResponseData(
                b?ResponseData.STATUS_OK:ResponseData.STATUS_FAIL,
                b?"添加成功":"添加失败",
                b
        );

    }
    @DeleteMapping("delByIds")
    public ResponseData delByIds(@NotEmpty(message = "要删除的数据ids为空") @RequestBody Map<String,List<Integer>> map){
        boolean b = basketService.delByIds(map.get("ids"));
        return new ResponseData(
                b?ResponseData.STATUS_OK:ResponseData.STATUS_FAIL,
                b?"删除成功":"删除失败",
                b
        );
    }
    @PutMapping("update")
    public ResponseData update(@Validated @RequestBody Basket basket){
        System.out.println("basket:"+basket);
        Basket ResultBasket = basketService.update(basket);
        System.out.println("Result:"+ResultBasket);
        return new ResponseData(
                ResultBasket!= null ? ResponseData.STATUS_OK:ResponseData.STATUS_FAIL,
                ResultBasket!= null ? "更新成功":"更新失败",
                ResultBasket
        );

    }
    @DeleteMapping("delById/{id}")
    public ResponseData delById(@NotNull(message = "ID为空")@PathVariable("id")Integer id){
        boolean b = basketService.delById(id);
        return new ResponseData(
                b?ResponseData.STATUS_OK:ResponseData.STATUS_FAIL,
                b?"删除成功":"删除失败",
                b
        );
    }
    @GetMapping("getByPhoneId/{id}")
    public ResponseData getByPhoneId(@NotNull(message = "查询的id为空") @PathVariable("id")Integer id){
        Phone idPhone = basketService.getPhoneid(id);
        return new ResponseData(
                idPhone == null ?ResponseData.STATUS_FAIL:ResponseData.STATUS_OK,
                idPhone == null ? "查找失败":"查找成功",
                idPhone
        );
    }
    @GetMapping("getByPartId/{id}")
    public ResponseData getByPartId(@NotNull(message = "查询的id为空") @PathVariable("id")Integer id){
        Part idPart = basketService.getPartid(id);
        return new ResponseData(
                idPart == null ?ResponseData.STATUS_FAIL:ResponseData.STATUS_OK,
                idPart == null ? "查找失败":"查找成功",
                idPart
        );
    }
    @GetMapping("getByUserId/{id}")
    public ResponseData getByUserId(@NotNull(message = "查询的id为空") @PathVariable("id")Integer id){
        User idUser = basketService.getUserid(id);
        return new ResponseData(
                idUser == null ?ResponseData.STATUS_FAIL:ResponseData.STATUS_OK,
                idUser == null ? "查找失败":"查找成功",
                idUser
        );
    }
    @GetMapping("getByBasketId/{id}")
    public ResponseData getByBasketId(@NotNull(message = "查询的id为空") @PathVariable("id")Integer id){
        Basket idbasket = basketService.getBasketid(id);
        return new ResponseData(
                idbasket == null ?ResponseData.STATUS_FAIL:ResponseData.STATUS_OK,
                idbasket == null ? "查找失败":"查找成功",
                idbasket
        );
    }
    @GetMapping("getByBasketAll")
    public ResponseData getBasketAll(){
        List<Basket> idbasket = basketService.selectAll();
        System.out.println("idbasket:"+idbasket);
        return new ResponseData(
                idbasket == null ?ResponseData.STATUS_FAIL:ResponseData.STATUS_OK,
                idbasket == null ? "查找失败":"查找成功",
                idbasket
        );
    }
    @PostMapping("getShopList")
    public ResponseData getShopList(@RequestBody List<Map<String,Object>> list){
        Integer basketId  = null;
        Integer hwId  = null;
        Integer userId  = null;
        Integer partId  = null;
        Integer count = null;
        String status = null;
        String back = null;
        List<Basketss> lists = new ArrayList<>();
        System.out.println("list:"+list);
        for (Map<String, Object> map : list) {
             basketId = (Integer) map.get("basketids");
             hwId = (Integer) map.get("hwids");
             userId = (Integer) map.get("userids");
             partId = (Integer) map.get("partids");
            Basketss basketss = new Basketss();
            Basket basketid = basketService.getBasketid(basketId);
            System.out.println("basketid:"+basketid);
             back = basketid.getBackids();
            count = basketid.getCountids();
             status = basketid.getStatusids();
            Integer basketids = basketid.getBasketids();

            User userid = basketService.getUserid(userId);
            String username = userid.getUsername();
            basketss.setUsername(username);
            basketss.setBasketids(basketids);
            basketss.setShopcount(count);
            basketss.setStatus(status);
            basketss.setBack(back);
            if(partId ==null){
                Phone phoneid = basketService.getPhoneid(hwId);
                String shopname = phoneid.getHwname();
                Integer hwprice = phoneid.getHwprice();
                basketss.setShopprice(hwprice);
                basketss.setShopname(shopname);
            }else if(hwId == null){
                Part partid = basketService.getPartid(partId);
                String partname = partid.getPartname();
                Integer partprice = partid.getPartprice();
                basketss.setShopname(partname);
                basketss.setShopprice(partprice);
            }
            lists.add(basketss);
            System.out.println("basketss:"+basketss);
        }
        return new ResponseData(
                lists.size() == 0 ?ResponseData.STATUS_FAIL:ResponseData.STATUS_OK,
                lists.size() == 0 ? "查找失败":"查找成功",
                lists
        ) ;
    }
    @GetMapping("getBack/{id}")
    public ResponseData getBack(@NotNull(message = "查询的id为空") @PathVariable("id")Integer id){
        List<Basket> idbasket = basketService.selectBack(id);
        System.out.println(idbasket);
        return new ResponseData(
                idbasket == null ?ResponseData.STATUS_FAIL:ResponseData.STATUS_OK,
                idbasket == null ? "查找失败":"查找成功",
                idbasket
        );
    }
    @GetMapping("getBack2/{id}")
    public ResponseData getBack2(@NotNull(message = "查询的id为空") @PathVariable("id")Integer id){
        List<Basket> idbasket = basketService.selectBack2(id);
        System.out.println(idbasket);
        return new ResponseData(
                idbasket == null ?ResponseData.STATUS_FAIL:ResponseData.STATUS_OK,
                idbasket == null ? "查找失败":"查找成功",
                idbasket
        );
    }
    @GetMapping("getShopByUserId/{user_ids}")
    public ResponseData getListByUserId(@NotNull(message = "查询的id为空") @PathVariable("user_ids")Integer user_ids){
        List<Basket> byUserId = basketService.getByUserId(user_ids);
        System.out.println(byUserId);
        Integer basketId = null;
        Integer hwId  = null;
        Integer partId  = null;
        Integer count = null;
        String status = null;
        String back = null;
        Date adddatetime = null;
        List<Basketss> lists = new ArrayList<>();
        for (Basket basket : byUserId) {
            Basketss basketss = new Basketss();
            basketId = basket.getBasketids();
            adddatetime = basket.getAdddatetime();
            back = basket.getBackids();
            status = basket.getStatusids();
            count = basket.getCountids();
            basketss.setStatus(basket.getStatusids());
            basketss.setShopcount(basket.getCountids());
            basketss.setBasketids(basketId);
            basketss.setAdddatetime( adddatetime);
            if(basket.getHwids()==null){
                 partId = basket.getPartids();
                Part part = basketService.getPartid(partId);
                basketss.setShopname(part.getPartname());
                basketss.setShopprice(part.getPartprice());
            }else if(basket.getPartids() == null){
                 hwId = basket.getHwids();
                Phone phone = basketService.getPhoneid(hwId);
                basketss.setShopname(phone.getHwname());
                basketss.setShopprice(phone.getHwprice());
            }
            lists.add(basketss);
            System.out.println(basketss);
        }
        return new ResponseData(
                lists.size() == 0 ?ResponseData.STATUS_FAIL:ResponseData.STATUS_OK,
                lists.size() == 0 ? "查找失败":"查找成功",
                lists
        ) ;

    }
    @GetMapping("getMore/{username}")
    public ResponseData getShopListByUserName(@PathVariable("username")String username){
        List<User> byUserName = basketService.getByUserName(username);


        Integer basketId = null;
        String usernames = null;
        Integer hwId  = null;
        Integer partId  = null;
        Integer count = null;
        String status = null;
        String back = null;
        Date adddatetime = null;
        List<Basketss> basketsses = new ArrayList<>();

        for (User user : byUserName) {
          Integer useridss = user.getUserid();
            List<Basket> byUserId = basketService.getByUserId(useridss);
            for (Basket basket : byUserId) {
                Basketss basketss = new Basketss();
                 basketId = basket.getBasketids();
                Integer userid = basket.getUserids();
                 count = basket.getCountids();
                 status = basket.getStatusids();
                User userid1 = basketService.getUserid(userid);
                  usernames = userid1.getUsername();
                  basketss.setBasketids(basketId);
                  basketss.setShopcount(count);
                  basketss.setStatus(status);
                  basketss.setUsername(usernames);
                 hwId = basket.getHwids();
                 partId = basket.getPartids();
                 if(hwId==null){
                     Part partid = basketService.getPartid(partId);
                      String partname = partid.getPartname();
                     Integer partprice = partid.getPartprice();
                     basketss.setShopname(partname);
                     basketss.setShopprice(partprice);
                 }else if(partId==null){
                     Phone phoneid = basketService.getPhoneid(hwId);
                     String hwname = phoneid.getHwname();
                     Integer hwprice = phoneid.getHwprice();
                     basketss.setShopname(hwname);
                     basketss.setShopprice(hwprice);

                 }
                 basketsses.add(basketss);
                System.out.println("basketsses:"+basketsses);
            }
//
        }
        return new ResponseData(
                basketsses==null?ResponseData.STATUS_FAIL:ResponseData.STATUS_OK,
                basketsses==null?"查询失败":"查询成功",
                basketsses
        );
    }
}
