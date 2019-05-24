package com.cqut.li.springcloud.api;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;


/**
 * @author Li
 * @date 2019/5/24-18:22
 */
@FeignClient(value = "MICROSERVICECLOUD-DEPT",fallbackFactory=UserClientServiceFallbackFactory.class)
public interface UserClientService
{

    @RequestMapping(value = "/user/login", method = RequestMethod.POST, produces = "text/plain;charset=UTF-8")
    public String login(@RequestParam("user_id") String user_id,
                        @RequestParam("user_password") String user_password);


    @RequestMapping(value = "/user/register", method = RequestMethod.POST, produces = "text/plain;charset=UTF-8")
    public String register(@RequestParam("user_id") String user_id,
                           @RequestParam("user_password") String user_password);

    //该方法已测试
    @RequestMapping(value = "/user/getUserById", method = RequestMethod.GET, produces = "text/plain;charset=UTF-8")
    public String getUserById(@RequestParam("user_id") String user_id);


    @RequestMapping(value = "/user/updateUser", method = RequestMethod.POST, produces = "text/plain;charset=UTF-8")
    public String updateUser(@RequestParam("properties") String properties);
}

