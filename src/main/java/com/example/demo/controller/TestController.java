package com.example.demo.controller;

import com.example.demo.config.MyWebConfig;
import com.example.demo.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Administrator on 2018/3/18/018.
 */
@Controller
public class TestController {

    @Autowired
    private MyWebConfig myWebConfig;

    @RequestMapping("/test")
    public String test(Model model) {
        model.addAttribute("user", new User("李超"));
        return "login";
    }

    @RequestMapping("/login")
    public String login() {
//        int  s = 1/0;
//        throw new RuntimeException("异常");
        System.out.println(myWebConfig.getName());
        return "index";
    }

}

