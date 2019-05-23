package com.example.li.springcloud_microservicecloud_customer_9001.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Li
 * @date 2019/5/23-21:28
 */

@RestController
public class UserController_Consumer
{
    private static final String REST_URL_PREFIX = "http://localhost:8001";

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping(value = "/user/login", method = RequestMethod.POST, produces = "text/plain;charset=UTF-8")
    public String login(@RequestParam("user_id") String user_id,
                        @RequestParam("user_password") String user_password) {
        Map<String, Object> value = new HashMap<>();
        value.put("user_id", user_id);
        value.put("user_password", user_password);
        return restTemplate.postForObject(REST_URL_PREFIX+"/user/login?user_id={user_id}&user_password={user_password}",
                null, String.class, value);
    }

    @RequestMapping(value = "/user/register", method = RequestMethod.POST, produces = "text/plain;charset=UTF-8")
    public String register(@RequestParam("user_id") String user_id,
                           @RequestParam("user_password") String user_password) {
        Map<String, Object> value = new HashMap<>();
        value.put("user_id", user_id);
        value.put("user_password", user_password);
        return restTemplate.postForObject(REST_URL_PREFIX+"/user/register?user_id={user_id}&user_password={user_password}",
                null, String.class, value);
    }

    @RequestMapping(value = "/user/updateUser", method = RequestMethod.POST, produces = "text/plain;charset=UTF-8")
    public String updateUser(@RequestParam("properties") String properties) {
        Map<String, Object> value = new HashMap<>();
        value.put("properties", properties);
        return restTemplate.postForObject(REST_URL_PREFIX+"/user/updateUser?properties={properties}",
                null, String.class, value);
    }

    //该方法已测试
    @RequestMapping(value = "/user/getUserById", method = RequestMethod.GET, produces = "text/plain;charset=UTF-8")
    public String getUserById(@RequestParam("user_id") String user_id) {
        System.out.println("调用服务");
        Map<String, Object> value = new HashMap<>();
        value.put("user_id", user_id);
        return restTemplate.getForObject(REST_URL_PREFIX+"/user/getUserById?user_id={user_id}",
                String.class, value);
    }
}