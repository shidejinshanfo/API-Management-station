package com.api.client.sdk.model.dto;

import cn.hutool.json.JSONUtil;
import com.api.client.sdk.model.enums.RequestMethodEnum;
import com.api.client.sdk.model.response.ResultResponse;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.HashMap;
import java.util.Map;

/**
* @Date: 2023/09/17 08:13:07
 * @Version: 1.0
 * @Description: 基本api请求
 */
public abstract class BaseRequest<O, T extends ResultResponse> {
    private Map<String, Object> requestParams = new HashMap<>();

    /**
     * get方法
     *
     * @return {@link RequestMethodEnum}
     */
    public abstract String getMethod();

    /**
     * 获取路径
     *
     * @return {@link String}
     */
    public abstract String getPath();

    /**
     * 获取响应类
     *
     * @return {@link Class}<{@link T}>
     */
    public abstract Class<T> getResponseClass();

    @JsonAnyGetter
    public Map<String, Object> getRequestParams() {
        return requestParams;
    }

    public void setRequestParams(O params) {
        this.requestParams = new Gson().fromJson(JSONUtil.toJsonStr(params), new TypeToken<Map<String, Object>>() {
        }.getType());
    }
}