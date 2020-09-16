package com.example.miaosha.controller;

import com.example.miaosha.daomai.MiaoshaOrder;
import com.example.miaosha.daomai.MiaoshaUser;
import com.example.miaosha.daomai.OrderInfo;
import com.example.miaosha.redis.RedisService;
import com.example.miaosha.result.CodeMsg;
import com.example.miaosha.service.GoodsService;
import com.example.miaosha.service.MiaoshaService;
import com.example.miaosha.service.OrderService;
import com.example.miaosha.vo.GoodsVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @program: miaosha
 * @description
 * @author: 冷阳光
 **/
@Controller
@RequestMapping("/miaosha")
public class MiaoshaController {

    @Autowired
    GoodsService goodsService;

    @Autowired
    RedisService redisService;

    @Autowired
    OrderService orderService;

    @Autowired
    MiaoshaService miaoshaService;

    @RequestMapping("/do_miaosha")
    public String Miaosha(Model model, MiaoshaUser user,
                          @RequestParam("goodsId")long goodsId){
        model.addAttribute("user",user);

        if(user==null){
            return "login";
        }
        //判断库存
        GoodsVo goods = goodsService.getGoodsVoByGoodsId(goodsId);
        int stock = goods.getGoodsStock();
        if (stock<=0){
            model.addAttribute("errmsg", CodeMsg.MIAO_SHA_OVER.getMsg());
            return "miaosha_fail";
        }
        //判断是否秒杀到了
        MiaoshaOrder order =orderService.getMiaoshaOrderByUserIdGoodsId(user.getId(),goodsId);
        if (order != null){
            model.addAttribute("errmsg",CodeMsg.REPEATE_MIAOSHA.getMsg());
            return "miaosha_fail";
        }
        //减库存 下订单 写入秒杀订单

        OrderInfo orderInfo = miaoshaService.miaosha(user,goods);
        model.addAttribute("orderInfo",orderInfo);
        model.addAttribute("goods",goods);
        return "order_detail";

    }
}
