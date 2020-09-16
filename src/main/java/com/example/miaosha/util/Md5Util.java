package com.example.miaosha.util;

import org.apache.commons.codec.digest.DigestUtils;

/**
 * @program: miaosha
 * @description  MD5工具
 * @author: 冷阳光
 **/
public class Md5Util {
    public static String md5(String str){
        return DigestUtils.md5Hex(str);
    }

    private static final String salt = "1a2b3c4d";

    public static String inputPassFormPass(String inputPass){
       String str =""+salt.charAt(0) +salt.charAt(2) +inputPass +salt.charAt(5) +salt.charAt(4);
       return md5(str);
    }
    public static String formPassToDbPass(String inputPass,String salt){
        String str = "" +salt.charAt(0) +salt.charAt(2) +inputPass +salt.charAt(5) +salt.charAt(4);
        return md5(str);
    }

    public static String inputPassToDbPass(String input,String saltDB){
        String formPass = inputPassFormPass(input);
        String dbPass = formPassToDbPass(formPass,saltDB);
        return dbPass;
    }

    public static void main(String[] args) {
        /*System.out.println(inputPassFormPass("123456"));
        System.out.println(formPassToDbPass(inputPassFormPass("123456"),"1a2v3c5d"));*/
        System.out.println(inputPassToDbPass("123456","1a2b3c4d"));
    }
}
