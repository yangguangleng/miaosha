package com.example.miaosha.util;

import org.thymeleaf.util.StringUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @program: miaosha
 * @description 判断手机号是否合法
 * @author: 冷阳光
 **/
public class ValidatorUtil {

    //设定手机号格式
    private static final Pattern mobile_pattern = Pattern.compile("1\\d{10}");
    public static boolean isMobile(String src){
        if(StringUtils.isEmpty(src)){
            return false;
        }
        Matcher m = mobile_pattern.matcher(src);
        return m.matches();
    }

    public static void main(String[] args) {
        System.out.println(isMobile("18239357895"));//正确的手机号格式
        System.out.println(isMobile("1232222222"));//错误的手机号格式
    }
}


