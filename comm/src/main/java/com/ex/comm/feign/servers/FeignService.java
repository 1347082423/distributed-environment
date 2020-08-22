package com.ex.comm.feign.servers;

import com.ex.comm.feign.FeignFall;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @Describe
 * @Author wex
 * @Date 2020/8/22 10:47
 * @Version
 * 提供feign服务的接口
 **/
@FeignClient(value = "server1",fallback = FeignFall.class)
public interface FeignService {

    //服务中方法的映射路径
    @RequestMapping("/hello1")
    String hello();

    @RequestMapping(value = "/hellol2")
    String hello(@RequestParam("name") String name) ;

}
