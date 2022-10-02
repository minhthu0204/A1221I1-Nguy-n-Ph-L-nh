package com.example.product_managerment.common;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class NumberValidImpl implements ConstraintValidator<NumberValid,Double> {


    @Override
    public boolean isValid(Double value, ConstraintValidatorContext context) {

        if(value == null)
            return false;

        return  value >0;
    }
}