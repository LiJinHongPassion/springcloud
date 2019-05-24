package com.cqut.li.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author Li
 * @date 2019/5/23-23:08
 */
@SpringBootApplication
@EnableEurekaServer//EurekaServer服务器端启动类,接受其它微服务注册进来
public class Eureka_Server7002_App
{
    public static void main(String[] args)
    {
        SpringApplication.run(Eureka_Server7002_App.class, args);
    }
}

