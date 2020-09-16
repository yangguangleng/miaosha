package com.example.miaosha.redis;

/**
 * @program: miaosha
 * @description
 * @author: 冷阳光
 **/
public class MiaoshaUserKey extends BasePrefix{

    public static final int TOKEN_EXPIRE = 3600*24 * 2;
    public MiaoshaUserKey(int expireSecond,String prefix) {
        super(expireSecond,prefix);
    }

    public static MiaoshaUserKey token = new MiaoshaUserKey(TOKEN_EXPIRE,"tk");
    public static MiaoshaUserKey getById = new MiaoshaUserKey(0,"id");

}
