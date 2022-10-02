package com.example.product_managerment.handler;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class ProductExceptionHandler {
    @ExceptionHandler(Exception.class)
    public ModelAndView exception( Exception ex){
        System.out.println(ex.getMessage());
        ModelAndView modelAndView = new ModelAndView("error");
        return modelAndView;
    }
}
