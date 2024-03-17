package com.api.apiinterface.controller;

import com.api.client.sdk.model.entity.User;
import com.api.client.sdk.uitls.SignUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * 名称 API
 */
@RestController
@RequestMapping("/name")
public class NameController {
    @GetMapping("/get")
    public String getNameByGet(String name,HttpServletRequest request){
        //获取请求头名为api的值
        System.out.println(request.getHeader("api"));
        return "Get 你的名字是" + name;
    }
    @PostMapping("/post")
    public String getNameByPost(@RequestParam String name){
        return "Post 你的名字是" + name;
    }
    @PostMapping("/user")
    public String getUserNameByPost(@RequestBody User user, HttpServletRequest request){
//        String accessKey = request.getHeader("accessKey");
//        String nonce = request.getHeader("nonce");
//        String timestamp = request.getHeader("timestamp");
//        String sign = request.getHeader("sign");
//        String body = request.getHeader("body");
//        //todo 去数据库里查accessKey
//        if ((!accessKey.equals("api")) ){
//            throw new RuntimeException("无权限");
//        }
//        //todo 随机数应当存下然后再校验是否一致，校验随机数，模拟一下，直接判断nonce:是否大于10000
//        if (Long.parseLong(nonce)> 10000){
//            throw new RuntimeException("无权限");
//        }
//        //todo 时间和当前时间不能超过5分钟
////        if ()
//        //todo 去数据库里查secretKey
//        String serverSign = SignUtils.genSign(body, "12345678");
//        if (!sign.equals(serverSign)){
//            throw new RuntimeException("无权限");
//        }
        String result = "Post 用户名字是" + user.getUsername();
        return result;
    }
}
