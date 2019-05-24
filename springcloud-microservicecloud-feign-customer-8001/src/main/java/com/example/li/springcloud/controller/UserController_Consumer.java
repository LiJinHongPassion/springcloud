package com.example.li.springcloud.controller;

import com.alibaba.fastjson.JSON;
import com.cqut.li.springcloud.api.UserClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;


/**
 * @author Li
 * @date 2019/5/23-21:28
 */

@RestController
public class UserController_Consumer
{

    @Autowired
    private UserClientService service;


    @RequestMapping(value = "/user/login", method = RequestMethod.POST, produces = "text/plain;charset=UTF-8")
    public String login(@RequestParam("user_id") String user_id,
                        @RequestParam("user_password") String user_password) {
        return JSON.toJSON(service.login(user_id, user_password)).toString().replace("\"", "'");
    }

    @RequestMapping(value = "/user/register", method = RequestMethod.POST, produces = "text/plain;charset=UTF-8")
    public String register(@RequestParam("user_id") String user_id,
                           @RequestParam("user_password") String user_password) {
        return JSON.toJSON(service.register(user_id, user_password)).toString().replace("\"", "'");
    }


    //该方法已测试
    @RequestMapping(value = "/user/getUserById", method = RequestMethod.GET, produces = "text/plain;charset=UTF-8")
    public String getUserById(@RequestParam("user_id") String user_id) {
        return JSON.toJSON(service.getUserById(user_id)).toString().replace("\"", "'");

    }
    //该方法已测试
    @RequestMapping(value = "/user/getUserByI", method = RequestMethod.GET, produces = "text/plain;charset=UTF-8")
    @ResponseBody
    public String getUserBdId() {
        return "ok";
    }
}