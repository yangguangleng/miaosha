package com.example.miaosha.service;

import com.example.miaosha.dao.OrderDao;
import com.example.miaosha.daomai.MiaoshaGoods;
import com.example.miaosha.daomai.MiaoshaOrder;
import com.example.miaosha.daomai.MiaoshaUser;
import com.example.miaosha.daomai.OrderInfo;
import com.example.miaosha.vo.GoodsVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

/**
 * @program: miaosha
 * @description
 * @author: 冷阳光
 **/
@Service
public class OrderService {

    @Autowired
    OrderDao orderDao;

    //判断用户是否秒杀到商品
    public MiaoshaOrder getMiaoshaOrderByUserIdGoodsId(Long UserId, long goodsId) {

        return orderDao.getMiaoshaOrderByUserIdGoodsId(UserId,goodsId);
    }


    @Transactional
    public OrderInfo createOrder(MiaoshaUser user, GoodsVo goods) {
    OrderInfo orderInfo = new OrderInfo();
    orderInfo.setCreateDate(new Date());
    orderInfo.setDeliveryAddrId(0L);
    orderInfo.setGoodsCount(1);
    orderInfo.setGoodsId(goods.getId());
    orderInfo.setGoodsName(goods.getGoodsName());
    orderInfo.setGoodsPrice(goods.getMiaoshaPrice());
    orderInfo.setOrderChannel(1);
    orderInfo.setStatus(0);
    orderInfo.setUserId(user.getId());

    long orderId = orderDao.insert(orderInfo);
    MiaoshaOrder miaoshaOrder = new MiaoshaOrder();
    miaoshaOrder.setGoodsId(goods.getId());
    miaoshaOrder.setOrderId(orderId);
    miaoshaOrder.setUserId(user.getId());
    orderDao.insertMiaoshaOrder(miaoshaOrder);

    return orderInfo;
    }
}
