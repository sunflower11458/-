package com.example.springboot01.bean;


import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("goods")
public class Goods {
    private Integer id;
    private String name;
    private Float price;
    private String status;
}
