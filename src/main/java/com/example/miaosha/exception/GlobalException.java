package com.example.miaosha.exception;

import com.example.miaosha.result.CodeMsg;

/**
 * @program: miaosha
 * @description
 * @author: 冷阳光
 **/
public class GlobalException extends RuntimeException{

    private static final long serialVersionUID = 1L;

    private CodeMsg cm;

    public GlobalException(CodeMsg cm){
        super(cm.toString());
        this.cm = cm;
    }

    public CodeMsg getCm() {
        return cm;
    }

    public GlobalException setCm(CodeMsg cm) {
        this.cm = cm;
        return this;
    }
}
