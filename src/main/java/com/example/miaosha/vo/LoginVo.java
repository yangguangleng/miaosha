package com.example.miaosha.vo;

import com.example.miaosha.validator.isMobile;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

/**
 * @program: miaosha
 * @description
 * @author: 冷阳光
 **/
public class LoginVo {

    @NotNull
    @isMobile
    private String mobile;

    @NotNull
    @Length(min = 6)
    private String password;

    public String getMobile() {
        return mobile;
    }

    public LoginVo setMobile(String mobile) {
        this.mobile = mobile;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public LoginVo setPassword(String password) {
        this.password = password;
        return this;
    }

    @Override
    public String toString() {
        return "LoginVo{" +
                "mobile='" + mobile + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
