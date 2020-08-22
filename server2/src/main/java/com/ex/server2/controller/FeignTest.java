package com.ex.server2.controller;

import com.ex.server2.service.FeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Describe
 * @Author wex
 * @Date 2020/8/22 10:51
 * @Version
 **/
@RestController
public class FeignTest {

    @Autowired
    private FeignService feignService;

    @RequestMapping("feignHello")
    public String hello(){
        return feignService.hello();
//        return "bbbbbbbbbbb";
    }

    @RequestMapping("feignHello2")
    public String hello2(String name){
        return feignService.hello(name);
//        return "aaaaaaaaaaaaaaaaaa";
    }
}
