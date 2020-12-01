package com.example.consumer.controller;

import com.example.consumer.feign.ProviderFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author heshuai
 * @description: 调用接口
 * @create: 2020-12-01 23:41
 **/
@RestController
@RequestMapping("consumer")
public class ConsumerController {

    @Autowired
    private ProviderFeign providerFeign;

    @GetMapping("get/{name}")
    public Object getMessage(@PathVariable("name") String name){
        return providerFeign.getMessage(name);
    }
}
