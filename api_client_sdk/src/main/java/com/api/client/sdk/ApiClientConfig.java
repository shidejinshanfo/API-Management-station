package com.api.client.sdk;


import com.api.client.sdk.client.ApiClient;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration//通过@Configuration注解，将该类标记为一个配置类，告诉Spring这是一个用于配置的类
@ConfigurationProperties("api.client")//能够读取application.yml的配置，读取到配置之后，把这个读到的配置设置到我们这里的属性中，这里给所有的配置加上前缀为"api.client"
@Data//@Data注解是一个Lombok注解，自动生成了类的getter、setter方法
@ComponentScan//@ComponentScan注解用于自动扫描组件，使得Spring能够自动注册相应的Bean
public class ApiClientConfig {
    private String accessKey;

    private String secretkey;

    @Bean//创建一个名为ApiClient 的Bean
    public ApiClient apiClient(){
        //使用ak sk 创建一个 ApiClient 的实例
        return new ApiClient(accessKey,secretkey);
    }

}
