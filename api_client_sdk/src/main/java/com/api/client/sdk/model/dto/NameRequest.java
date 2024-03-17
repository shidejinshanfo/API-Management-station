package com.api.client.sdk.model.dto;


import com.api.client.sdk.model.entity.NameParams;
import com.api.client.sdk.model.enums.RequestMethodEnum;
import com.api.client.sdk.model.response.NameResponse;
import lombok.experimental.Accessors;

/**
* @Date: 2023年09月17日 08:38
 * @Version: 1.0
 * @Description:
 */
@Accessors(chain = true)
public class NameRequest extends BaseRequest<NameParams, NameResponse> {

    @Override
    public String getPath() {
        return "/name";
    }

    /**
     * 获取响应类
     *
     * @return {@link Class}<{@link NameResponse}>
     */
    @Override
    public Class<NameResponse> getResponseClass() {
        return NameResponse.class;
    }


    @Override
    public String getMethod() {
        return RequestMethodEnum.GET.getValue();
    }
}
