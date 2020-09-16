package com.example.miaosha.service;

import com.example.miaosha.daomai.Goods;
import com.example.miaosha.daomai.MiaoshaUser;
import com.example.miaosha.daomai.OrderInfo;
import com.example.miaosha.vo.GoodsVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @program: miaosha
 * @description
 * @author: 冷阳光
 **/
@Service
public class MiaoshaService {

    @Autowired
    GoodsService goodsService;

    @Autowired
    OrderService orderService;
    //事务
    //减库存 下订单 写入秒杀订单
    @Transactional
    public OrderInfo miaosha(MiaoshaUser user, GoodsVo goods) {

        goodsService.reduceStock(goods);

        OrderInfo orderInfo = orderService.createOrder(user,goods);

        return orderInfo;
    }
}
