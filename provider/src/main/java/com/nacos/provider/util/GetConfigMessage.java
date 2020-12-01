package com.nacos.provider.util;

import com.alibaba.nacos.api.NacosFactory;
import com.alibaba.nacos.api.config.ConfigService;
import com.alibaba.nacos.api.exception.NacosException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.core.convert.Property;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Properties;

/**
 * @program: nacos-demo
 * @description: 获取Nacos中的配置信息
 * @create: 2020-11-29 10:47
 **/
@RestController
@RequestMapping("config")
@RefreshScope
public class GetConfigMessage {

    @Value("${message:我是默认信息}")
    private String message;
    @Value("${test1.value:我是默认信息}")
    private String value1;
    @Value("${test2.value:我是默认信息}")
    private String value2;
    @Value("${test3.value:我是默认信息}")
    private String value3;

    @GetMapping("get/java")
    public Object getConfigMessage() throws NacosException {
        String serverAddr = "127.0.0.1:8848";
        String dataId = "nacos-simple-demo.yaml";
        String group = "DEFAULT_GROUP";
        String namespace = "c1f1507f-bb5a-401d-967c-780fb00f9e81";  //命名空间ID
        Properties properties = new Properties();
        properties.put("serverAddr",serverAddr);
        properties.put("namespace",namespace);
        ConfigService configService = NacosFactory.createConfigService(properties);
        String content = configService.getConfig(dataId,group,2000);
        return content;
    }

    @GetMapping("get/springCloud")
    public Object getSpringCloudMessage(){
        return "message:"+this.message+"\t test1:"+this.value1+"\t test2:"+this.value2+"\t test3:"+this.value3;
    }
}
