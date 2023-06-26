package com.example.springboot01.dao;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.example.springboot01.bean.Goods;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface GoodsDao {

    @Select("select * from goods")
    @ResultType(Goods.class)
    List<Goods> selectAll();

    @Select("select id from goods")
    Goods findById(@Param("id") Integer id);

    @Select("select name from goods")
    List<Goods> findByName(@Param("name") String name);

    @Insert("insert into goods(name,price,status)" +
    "values(#{goods.name},#{goods.price},#{goods.status})")
    int insertGoods(@Param("goods") Goods goods);

    @Delete("delete from goods where id=#{id}")
    int delById(@Param("id") Integer id);

    @Update("<script>\n"+
            " update goods\n" +
            "            <set>\n" +
            "                <if test=\"goods.name!=null\">\n" +
            "                    name = #{goods.name},\n" +
            "                </if>\n" +
            "                <if test=\"goods.price!=null\">\n" +
            "                    price = #{goods.price},\n" +
            "                </if>\n" +
            "                <if test=\"goods.status!=null\">\n" +
            "                    status = #{user.status},\n" +
            "                </if>\n" +
            "            </set>\n" +
            "         where id = #{goods.id}"+
            "\n</script>"
    )
    int updateGoods(@Param("goods") Goods goods);

    @Select("select * from goods limit #{pageNum},#{pageSize}")
    List<Goods> selectPage(Integer currPageNo, Integer pageSize);
}
