package com.cqut.li.springcloud.api;

import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

/**
 * @author Li
 * @date 2019/5/25-0:15
 */
@Component//不要忘记添加，不要忘记添加
public class UserClientServiceFallbackFactory implements FallbackFactory<UserClientService>
{
    @Override
    public UserClientService create(Throwable throwable)
    {
        return new UserClientService() {

            @Override
            public String login(String user_id, String user_password) {
                return "测试：服务器降级";
            }

            @Override
            public String register(String user_id, String user_password) {
                return null;
            }

            @Override
            public String getUserById(String user_id) {
                return "测试：服务异常（服务抛出异常或者提供服务的服务器宕机）";
            }

            @Override
            public String updateUser(String properties) {
                return null;
            }
        };
    }
}

