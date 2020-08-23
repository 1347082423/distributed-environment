package com.ex.userserver;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * @Describe
 * @Author wex
 * @Date 2020/8/22 21:32
 * @Version
 **/
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //以下五步是表单登录进行身份认证最简单的登陆环境
        http.formLogin() //表单登陆 1
                .loginPage("/hello") //指定登陆页面
                .and() //2
                .authorizeRequests() //下面的都是授权的配置 3
                .antMatchers("/hello").permitAll()//访问此地址就不需要进行身份认证了，防止重定向死循环
                .anyRequest() //任何请求 4
                .authenticated(); //访问任何资源都需要身份认证 5
        //默认都会产生一个hiden标签 里面有安全相关的验证 防止请求伪造 这边我们暂时不需要 可禁用掉
        http .csrf().disable();
    }
}
