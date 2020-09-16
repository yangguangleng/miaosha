package com.example.miaosha;

import com.example.miaosha.dao.GoodsDao;
import com.example.miaosha.dao.MiaoshaUserDao;
import com.example.miaosha.daomai.MiaoshaUser;
import com.example.miaosha.daomai.PageBean;
import com.example.miaosha.service.GoodsService;
import com.example.miaosha.service.MiaoshaUserService;
import com.example.miaosha.util.Md5Util;
import com.example.miaosha.vo.GoodsVo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @program: miaosha
 * @description
 * @author: 冷阳光
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
public class Test1 {

    @Autowired
    GoodsService goodsService;

    @Autowired
    GoodsDao goodsDao;

    @Autowired
    MiaoshaUserService miaoshaUserService;

    @Test
    public void TestSearch(){
        /*PageBean<GoodsVo> pageBean = goodsService.listGoodsVo("",1);
        System.out.println(pageBean);*/

        Integer count = goodsDao.countGoods("ip");
        System.out.println(count);
    }

    @Test
    public void TestInsert(){
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = new Date();
        /*MiaoshaUser miaoshaUser = new MiaoshaUser();
        miaoshaUser.setId(15090224396L);
        String password = Md5Util.inputPassToDbPass("123456","1a2b3c4d");
        miaoshaUser.setPassword(password);
        miaoshaUser.setSalt("1a2b3c4d");
        miaoshaUser.setNickname("张旭升");
        System.out.println(miaoshaUser);

        miaoshaUserService.register(miaoshaUser);*/
        System.out.println(dateFormat.format(date));
    }
}
