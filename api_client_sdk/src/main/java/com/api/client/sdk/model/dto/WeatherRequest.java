package com.api.client.sdk.model.dto;


import com.api.client.sdk.model.entity.WeatherParams;
import com.api.client.sdk.model.enums.RequestMethodEnum;
import com.api.client.sdk.model.response.NameResponse;
import com.api.client.sdk.model.response.ResultResponse;
import lombok.experimental.Accessors;

/**
* @Date: 2023/09/22 10:11:43
 * @Version: 1.0
 * @Description: 获取天气请求
 */
@Accessors(chain = true)
public class WeatherRequest extends BaseRequest<WeatherParams, ResultResponse> {

    @Override
    public String getPath() {
        return "/weather";
    }

    /**
     * 获取响应类
     *
     * @return {@link Class}<{@link NameResponse}>
     */
    @Override
    public Class<ResultResponse> getResponseClass() {
        return ResultResponse.class;
    }


    @Override
    public String getMethod() {
        return RequestMethodEnum.GET.getValue();
    }
}
