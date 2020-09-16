package com.example.miaosha.service;

import com.example.miaosha.dao.UserDao;
import com.example.miaosha.daomai.MiaoshaUser;
import com.example.miaosha.daomai.User;
import com.example.miaosha.exception.GlobalException;
import com.example.miaosha.result.CodeMsg;
import com.example.miaosha.util.Md5Util;
import com.example.miaosha.vo.LoginVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @program: miaosha_1
 * @description
 * @author: 冷阳光
 **/
@Service
public class UserService {
    @Autowired
    UserDao userDao;

    public User getById(int id){
        return userDao.getById(id);
    }
    //事务级方法
    //事务标签
    @Transactional
    public boolean tx() {
        User u1 = new User();
        u1.setId(2);
        u1.setName("2222");
        userDao.insert(u1);

        /*User u2 = new User();
        u2.setId(1);
        u2.setName("1111");
        userDao.insert(u2);*/
        return true;
    }



}
