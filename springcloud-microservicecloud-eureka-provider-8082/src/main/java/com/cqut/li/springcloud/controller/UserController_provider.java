package com.cqut.li.springcloud.controller;


import com.alibaba.fastjson.JSON;
import com.cqut.li.springcloud.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@RestController
public class UserController_provider {

    //@Qualifier(value = "org.springframework.cloud.client.discovery.DiscoveryClient")
    @Resource
    private DiscoveryClient client;

    @RequestMapping(value = "/dept/discovery", method = RequestMethod.GET)
    public Object discovery()
    {
        List<String> list = client.getServices();
        System.out.println("**********" + list);

        List<ServiceInstance> srvList = client.getInstances("MICROSERVICECLOUD-DEPT");
        for (ServiceInstance element : srvList) {
            System.out.println(element.getServiceId() + "\t" + element.getHost() + "\t" + element.getPort() + "\t"
                    + element.getUri());
        }
        return this.client;
    }


    @Resource(name = "userService")
    private IUserService userService;

    @RequestMapping(value = "/user/login", method = RequestMethod.POST, produces = "text/plain;charset=UTF-8")
    @ResponseBody
    public String login(@RequestParam("user_id") String user_id,
                        @RequestParam("user_password") String user_password) {

        List<Map<String, Object>> result = userService.login(user_id, user_password);

        return JSON.toJSON(result).toString().replace("\"", "'");
    }

    @RequestMapping(value = "/user/register", method = RequestMethod.POST, produces = "text/plain;charset=UTF-8")
    @ResponseBody
    public String register(@RequestParam("user_id") String user_id,
                           @RequestParam("user_password") String user_password) {

        Map<String, Object> result = userService.register(user_id, user_password);

        return JSON.toJSON(result).toString().replace("\"", "'");
    }

    @RequestMapping(value = "/user/updateUser", method = RequestMethod.POST, produces = "text/plain;charset=UTF-8")
    @ResponseBody
    public String updateUser(@RequestParam("properties") String properties) {

        Map<String, Object> maps = (Map<String, Object>) JSON.parse(properties);

        Map<String, Object> result = userService.updateUser(maps);

        return JSON.toJSON(result).toString().replace("\"", "'");
    }

    @RequestMapping(value = "/user/getUserById", method = RequestMethod.GET, produces = "text/plain;charset=UTF-8")
    @ResponseBody
    public String getUserById(@RequestParam("user_id") String user_id) {

        Map<String, Object> result = userService.getUserById(user_id);
        result.put("url", "springcloud-microservicecloud-eureka-provider-8082");

        return JSON.toJSON(result).toString().replace("\"", "'");
    }
}
