package com.example.springboot01.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class TestJdbc {
    private static String url="jdbc:mysql://localhost:3306/springboot?useUnicode=true&characterEncoding=utf8&autoReconnect=true";//数据库访问的链接
    private static String usrName="root";//数据库访问的用户名
    private static String pwd="123456";//数据库访问密码

    public static void main(String[] args) throws Exception {
        /**
         * 1、加载驱动
         * 2、连接数据库（连接字符串，用户名，密码）
         * 3、操作数据（CRUD 增删改查）
         * 4、关闭数据库
         *
         */
        //1、加载驱动
        Class.forName("com.mysql.cj.jdbc.Driver");//参数驱动类的全包名
        System.out.println("驱动加载成功");
        //2、连接数据库
        Connection conn = DriverManager.getConnection(url, usrName, pwd);
        System.out.println("数据库连接成功");

        //3、操作数据
        //创建Statement
        PreparedStatement ps = conn.prepareStatement("select * from user");
        //执行查询,返回一个结果集
        ResultSet rs = ps.executeQuery();

        while(rs.next()){
            System.out.println(rs.getInt("id"));
            System.out.println(rs.getString("name"));
            System.out.println(rs.getString("pwd"));
        }
        System.out.println("查询数据完成");

        ps = conn.prepareStatement("delete from user where id=8");
        //执行数据的变更
        ps.executeUpdate();
        System.out.println("数据变更成功");

        //4、关闭数据库
        conn.close();



    }
}
