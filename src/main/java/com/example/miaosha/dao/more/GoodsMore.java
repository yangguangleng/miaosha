package com.example.miaosha.dao.more;

import org.apache.ibatis.jdbc.SQL;
import org.thymeleaf.util.StringUtils;

import java.util.Map;

/**
 * @program: miaosha
 * @description
 * @author: 冷阳光
 **/
public class GoodsMore {

    /*"select g.*,mg.stock_count,mg.start_date,mg.end_date,mg.miaosha_price
    from miaosha_goods mg left join goods g on mg.goods_id = g.id limit #{start},5"*/
    public String listGoods(Integer start, final String searchName){
        String sql = new SQL(){
            {
               SELECT(" g.*,mg.stock_count,mg.start_date,mg.end_date,mg.miaosha_price ");
               FROM(" miaosha_goods mg left join goods g on mg.goods_id = g.id ");
               if (!StringUtils.isEmpty(searchName)){
                   WHERE(" g.goods_titile like '%condition%' ");
               }


            }
        }.toString();
        sql+=" limit #{start},5";
        System.out.println(sql);
        return sql;
    }

    public String countGoods(final String searchName){

        return new SQL(){
            {
                SELECT(" count(*) ");
                FROM(" goods ");
                if (!StringUtils.isEmpty(searchName)){
                    WHERE(" goods.goods_titile like '%condition%'");
                }
            }
        }.toString();


    }
}
