package com.itdaiheng.seckill.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author：daiheng
 * @data:2022/8/6-18:24
 * @Description:测试
 */
@Controller
@RequestMapping("/demo")
public class DemoController {

    @RequestMapping("/hello")
    public String hello(Model model){
        model.addAttribute("name","itdaiheng");
        return "hello";
    }

}
