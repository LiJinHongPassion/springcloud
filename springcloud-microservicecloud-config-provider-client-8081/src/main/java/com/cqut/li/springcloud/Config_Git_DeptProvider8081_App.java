package com.cqut.li.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author Li
 * @date 2019/5/23-21:09
 */
@SpringBootApplication
@EnableEurekaClient //本服务启动后会自动注册进eureka服务中
@EnableDiscoveryClient //服务发现
public class Config_Git_DeptProvider8081_App
{
    public static void main(String[] args)
    {
        SpringApplication.run(Config_Git_DeptProvider8081_App.class, args);
    }
}

