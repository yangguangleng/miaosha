package com.example.miaosha.dao;

import com.example.miaosha.dao.more.GoodsMore;
import com.example.miaosha.daomai.Goods;
import com.example.miaosha.daomai.MiaoshaGoods;
import com.example.miaosha.vo.GoodsVo;
import org.apache.ibatis.annotations.*;


import java.util.List;
import java.util.Map;

/**
 * @program: miaosha
 * @description
 * @author: 冷阳光
 **/
@Mapper
public interface GoodsDao {


    @Select({"<script>"+
            "select g.*,mg.stock_count,mg.start_date,mg.end_date,mg.miaosha_price from miaosha_goods mg left join goods g on mg.goods_id = g.id " +
            "<if test='searchName != null and searchName != &quot;&quot;'>where g.goods_title like concat('%',#{searchName},'%')</if>"+
            " limit #{start},5"+
            "</script>"})
    public List<GoodsVo> listGoodsVo(@Param("start") Integer start, @Param("searchName") String searchName);


    @Select({"<script>"+
                    "select count(*) from goods"+
                    "<if test='searchName != null and searchName != &quot;&quot;'>" +
                    "where goods_title like concat('%',#{searchName},'%')" +
                    "</if>"+
            "</script>"})
    public Integer countGoods(@Param("searchName") String searchName);

    @Select("select g.*,mg.stock_count,mg.start_date,mg.end_date,mg.miaosha_price from miaosha_goods mg left join goods g on mg.goods_id = g.id where g.id = #{goodsId}")
    public GoodsVo getGoodsVoByGoodsId(@Param("goodsId") long goodId);

    @Update("update miaosha_goods set stock_count = stock_count - 1 where goods_id =#{goodsId} where stock_count>0")
    public void reduceStock(MiaoshaGoods g);
}
