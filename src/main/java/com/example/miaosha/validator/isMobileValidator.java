package com.example.miaosha.validator;

import com.example.miaosha.util.ValidatorUtil;
import org.thymeleaf.util.StringUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * @program: miaosha
 * @description
 * @author: 冷阳光
 **/
public class isMobileValidator implements ConstraintValidator<isMobile, String> {
    private boolean required = false;
    @Override
    public void initialize(isMobile constraintAnnotation) {
        required = constraintAnnotation.required();
    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        if(required){
            return ValidatorUtil.isMobile(s);
        }else {
            if(StringUtils.isEmpty(s)){
                return true;
            }else {
                return ValidatorUtil.isMobile(s);
            }
        }
    }
}
