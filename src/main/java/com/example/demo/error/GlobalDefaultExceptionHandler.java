package com.example.demo.error;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * 异常处理类
 * Created by Administrator on 2018/3/23.
 */

@ControllerAdvice
public class GlobalDefaultExceptionHandler {


    @ExceptionHandler(Exception.class)
    public String exception(Model model, Exception e){
        // 判断发生异常的类型是除0异常则做出响应
        if(e instanceof ArithmeticException){
            model.addAttribute("message",e.getStackTrace());
            return "error";
        }
        model.addAttribute("message",e.getMessage());
        return "404";
    }
}
