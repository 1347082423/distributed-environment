package com.ex.server1.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Describe
 * @Author wex
 * @Date 2020/8/22 10:27
 * @Version
 * 提供feign服务
 **/
@RestController //@Controller注解与@ResponseBody注解的结合，表明这个controller不能返回view
public class FeignClientController {

    @RequestMapping("hello1")
    public String hello1(){
        return "欢迎调用server1";
    }

    @RequestMapping("hello2")
    public String hello2(@RequestParam String name){
        int i = 100/0;
        return "欢迎" + name + "调用server1";
    }
}
