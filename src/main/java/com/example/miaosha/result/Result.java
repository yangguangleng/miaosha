package com.example.miaosha.result;

/**
 * @program: miaosha_1
 * @description
 * @author: 冷阳光
 **/
public class Result <T>{
    private int code;
    private String msg;
    private T data;

    public Result(int code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }
    //不希望用户看到的构造函数使用私有的构造器
    private Result(T data) {
        this.code = 0;
        this.msg = "success";
        this.data = data;
    }
    private Result(CodeMsg cm){
        if (cm==null){
            return;
        }
        this.code = cm.getCode();
        this.msg = cm.getMsg();
    }


    //成功时候的调用
    public static <T> Result<T> success(T data){
        return new Result<T>(data);
    }
    //、、失败时候的调用
    public static <T> Result<T> error(CodeMsg cm){
        return new Result<T>(cm);
    }

    public int getCode() {
        return code;
    }



    public String getMsg() {
        return msg;
    }



    public T getData() {
        return data;
    }


}
