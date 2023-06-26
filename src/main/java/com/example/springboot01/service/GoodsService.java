package com.example.springboot01.service;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.springboot01.bean.Goods;
import com.example.springboot01.bean.ReturnResult;
import com.example.springboot01.dao.GoodsDao;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GoodsService {

   @Autowired
    private GoodsDao goodsDao;

    public List<Goods> selectAll(){
        return goodsDao.selectAll();
    }

    public ReturnResult findById(Integer id){
        ReturnResult rr = new ReturnResult();
        Goods user = goodsDao.findById(id);
        if (user==null){
            rr.setCode(-1);
            rr.setMsg("未查询到用户");
        }else {
            rr.setCode(0);
            rr.setMsg("success");
        }
        return rr;
    }

    public ReturnResult findByName(String name){
        List<Goods> users = goodsDao.findByName(name);
        ReturnResult rr = new ReturnResult();
        rr.setCode(0);
        rr.setMsg("success");
        return rr;
    }

    public int insertGoods( Goods goods){
        return goodsDao.insertGoods(goods);
    }

    //删除指定用户
    public int delById(Integer id){
        return goodsDao.delById(id);
    }

    public int updateGoods(Goods goods){
        return goodsDao.updateGoods(goods);
    }

    public List<Goods> selectPage(Integer pageNum, Integer pageSize){
        return goodsDao.selectPage(pageNum, pageSize);
    }
}
