package com.isoft.boot.controller;

import com.isoft.boot.bean.ResponseData;
import com.isoft.boot.entity.Brand;
import com.isoft.boot.entity.Phone;
import com.isoft.boot.service.BrandService;
import com.isoft.boot.util.IntegerUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin
@RequestMapping("/brand")
public class BrandController {
    @Autowired
    BrandService brandService;
    @GetMapping("getById/{id}")
    public ResponseData getById(@NotNull(message = "查询的id为空") @PathVariable("id")Integer id){
        Brand brand = brandService.getById(id);
        return new ResponseData(
                 brand == null ? ResponseData.STATUS_FAIL:ResponseData.STATUS_OK,
                 brand == null ? "查询失败":"查询成功",
                 brand
        );
    }
    @GetMapping("getAll")
    public ResponseData getAll(){
        List<Brand> list = brandService.getAll();
        return new ResponseData(
                list == null ? ResponseData.STATUS_FAIL:ResponseData.STATUS_OK,
                list == null ? "查询失败":"查询成功",
                list
        );
    }
    @PostMapping("getMore")
    public ResponseData getMore(@RequestBody Map<String,String> map){
        List<Brand> phones = brandService.getBrands(map.get("brandName"));
        System.out.println(map.get("brandName"));//null
        return new ResponseData(
                phones == null ? ResponseData.STATUS_FAIL:ResponseData.STATUS_OK,
                phones == null ? "查询失败":"查询成功",
                phones
        );

    }
    @PostMapping("add")
    public ResponseData add(@Validated @RequestBody Brand brand){
        boolean r = brandService.insert(brand);
        return new ResponseData(
                r ? ResponseData.STATUS_OK:ResponseData.STATUS_FAIL,
                r ? "添加成功":"添加失败",
                r
        );
    }
    @DeleteMapping("delById/{id}")
    public ResponseData delById(@NotNull(message = "id为空")@PathVariable("id")Integer id){
        boolean r = brandService.delById(id);
        return new ResponseData(
                r ?ResponseData.STATUS_OK:ResponseData.STATUS_FAIL,
                r ? "删除成功":"删除失败",
                r
        );
    }
    @DeleteMapping("delByIds")
    public ResponseData delByIds(@NotEmpty(message = "要删除的数据集合ids为空") @RequestBody Map<String,
            List<Integer>> map){
        boolean r = brandService.delByIds(map.get("ids"));
        return new ResponseData(
                r ?ResponseData.STATUS_OK:ResponseData.STATUS_FAIL,
                r ? "删除成功":"删除失败",
                r
        );
    }
    @PutMapping("update")
    public ResponseData update(@Validated@RequestBody Brand brand){
        Brand ResultBrand = brandService.update(brand);
        return new ResponseData(
                ResultBrand == null ? ResponseData.STATUS_FAIL:ResponseData.STATUS_OK,
                ResultBrand == null ? "更新失败":"更新成功",
                ResultBrand
        );
    }
}
