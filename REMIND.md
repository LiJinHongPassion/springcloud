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
        
3 Ribbon负载均衡
    Spring Cloud Ribbon是基于Netflix Ribbon实现的一套**客户端**负载均衡的工具。
    - Ribbon配置初步（Ribbon和Eureka整合后Consumer可以通过服务名直接调用服务而不用再关心地址和端口号）
        - springcloud-microservicecloud-eureka-7001
        - springcloud-microservicecloud-eureka-7002
        - springcloud-microservicecloud-eureka-7003
        - springcloud-microservicecloud-eureka-provider-8081    
        - springcloud_microservicecloud_customer_9001    
    - Ribbon负载均衡（Ribbon其实就是一个软负载均衡的客户端组件，他可以和其他所需请求的客户端结合使用，和eureka结合只是其中的一个实例。）
        - springcloud-microservicecloud-eureka-7001
        - springcloud-microservicecloud-eureka-7002
        - springcloud-microservicecloud-eureka-7003
        - springcloud-microservicecloud-eureka-provider-8081    服务注册，以下三个服务注册的服务名相同
        - springcloud-microservicecloud-eureka-provider-8082    
        - springcloud-microservicecloud-eureka-provider-8083    
        - springcloud_microservicecloud_customer_9001  
    - Ribbon核心组件IRule（IRule：根据特定算法中从服务列表中选取一个要访问的服务）
        - 方式
            - RoundRobinRule-轮询
            - RandomRule-随机 
            - AvailabilityFilteringRule-会先过滤掉由于多次访问故障而处于断路器跳闸状态的服务，还有并发的连接数量超过阈值的服务，然后对剩余的服务列表按照轮询策略进行访问
            - WeightedResponseTimeRule-根据平均响应时间计算所有服务的权重，响应时间越快服务权重越大被选中的概率越高。刚启动时如果统计信息不足，则使用RoundRobinRule策略，等统计信息足够，会切换到WeightedResponseTimeRule
            - RetryRule-先按照RoundRobinRule的策略获取服务，如果获取服务失败则在指定时间内会进行重试，获取可用的服务
            - BestAvailableRule-会先过滤掉由于多次访问故障而处于断路器跳闸状态的服务，然后选择一个并发量最小的服务
            - ZoneAvoidanceRule-默认规则,复合判断server所在区域的性能和server的可用性选择服务器
        - 示例
            - springcloud-microservicecloud-eureka-7001
            - springcloud-microservicecloud-eureka-7002
            - springcloud-microservicecloud-eureka-7003
            - springcloud-microservicecloud-eureka-provider-8081    服务注册，以下三个服务注册的服务名相同
            - springcloud-microservicecloud-eureka-provider-8082    
            - springcloud-microservicecloud-eureka-provider-8083    
            - springcloud_microservicecloud_customer_9001          在这里修改负载均衡的方式IRule，也可自定义

4 Feign负载均衡
    - springcloud-microservicecloud-eureka-7001
    - springcloud-microservicecloud-eureka-7002
    - springcloud-microservicecloud-eureka-7003
    - springcloud-microservicecloud-eureka-provider-8081    服务注册，以下三个服务注册的服务名相同
    - springcloud-microservicecloud-eureka-provider-8082    
    - springcloud-microservicecloud-eureka-provider-8083 
    - springcloud_microservicecloud_feign_api  注意需要maven的clean再install
    - springcloud_microservicecloud_feign_customer_8001 @EnableFeignClients(basePackages= {"com.cqut.li.springcloud"})
                                                        @ComponentScan({"com.cqut.li.springcloud", "com.example.li.springcloud"}) 不添加这两行会autowrite not be found 
    关于项目启动后，访问路径
    // 原生路径： http://ip+端口/项目名称/action名称/方法mapping  
    // feign路径：http://应用名称/path/方法mapping  
    // 所以在 Path中设置项目名称和action名称  
    
5 Hystrix断路器
    - 服务熔断(服务端provider中实现)
        - springcloud-microservicecloud-eureka-7001
        - springcloud-microservicecloud-eureka-7002
        - springcloud-microservicecloud-eureka-7003
        - springcloud-microservicecloud-hystrix-provider-8081
        - springcloud_microservicecloud_customer_9001
    - 服务降级(客户端customer中实现，整体资源快不够了，忍痛将某些服务先关掉，待渡过难关，再开启回来。)
        - springcloud-microservicecloud-eureka-7001
        - springcloud-microservicecloud-eureka-7002
        - springcloud-microservicecloud-eureka-7003
        - springcloud-microservicecloud-eureka-provider-8081
        - springcloud_microservicecloud_feign_api
        - springcloud_microservicecloud_feign_customer_8001
    - 服务监控
        - springcloud-microservicecloud-eureka-7001
        - springcloud-microservicecloud-eureka-7002
        - springcloud-microservicecloud-eureka-7003
        - springcloud-microservicecloud-hystrix-provider-8081
        - springcloud-microservicecloud-hystrix-dashboard-provider-8081

6 zuul路由网关
    - springcloud-microservicecloud-eureka-7001
    - springcloud-microservicecloud-eureka-7002
    - springcloud-microservicecloud-eureka-7003
    - springcloud-microservicecloud-eureka-provider-8081
    - springcloud-microservicecloud-zuul-gateway-9527
    
6 SpringCloud Config分布式配置中心
    - SpringCloud Config客户端配置与测试
        - 新建github仓库-springcloud_config
        - springcloud-microservicecloud-config-3344 服务端
        - springcloud-microservicecloud-config-client-3355 客户端