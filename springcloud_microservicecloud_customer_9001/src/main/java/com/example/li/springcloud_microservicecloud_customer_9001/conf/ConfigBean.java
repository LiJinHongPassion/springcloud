package com.example.li.springcloud_microservicecloud_customer_9001.conf;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RetryRule;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author Li
 * @date 2019/5/23-21:27
 * 了解RestTemplate:
 *      RestTemplate提供了多种便捷访问远程Http服务的方法，
 *      是一种简单便捷的访问restful服务模板类，是Spring提供的用于访问Rest服务的客户端模板工具集
 * 使用：
 *      使用restTemplate访问restful接口非常的简单粗暴无脑。
 *      (url, requestMap, ResponseBean.class)这三个参数分别代表
 *      REST请求地址、请求参数、HTTP响应转换被转换成的对象类型。
 */
@Configuration
public class ConfigBean
{
    @Bean
    @LoadBalanced
    public RestTemplate getRestTemplate()
    {
        return new RestTemplate();
    }

    @Bean
    public IRule myRule()
    {
        //return new RoundRobinRule();
        //return new RandomRule();//达到的目的，用我们重新选择的随机算法替代默认的轮询。
        return new RetryRule();
    }
}

