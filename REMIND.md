1 Rest微服务构建案例工程模块---使用RestTemplate
- springcloud_microservicecloud_api
- springcloud_microservicecloud_provider_8001
- springcloud_microservicecloud_customer_9001

2 Eureka服务注册与发现
- 单机Eureka
    - springcloud_microservicecloud_api
    - springcloud-microservicecloud-eureka-7001  Eureka Server 提供服务注册和发现   
    - springcloud-microservicecloud-eureka-provider-8081  Service Provider服务提供方将自身服务注册到Eureka，从而使服务消费方能够找到  
    - springcloud_microservicecloud_customer_9001  Service Consumer服务消费方从Eureka获取注册服务列表，从而能够消费服务   
- 集群Eureka
    - **注意事项：修改windows的host文件**
    - Eureka Server 服务注册发现中心
        - springcloud-microservicecloud-eureka-7001
        - springcloud-microservicecloud-eureka-7002
        - springcloud-microservicecloud-eureka-7003
        - springcloud-microservicecloud-eureka-provider-8081  Service Provider服务提供方将自身服务注册到Eureka，从而使服务消费方能够找到  
        - springcloud_microservicecloud_customer_9001  Service Consumer服务消费方从Eureka获取注册服务列表，从而能够消费服务  
    - 测试
        - http://localhost:9001/consumer/dept/discovery
        - http://eureka7001.com:7001/
        - http://eureka7001.com:7002/
        - http://eureka7001.com:7003/