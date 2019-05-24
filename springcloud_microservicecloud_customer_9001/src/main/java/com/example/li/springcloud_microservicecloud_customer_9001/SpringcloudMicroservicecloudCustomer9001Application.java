package com.example.li.springcloud_microservicecloud_customer_9001;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class SpringcloudMicroservicecloudCustomer9001Application {

    public static void main(String[] args) {
        SpringApplication.run(SpringcloudMicroservicecloudCustomer9001Application.class, args);
    }

}
