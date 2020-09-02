package com.ex.userserver.config;

import com.ex.userserver.config.access.impl.SecurityAuthorityAccessImpl;
import com.ex.userserver.config.handler.SecurityAuthorityFailureHandler;
import com.ex.userserver.config.handler.SecurityAuthoritySuccessHandler;
import com.ex.userserver.server.impl.UserServerImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * @Describe
 * @Author wex
 * @Date 2020/8/22 21:32
 * @Version
 **/
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserServerImpl userServer;

//    @Autowired
//    private SecurityAuthorityAccessImpl securityAuthorityAccessImpl;

    @Autowired
    private SecurityAuthorityFailureHandler securityAuthorityFailureHandler;

    @Autowired
    private SecurityAuthoritySuccessHandler securityAuthoritySuccessHandler;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userServer).passwordEncoder(passwordEncoder());
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().mvcMatchers("/static/**");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //以下五步是表单登录进行身份认证最简单的登陆环境
        http .csrf().disable();
        http.formLogin() //表单登陆 1
                .loginPage("/hello") //指定登陆页面
//                .successHandler(securityAuthoritySuccessHandler)
                .defaultSuccessUrl("/success")
                .failureUrl("/failure")
//                .failureHandler(securityAuthorityFailureHandler)
                .and() //2
                .authorizeRequests() //开启登录校验
                .antMatchers("/hello","/failure","/success").permitAll()//hello路径不需要校验
                .anyRequest().access("@securityAuthorityAccessImpl.hasPermit(request,authentication)");//@securityAuthorityAccess.hasPermit(request,authentication)
//                .anyRequest().authenticated(); //其他所有请求登录后访问

    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
