package com.ex.configsever;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;


@EnableConfigServer//将其标记为一个configServer服务
@SpringBootApplication
@EnableEurekaClient//标记为一个EurekaClient服务注入Eureka中
//@EnableDiscoveryClient//标记为一个能被注入进服务器中的类
public class ConfigSeverApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConfigSeverApplication.class, args);
    }

}
