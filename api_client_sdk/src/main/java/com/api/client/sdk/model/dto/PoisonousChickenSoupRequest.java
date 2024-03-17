package com.api.client.sdk.model.dto;


import com.api.client.sdk.model.entity.PoisonousChickenSoupParams;
import com.api.client.sdk.model.enums.RequestMethodEnum;
import com.api.client.sdk.model.response.PoisonousChickenSoupResponse;
import lombok.experimental.Accessors;

/**
* @Date: 2023年09月17日 08:38
 * @Version: 1.0
 * @Description:
 */
@Accessors(chain = true)
public class PoisonousChickenSoupRequest extends BaseRequest<PoisonousChickenSoupParams, PoisonousChickenSoupResponse> {

    @Override
    public String getPath() {
        return "/poisonousChickenSoup";
    }

    /**
     * 获取响应类
     *
     * @return {@link Class}<{@link PoisonousChickenSoupResponse}>
     */
    @Override
    public Class<PoisonousChickenSoupResponse> getResponseClass() {
        return PoisonousChickenSoupResponse.class;
    }

    @Override
    public String getMethod() {
        return RequestMethodEnum.GET.getValue();
    }
}
