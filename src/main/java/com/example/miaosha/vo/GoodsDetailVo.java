package com.example.miaosha.vo;

import com.example.miaosha.daomai.MiaoshaUser;

/**
 * @program: miaosha
 * @description
 * @author: 冷阳光
 **/
public class GoodsDetailVo {

    private int miaoshaStatus=0;
    private int remainSeconds=0;
    private GoodsVo goods;
    private MiaoshaUser user;
    public MiaoshaUser getUser() {
        return user;
    }

    public GoodsDetailVo setUser(MiaoshaUser user) {
        this.user = user;
        return this;
    }



    public int getMiaoshaStatus() {
        return miaoshaStatus;
    }

    public GoodsDetailVo setMiaoshaStatus(int miaoshaStatus) {
        this.miaoshaStatus = miaoshaStatus;
        return this;
    }

    public int getRemainSeconds() {
        return remainSeconds;
    }

    public GoodsDetailVo setRemainSeconds(int remainSeconds) {
        this.remainSeconds = remainSeconds;
        return this;
    }

    public GoodsVo getGoods() {
        return goods;
    }

    public GoodsDetailVo setGoods(GoodsVo goods) {
        this.goods = goods;
        return this;
    }
}
