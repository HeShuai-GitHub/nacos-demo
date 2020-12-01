package com.nacos.provider.api;

import org.springframework.web.bind.annotation.*;

/**
 * @program: nacos-demo
 * @description: 对外提供的接口
 * @create: 2020-12-01 23:38
 **/
@RestController
@RequestMapping("provider")
public class ProviderController {

    @PostMapping("get/message")
    public String getMessage(@RequestBody String name){
        return "Success , param is "+name;
    }
}
