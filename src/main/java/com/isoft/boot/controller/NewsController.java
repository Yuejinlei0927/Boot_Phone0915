package com.isoft.boot.controller;

import com.isoft.boot.bean.ResponseData;
import com.isoft.boot.entity.Brand;
import com.isoft.boot.entity.News;
import com.isoft.boot.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin
@RequestMapping("/news")
public class NewsController {
    @Autowired
    NewsService newsService;
    @GetMapping("getById/{id}")
    public ResponseData getById(@NotNull(message = "查询的ID为空") @PathVariable("id")Integer id){
        News news = newsService.getById(id);
        return new ResponseData(
                news==null?ResponseData.STATUS_FAIL:ResponseData.STATUS_OK,
                news==null?"查询失败":"查询成功",
                news
        );
    }
    @GetMapping("getAll")
    public ResponseData getAll(){
        List<News> list = newsService.getAll();
        return new ResponseData(
                list==null?ResponseData.STATUS_FAIL:ResponseData.STATUS_OK,
                list==null?"查询失败":"查询成功",
                list

        );
    }
    @PostMapping("getMore")
    public ResponseData getMore(@RequestBody Map<String,String> map){
        List<News> news = newsService.getNews(map.get("newstitle"));
        System.out.println(map.get("newstitle"));//null
        return new ResponseData(
                news == null ? ResponseData.STATUS_FAIL:ResponseData.STATUS_OK,
                news == null ? "查询失败":"查询成功",
                news
        );

    }
    @PostMapping("add")
    public ResponseData add(@Validated @RequestBody News news){
        boolean b = newsService.insert(news);
        return new ResponseData(
                b?ResponseData.STATUS_OK:ResponseData.STATUS_FAIL,
                b?"添加成功":"添加失败",
                b
        );

    }
    @DeleteMapping("delById/{id}")
    public ResponseData delById(@NotNull(message = "ID为空")@PathVariable("id")Integer id){
        boolean b = newsService.delById(id);
        return new ResponseData(
                b?ResponseData.STATUS_OK:ResponseData.STATUS_FAIL,
                b?"删除成功":"删除失败",
                b
        );
    }
    @DeleteMapping("delByIds")
    public ResponseData delByIds(@NotEmpty(message = "要删除的数据ids为空") @RequestBody Map<String,List<Integer>> map){
        boolean b = newsService.delByIds(map.get("ids"));
        return new ResponseData(
                b?ResponseData.STATUS_OK:ResponseData.STATUS_FAIL,
                b?"删除成功":"删除失败",
                b
        );
    }
    @PutMapping("update")
    public ResponseData update(@Validated @RequestBody News news){
        News ResultNews = newsService.update(news);
        return new ResponseData(
                ResultNews!= null ? ResponseData.STATUS_OK:ResponseData.STATUS_FAIL,
                ResultNews!= null ? "更新成功":"更新失败",
                ResultNews
        );

    }
}
