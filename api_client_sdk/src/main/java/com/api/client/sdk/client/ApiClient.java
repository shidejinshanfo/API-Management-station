package com.api.client.sdk.client;


import cn.hutool.core.util.RandomUtil;
import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpResponse;
import cn.hutool.http.HttpUtil;
import cn.hutool.json.JSONUtil;
import com.api.client.sdk.model.entity.User;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.api.client.sdk.uitls.SignUtils;
import java.util.HashMap;
import java.util.Map;


/**
 * 调用第三方接口的客户端
 */
@Data
@NoArgsConstructor
public class ApiClient {
    private String accessKey;

    private String secretkey;

    private static final String GATEWAY_HOST = "http://localhost:8090";

    public ApiClient(String accessKey, String secretkey) {
        this.accessKey = accessKey;
        this.secretkey = secretkey;
    }

    public String getAccessKey() {
        return accessKey;
    }

    public void setAccessKey(String accessKey) {
        this.accessKey = accessKey;
    }

    public void setSecretkey(String secretkey) {
        this.secretkey = secretkey;
    }

    public String getSecretkey() {
        return secretkey;
    }

    //使用GET方法从服务器获取名称信息
    public String getNameByGet(String name){
        //可以单独传入http参数，这样参数会自动做URL编码，拼接在URL中
        HashMap<String, Object> paramMap = new HashMap<>();
        //将name参数添加到映射中
        paramMap.put("name", name);
        //使用HttpUtil.工具发起GET请求，并获取服务器返回的结果
        String result= HttpUtil.get(GATEWAY_HOST+"/api/name/", paramMap);
        //打印服务器返回的结果
        System.out.println(result);
        //返回结果
        return result;
    }
    //使用Post方法从服务器获取名称信息
    public String getNameByPost( String name){
        //可以单独传入http参数，这样参数会自动做URL编码，拼接在URL中
        HashMap<String, Object> paramMap = new HashMap<>();
        //将name参数添加到映射中
        paramMap.put("name", name);
        //使用HttpUtil.工具发起GET请求，并获取服务器返回的结果
        String result = HttpUtil.post(GATEWAY_HOST+"/api/name/", paramMap);
        //打印服务器返回的结果
        System.out.println(result);
        //返回结果
        return result;
    }



    //创建一个私有方法，用于构造请求头
    private Map<String,String> getHeaderMap(String body){
        //创建一个新的HashMap对象
        Map<String,String> hashMap = new HashMap<String, String>(){{
            //将"accessKey"和其对应的值放入map中
            put("accessKey",accessKey);
            //将"secretKey"和其对应的值放入map中
            put("secretKey",secretkey);
            //随机数
            put("nonce", RandomUtil.randomNumbers(4));
            //用户参数
            put("body",body);
            //时间戳
            put("timestamp",String.valueOf(System.currentTimeMillis() / 1000));
            //签名
            put("sign", SignUtils.genSign(body,secretkey));
        }};
        //返回构造的请求头map
        return hashMap;
    }



    public String getUserNameByPost(User user){
        //将User对象转换为JS0N字符串
        String json = JSONUtil.toJsonStr(user);
        //使用HttpRequest.工具发起POST请求，并获取服务器的响应
        HttpResponse httpResponse = HttpRequest.post(GATEWAY_HOST+"/api/name/user")
                //添加前面构造的请求头
                .addHeaders(getHeaderMap(json))
                .body(json)//将JS0N字符串设置为请求体
                .execute();//执行请求
        //打印服务器返回的状态码
        System.out.println(httpResponse.getStatus());
        //获取服务器返回的结果
        String result = httpResponse.body();
        //打印服务器返回的结果
        System.out.println(result);
        //返回服务器返回的结果
        return result;
    }

    public String getPoisonousChickenSoup(User user){
        //将User对象转换为JS0N字符串
        String json = JSONUtil.toJsonStr(user);
        //使用HttpRequest.工具发起POST请求，并获取服务器的响应
        HttpResponse httpResponse = HttpRequest.get(GATEWAY_HOST+"/api/poisonousChickenSoup")
                //添加前面构造的请求头
                .addHeaders(getHeaderMap(json))
                .body(json)//将JS0N字符串设置为请求体
                .execute();//执行请求
        //打印服务器返回的状态码
        System.out.println(httpResponse.getStatus());
        //获取服务器返回的结果
        String result = httpResponse.body();
        //打印服务器返回的结果
        System.out.println(result);
        //返回服务器返回的结果
        return result;
    }

    public String getRandomWallpaper(User user){
        //将User对象转换为JS0N字符串
        String json = JSONUtil.toJsonStr(user);
        //使用HttpRequest.工具发起POST请求，并获取服务器的响应
        HttpResponse httpResponse = HttpRequest.get(GATEWAY_HOST+"/api/randomWallpaper")
                //添加前面构造的请求头
                .addHeaders(getHeaderMap(json))
                .body(json)//将JS0N字符串设置为请求体
                .execute();//执行请求
        //打印服务器返回的状态码
        System.out.println(httpResponse.getStatus());
        //获取服务器返回的结果
        String result = httpResponse.body();
        //打印服务器返回的结果
        System.out.println(result);
        //返回服务器返回的结果
        return result;
    }

    public String getLoveTalk(User user){
        //将User对象转换为JS0N字符串
        String json = JSONUtil.toJsonStr(user);
        //使用HttpRequest.工具发起POST请求，并获取服务器的响应
        HttpResponse httpResponse = HttpRequest.get(GATEWAY_HOST+"/api/loveTalk")
                //添加前面构造的请求头
                .addHeaders(getHeaderMap(json))
                .body(json)//将JS0N字符串设置为请求体
                .execute();//执行请求
        //打印服务器返回的状态码
        System.out.println(httpResponse.getStatus());
        //获取服务器返回的结果
        String result = httpResponse.body();
        //打印服务器返回的结果
        System.out.println(result);
        //返回服务器返回的结果
        return result;
    }

    public String getWeather(User user){
        //将User对象转换为JS0N字符串
        String json = JSONUtil.toJsonStr(user);
        //使用HttpRequest.工具发起POST请求，并获取服务器的响应
        HttpResponse httpResponse = HttpRequest.get(GATEWAY_HOST+"/api/weather")
                //添加前面构造的请求头
                .addHeaders(getHeaderMap(json))
                .body(json)//将JS0N字符串设置为请求体
                .execute();//执行请求
        //打印服务器返回的状态码
        System.out.println(httpResponse.getStatus());
        //获取服务器返回的结果
        String result = httpResponse.body();
        //打印服务器返回的结果
        System.out.println(result);
        //返回服务器返回的结果
        return result;
    }

    public String getIpInfo(User user){
        //将User对象转换为JS0N字符串
        String json = JSONUtil.toJsonStr(user);
        //使用HttpRequest.工具发起POST请求，并获取服务器的响应
        HttpResponse httpResponse = HttpRequest.get(GATEWAY_HOST+"/api/ipInfo")
                //添加前面构造的请求头
                .addHeaders(getHeaderMap(json))
                .body(json)//将JS0N字符串设置为请求体
                .execute();//执行请求
        //打印服务器返回的状态码
        System.out.println(httpResponse.getStatus());
        //获取服务器返回的结果
        String result = httpResponse.body();
        //打印服务器返回的结果
        System.out.println(result);
        //返回服务器返回的结果
        return result;
    }

    public String getHoroscope(User user){
        //将User对象转换为JS0N字符串
        String json = JSONUtil.toJsonStr(user);
        //使用HttpRequest.工具发起POST请求，并获取服务器的响应
        HttpResponse httpResponse = HttpRequest.get(GATEWAY_HOST+"/api/horoscope")
                //添加前面构造的请求头
                .addHeaders(getHeaderMap(json))
                .body(json)//将JS0N字符串设置为请求体
                .execute();//执行请求
        //打印服务器返回的状态码
        System.out.println(httpResponse.getStatus());
        //获取服务器返回的结果
        String result = httpResponse.body();
        //打印服务器返回的结果
        System.out.println(result);
        //返回服务器返回的结果
        return result;
    }



}

