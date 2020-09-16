package com.example.miaosha.dao;

import com.example.miaosha.daomai.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

/**
 * @program: miaosha_1
 * @description
 * @author: 冷阳光
 **/
@Mapper
@Component
public interface UserDao {

    @Select("select * from user where id = #{id}")
    public User getById(@Param("id") int id);

    @Insert("Insert into user(id,name) values(#{id},#{name})")
    public int insert(User user);
}
