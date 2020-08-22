package com.ex.comm.feign;

import com.ex.comm.feign.servers.FeignService;

/**
 * @Describe
 * @Author wex
 * @Date 2020/8/22 10:45
 * @Version
 * 利用feign集成的Hystrix做将流处理
 **/
public class FeignFall implements FeignService {


    @Override
    public String hello() {
        return "出错误了，实现降级处理";
    }

    @Override
    public String hello(String name) {
        return name + "调用server1失败了,实现了降级处理";
    }
}
