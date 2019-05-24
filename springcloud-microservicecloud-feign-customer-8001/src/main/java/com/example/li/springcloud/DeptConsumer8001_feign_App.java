package com.example.li.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients(basePackages= {"com.cqut.li.springcloud"})
@ComponentScan({"com.cqut.li.springcloud", "com.example.li.springcloud"})//重要，扫描注解
public class DeptConsumer8001_feign_App {

    public static void main(String[] args) {
        SpringApplication.run(DeptConsumer8001_feign_App.class, args);
    }

}
