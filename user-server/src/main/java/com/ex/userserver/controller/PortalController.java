package com.ex.userserver.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Describe
 * @Author wex
 * @Date 2020/8/22 18:39
 * @Version
 **/
@Controller
public class PortalController {


    @GetMapping("/hello")
    public String index() {
        return "login";
    }


}
