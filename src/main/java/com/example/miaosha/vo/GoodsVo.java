package com.example.miaosha.vo;

import com.example.miaosha.daomai.Goods;

import java.util.Date;

/**
 * @program: miaosha
 * @description
 * @author: 冷阳光
 **/
public class GoodsVo extends Goods {
    private Double miaoshaPrice;

    public Double getMiaoshaPrice() {
        return miaoshaPrice;
    }

    public GoodsVo setMiaoshaPrice(Double miaoshaPrice) {
        this.miaoshaPrice = miaoshaPrice;
        return this;
    }

    private Integer stockCount;
    private Date startDate;
    private Date endDate;

    public Integer getStockCount() {
        return stockCount;
    }

    public GoodsVo setStockCount(Integer stockCount) {
        this.stockCount = stockCount;
        return this;
    }

    public Date getStartDate() {
        return startDate;
    }

    public GoodsVo setStartDate(Date startDate) {
        this.startDate = startDate;
        return this;
    }

    public Date getEndDate() {
        return endDate;
    }

    public GoodsVo setEndDate(Date endDate) {
        this.endDate = endDate;
        return this;
    }

    @Override
    public String toString() {
        return "GoodsVo{" +
                "miaoshaPrice=" + miaoshaPrice +
                ", stockCount=" + stockCount +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                '}';
    }
}
