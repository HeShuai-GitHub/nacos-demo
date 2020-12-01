package com.example.consumer.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * Feign 调用 第三方项目
 */
@FeignClient("nacos-simple-demo")
public interface ProviderFeign {
    @PostMapping("provider/get/message")
    String getMessage(@RequestBody String name);
}
