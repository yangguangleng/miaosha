package com.example.miaosha.daomai;

/**
 * @program: miaosha_1
 * @description
 * @author: 冷阳光
 **/
public class User {
    private int id;
    private String name;
    private Float money;


    public int getId() {
        return id;
    }

    public User setId(int id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public User setName(String name) {
        this.name = name;
        return this;
    }
}
