package com.example.springboot01.bean;

import lombok.Data;

@Data
public class ReturnResult {
    private Integer code; //0正常，负值错误
    private String msg; //返回文字信息
    private Object other; //其他信息
}
