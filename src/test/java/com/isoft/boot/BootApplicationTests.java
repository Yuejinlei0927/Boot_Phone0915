package com.isoft.boot;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.isoft.boot.controller.BasketController;
import com.isoft.boot.dao.BasketDao;
import com.isoft.boot.dao.NewsDao;
import com.isoft.boot.dao.PhoneDao;
import com.isoft.boot.entity.Basket;
import com.isoft.boot.entity.Brand;
import com.isoft.boot.entity.News;
import com.isoft.boot.entity.Phone;
import com.isoft.boot.service.BasketService;
import com.isoft.boot.service.BrandService;
import com.isoft.boot.service.NewsService;
import com.isoft.boot.service.UserService;
import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.*;

@SpringBootTest
class BootApplicationTests {
/*@Autowired
    BrandService brandService;
@Autowired
BasketService basketService;
@Autowired
PhoneDao phoneDao;
@Autowired
NewsDao newsDao;*/
    @Autowired
    BrandService brandService;
//@Autowired
//    NewsService newsService;
//    @Autowired
//    UserService userService;
    @Autowired
    private BasketDao basketDao;
    @Autowired
    private BasketController basketController;
    @Autowired
    private  BasketService basketService;
    @Test
    void contextLoads() {
//        System.out.println(brandService.getById(1));
//        System.out.println(brandService.insert(new Brand(null,"MI","小米公司")));
//        System.out.println(brandService.delById(4));
//        System.out.println(brandService.update(new Brand(3,"XIAOMI","雷军")));
//        System.out.println(brandService.getAll());
//        System.out.println(basketService.getById(1));
        //分页测试
//        Page<Phone> page = new Page<>(2,10);
//        QueryWrapper<Phone> wrapper = new QueryWrapper<>();

//        phoneDao.selectPage(page,null);
//        System.out.println("记录总数"+page.getTotal());
//        System.out.println("页码总数"+page.getPages());
//        System.out.println("当前页码"+page.getCurrent());
//        System.out.println("每页个数"+page.getSize());
//        System.out.println(page.getRecords());
//        System.out.println(newsDao.selectById(1));
//        System.out.println(newsService.getById(1));
//        Date date = new Date();
//        System.out.println(date);
//        News news = new News(3,"aaa","bbb","ccc",null);
//        System.out.println(newsService.insert(news));
        /*News news = new News(4,"武汉加油","疫情即将结束","腾讯",null);
        boolean b = newsService.insert(news);*/
//        System.out.println(newsService.update(news));
        /*List<Integer> ids = new ArrayList<Integer>();
        ids.add(3);
        ids.add(4);
        System.out.println(newsService.delByIds(ids));*/
//        System.out.println(userService.getUser("kaikai"));
//        System.out.println(basketDao.getBasketAll());
//        System.out.println(basketController.getShopList(1,1,3,null));
//        System.out.println(basketController.getBasketAll());
//        System.out.println(basketDao.selectBack(1));
//        System.out.println(basketService.selectBack(1));
//        System.out.println(basketController.getBack(1));
//        System.out.println(basketController.getBasketAll());
//        System.out.println(basketService.selectAll());
//        System.out.println(basketService.getByUserId(2));
//        System.out.println(basketController.getListByUserId(2));
//        Basket basket = new Basket(1,1,1,null,4,"已支付","haixing",null);
//        System.out.println(basketService.update(basket));
//        Map<String,List<Integer>> map = new HashMap<>();
//        List<Integer> list = new ArrayList<>();
//        list.add(11);
//        list.add(15);
//        list.add(16);
//        map.put("ids",list);
//        System.out.println(basketController.getByBasketId(1));
//        System.out.println(basketController.getShopListByUserName("laoxia"));
//        System.out.println(basketController.getShopListByUserName("laoxia"));
        System.out.println(brandService.getBrands("A"));
    }

}
