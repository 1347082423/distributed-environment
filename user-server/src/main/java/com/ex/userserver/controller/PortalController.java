package com.ex.userserver.controller;

import com.ex.comm.pojo.ExSysUser;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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
        return "index";
    }

    @ResponseBody
    @RequestMapping("/url1")
    public String url1() {
        return "Admin";
    }

    @ResponseBody
    @RequestMapping("/url2")
    public String url2() {
        return "User";
    }

    @ResponseBody
    @RequestMapping("/url3")
    public String url3() {
        return "Admin";
    }

    @RequestMapping("/failure")
    @ResponseBody
    public String loginFailure() {

        return "登录失败了，老哥" + HttpStatus.UNAUTHORIZED.value();
    }

    /**
     * 登录成功后拿到个人信息.
     *
     * @return the rest
     */
    @RequestMapping("/success")
//    @ResponseBody
    public String loginSuccess() {
        // 登录成功后用户的认证信息 UserDetails会存在 安全上下文寄存器 SecurityContextHolder 中
        ExSysUser principal = (ExSysUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username = principal.getName();
//        return "登录成功" + username;
        return "aaaa";
    }
}
