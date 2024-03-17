package com.api.apiinterface;

import com.api.client.sdk.client.ApiClient;
import com.api.client.sdk.model.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

//表示这是一个基于Spring Boot的测试类
@SpringBootTest
class ApiInterfaceApplicationTests {
    //注入一个名为yuApiClient的Bean
    @Resource
    private ApiClient apiclient;

    //表示这是一个测试方法
    @Test
    void contextLoads() {
        //调用yuApiClient的getNameByGet方法，并传入参数"api",将返回的s结果赋值给result变量
        String result = apiclient.getNameByGet("api");
        //创建一个User对象
        User user = new User();
        //设置User对象的username.属性为"api"
        user.setUsername("api");
        //调用yuApiClient的getUserNameByPost方法，并传入user对象作为参数，将返回的结果赋值给usernameByPost变量
        String usernameByPost = apiclient.getUserNameByPost(user);
        //打印result变量的值
        System.out.println(result);
        //打印usernameByPost变量的值
        System.out.println(usernameByPost);
    }
}