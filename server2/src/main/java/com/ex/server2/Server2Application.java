package com.ex.server2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication()
@EnableEurekaClient//标注此服务是一个eureka服务需要eureka进行管理
//@EnableHystrix
@EnableFeignClients //声明使用Feign实现通信
//添加熔断降级注解
@EnableCircuitBreaker
public class Server2Application {

    public static void main(String[] args) {
        SpringApplication.run(Server2Application.class, args);
    }

}
