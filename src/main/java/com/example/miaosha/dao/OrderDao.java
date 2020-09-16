package com.example.miaosha.dao;

import com.example.miaosha.daomai.MiaoshaOrder;
import com.example.miaosha.daomai.OrderInfo;
import org.apache.ibatis.annotations.*;

/**
 * @program: miaosha
 * @description
 * @author: 冷阳光
 **/
@Mapper
public interface OrderDao {

    @Select("select * from miaosha_order where user_id = #{userId} and goods_id =#{goodsId}")
    public MiaoshaOrder getMiaoshaOrderByUserIdGoodsId(@Param("userId") Long UserId, @Param("goodsId") long goodsId);

    @Insert("insert into order_info(user_id, goods_id, goods_name, goods_count, goods_price, order_channel, status, create_date)values(" +
            "#{userId}, #{goodsId}, #{goodsName}, #{goodsCount}, #{goodsPrice}, #{orderChannel},#{status},#{createDate} )")
    @SelectKey(keyColumn="id", keyProperty="id", resultType=long.class, before=false, statement="select last_insert_id()")
    public long insert(OrderInfo orderInfo);

    @Insert("insert into miaosha_order (user_id, goods_id, order_id)values(#{userId}, #{goodsId}, #{orderId})")
    public void insertMiaoshaOrder(MiaoshaOrder miaoshaOrder);
}
