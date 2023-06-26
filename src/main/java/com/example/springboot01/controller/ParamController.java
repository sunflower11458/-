package com.example.springboot01.controller;

import com.example.springboot01.bean.Goods;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ParamController {
    @RequestMapping("/getJsonInfo")
    public Goods getJsonInfo(@RequestBody Goods goods){
        return goods;
    }
}
