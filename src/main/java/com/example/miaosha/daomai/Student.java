package com.example.miaosha.daomai;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @program: miaosha
 * @description
 * @author: 冷阳光
 **/
//序列化接口
@Data
public class Student implements Serializable {
    private Integer id;
    private String name;
    private Double score;
    private Date birthday;

    public Integer getId() {
        return id;
    }

    public Student setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Student setName(String name) {
        this.name = name;
        return this;
    }

    public Double getScore() {
        return score;
    }

    public Student setScore(Double score) {
        this.score = score;
        return this;
    }

    public Date getBirthday() {
        return birthday;
    }

    public Student setBirthday(Date birthday) {
        this.birthday = birthday;
        return this;
    }
}
