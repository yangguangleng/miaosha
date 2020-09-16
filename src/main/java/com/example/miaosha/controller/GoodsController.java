package com.example.miaosha.controller;

import com.example.miaosha.daomai.MiaoshaUser;
import com.example.miaosha.daomai.PageBean;
import com.example.miaosha.redis.GoodsKey;
import com.example.miaosha.redis.RedisService;
import com.example.miaosha.result.Result;
import com.example.miaosha.service.GoodsService;
import com.example.miaosha.service.MiaoshaUserService;
import com.example.miaosha.vo.GoodsDetailVo;
import com.example.miaosha.vo.GoodsVo;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.thymeleaf.spring4.context.SpringWebContext;
import org.thymeleaf.spring4.view.ThymeleafViewResolver;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.text.html.HTML;
import javax.validation.Valid;
import javax.websocket.server.PathParam;
import java.util.List;
import java.util.Map;


@Controller
@RequestMapping("/goods")
public class GoodsController {

	@Autowired
    MiaoshaUserService userService;

    @Autowired
    ThymeleafViewResolver thymeleafViewResolver;

	@Autowired
    RedisService redisService;

	@Autowired
    GoodsService goodsService;

	@Autowired
    ApplicationContext applicationContext;

    @RequestMapping(value = "/to_list",produces = "text/html")
    @ResponseBody
    public String list(
            @RequestParam(value = "currentPage",required = false,defaultValue = "1") Integer currentPage,
             @RequestParam(value = "searchName",required = false,defaultValue = "")String searchName,HttpServletRequest request, HttpServletResponse response,
            Model model, MiaoshaUser user){
        model.addAttribute("user", user);
        //页面缓存
        //取缓存
        String html = redisService.get(GoodsKey.getGoodsList,"",String.class);
        if (!StringUtils.isEmpty(html)){
            return html;
        }

        //查询商品列表
        /*List<GoodsVo> goodsList = goodsService.listGoodsVo(currentPage,pageSize);
        model.addAttribute("goodsList",goodsList);*/
        /*int currentPageNum ;
        if (!StringUtils.isEmpty(currentPage)){
            currentPageNum = Integer.parseInt(currentPage);
        }else {
            currentPageNum=1;
        }*/
        model.addAttribute("searchName",searchName);

        PageBean<GoodsVo> pb = goodsService.listGoodsVo(searchName,currentPage);
        model.addAttribute("pb",pb);
        /*return "goods_list";*/

        //手动渲染
        SpringWebContext ctx = new SpringWebContext(request,response,
                request.getServletContext(),
                request.getLocale(),
                model.asMap(),
                applicationContext);
        html = thymeleafViewResolver.getTemplateEngine().process("goods_list",ctx);
        if (StringUtils.isEmpty(html)){
            redisService.set(GoodsKey.getGoodsList,"",html);
        }

        return html;
    }
    @RequestMapping(value = "/to_detail1/{goodsId}",produces = "text/html")
    @ResponseBody
    public String toDetail1(HttpServletResponse response,HttpServletRequest request,Model model,MiaoshaUser user,
    @PathVariable("goodsId")long goodsId){
        //页面缓存。url缓存
        //取缓存
        String html = redisService.get(GoodsKey.getGoodsDetail,""+goodsId,String.class);
        if (!StringUtils.isEmpty(html)){
            return html;
        }

        model.addAttribute("user", user);
        GoodsVo goods = goodsService.getGoodsVoByGoodsId(goodsId);
        model.addAttribute("goods",goods);
        //将开始的时间转化为ms
        long startAt =goods.getStartDate().getTime();
        long endAt = goods.getEndDate().getTime();
        long now = System.currentTimeMillis();

        int miaoshaStatus = 0;//秒杀的状态
        int remainSeconds = 0;//秒杀还有多少s开始

        if(now<startAt){//秒杀还没开始，倒计时
            miaoshaStatus = 0;
            remainSeconds = (int)((startAt-now)/1000);
        }else if(now>endAt){//秒杀已经结束
            miaoshaStatus = 2;
            remainSeconds = -1;
        }else {//秒杀正在进行
            miaoshaStatus = 1;
            remainSeconds = 0;
        }
        model.addAttribute("miaoshaStatus",miaoshaStatus);
        model.addAttribute("remainSeconds",remainSeconds);
        /*return "goods_detail";*/


        SpringWebContext ctx = new SpringWebContext(request,response,
                request.getServletContext(),
                request.getLocale(),
                model.asMap(),
                applicationContext);
        html = thymeleafViewResolver.getTemplateEngine().process("goods_Detail",ctx);
        if (StringUtils.isEmpty(html)){
            redisService.set(GoodsKey.getGoodsDetail,"",html);
        }

        return html;
    }
    //另一个详情界面
    @RequestMapping(value = "/detail/{goodsId}")
    @ResponseBody
    public Result<GoodsDetailVo> detail(HttpServletResponse response, HttpServletRequest request, Model model, MiaoshaUser user,
                                           @PathVariable("goodsId")long goodsId){
        GoodsVo goods = goodsService.getGoodsVoByGoodsId(goodsId);
        //将开始的时间转化为ms
        long startAt =goods.getStartDate().getTime();
        long endAt = goods.getEndDate().getTime();
        long now = System.currentTimeMillis();

        int miaoshaStatus = 0;//秒杀的状态
        int remainSeconds = 0;//秒杀还有多少s开始

        if(now<startAt){//秒杀还没开始，倒计时
            miaoshaStatus = 0;
            remainSeconds = (int)((startAt-now)/1000);
        }else if(now>endAt){//秒杀已经结束
            miaoshaStatus = 2;
            remainSeconds = -1;
        }else {//秒杀正在进行
            miaoshaStatus = 1;
            remainSeconds = 0;
        }

        /*return "goods_detail";*/
        //页面静态化
        GoodsDetailVo goodsDetailVo = new GoodsDetailVo();
        goodsDetailVo.setGoods(goods);
        goodsDetailVo.setUser(user);
        goodsDetailVo.setMiaoshaStatus(miaoshaStatus);
        goodsDetailVo.setRemainSeconds(remainSeconds);

        return Result.success(goodsDetailVo);
    }
    
}
