package com.example.miaosha.service;

import com.example.miaosha.dao.GoodsDao;
import com.example.miaosha.daomai.Goods;
import com.example.miaosha.daomai.MiaoshaGoods;
import com.example.miaosha.daomai.PageBean;
import com.example.miaosha.vo.GoodsVo;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @program: miaosha
 * @description
 * @author: 冷阳光
 **/
@Service("goodsService")
public class GoodsService {
    @Autowired
    GoodsDao goodsDao;

    public PageBean<GoodsVo> listGoodsVo(String searchName, Integer currentPage){
        /*String newSearchName = "'%"+searchName+"%'";*/
        PageBean<GoodsVo> pageBean = new PageBean<GoodsVo>();
        Integer start = (currentPage-1)*5;
        Integer count = goodsDao.countGoods(searchName);
        List<GoodsVo> list = goodsDao.listGoodsVo(start,searchName);
        pageBean.setTotalCount(count);
        pageBean.setCurrentPage(currentPage);
        pageBean.setPageSize(5);
        pageBean.setList(list);
        int totalPage = count%5 ==0?count/5:count/5+1;
        pageBean.setTotalPage(totalPage);

        return pageBean;
    }


    public GoodsVo getGoodsVoByGoodsId(long goodsId) {

        return goodsDao.getGoodsVoByGoodsId(goodsId);
    }

    public void reduceStock(GoodsVo goods) {
        MiaoshaGoods g = new MiaoshaGoods();
        g.setGoodsId(goods.getId());
        goodsDao.reduceStock(g);
    }
}
