package com.example.li.springcloud_microservicecloud_customer_9001;

import com.example.li.springcloud_microservicecloud_customer_9001.myrule.MySelfRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

@SpringBootApplication
@EnableEurekaClient
//在启动该微服务的时候就能去加载我们的自定义Ribbon配置类，从而使配置生效
//@RibbonClient(name="MICROSERVICECLOUD-DEPT",configuration= RandomRule.class)
@RibbonClient(name="MICROSERVICECLOUD-DEPT",configuration= MySelfRule.class)
public class SpringcloudMicroservicecloudCustomer9001Application {

    public static void main(String[] args) {
        SpringApplication.run(SpringcloudMicroservicecloudCustomer9001Application.class, args);
    }

}
