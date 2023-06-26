package com.example.springboot01.controller;

import com.example.springboot01.bean.Goods;
import com.example.springboot01.bean.ReturnResult;
import com.example.springboot01.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class GoodsController {

    @Autowired
    private GoodsService goodsService;

    @GetMapping("/getAllUser")
    public List<Goods> getAllUser(){
        return goodsService.selectAll();
    }

    @GetMapping("/findById")
    public ReturnResult findById(Integer id){
        return goodsService.findById(id);
    }

    @GetMapping("/findByName")
    public ReturnResult findByName(String name){
        return goodsService.findByName(name);
    }

    @PostMapping("/insertGoods")
    public ReturnResult insertGoods(Goods goods){
        ReturnResult rr = new ReturnResult();
        try{
            int num = goodsService.insertGoods(goods);
            rr.setCode(0);
            rr.setMsg("插入成功");
            rr.setOther(num);

        }catch (Exception e){
            rr.setCode(-1);
            rr.setMsg("插入失败");
            rr.setOther("未知原因");
        }
        return rr;
    }

    //删除指定用户
    @GetMapping("/delById")
    public ReturnResult delById(Integer id){
        ReturnResult rr = new ReturnResult();
        try{
            int num = goodsService.delById(id);
            rr.setCode(0);
            rr.setMsg("删除成功");
            rr.setOther(num);

        }catch (Exception e){
            e.printStackTrace();
            rr.setCode(-1);
            rr.setMsg("删除失败");
            rr.setOther("未知原因");
        }
        return rr;
    }

    @PostMapping("/updateGoods")
    public ReturnResult updateGoods(Goods goods){
        ReturnResult rr = new ReturnResult();
        try{
            int num = goodsService.updateGoods(goods);
            rr.setCode(0);
            rr.setMsg("更新成功");
            rr.setOther(num);

        }catch (Exception e){
            e.printStackTrace();
            rr.setCode(-1);
            rr.setMsg("更新失败");
            rr.setOther("未知原因");
        }
        return rr;
    }

    @GetMapping("/page")
    public List<Goods> findPage(@RequestParam Integer pageNum, @RequestParam Integer pageSize){
        pageNum = (pageNum-1);
        return goodsService.selectPage(pageNum,pageSize);
    }

}
