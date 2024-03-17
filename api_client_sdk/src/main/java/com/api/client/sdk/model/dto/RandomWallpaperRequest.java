package com.api.client.sdk.model.dto;


import com.api.client.sdk.model.entity.RandomWallpaperParams;
import com.api.client.sdk.model.enums.RequestMethodEnum;
import com.api.client.sdk.model.response.RandomWallpaperResponse;
import com.api.client.sdk.model.response.ResultResponse;
import lombok.experimental.Accessors;

/**
* @Date: 2023年09月17日 08:38
 * @Version: 1.0
 * @Description:
 */
@Accessors(chain = true)
public class RandomWallpaperRequest extends BaseRequest<RandomWallpaperParams, RandomWallpaperResponse> {
    @Override
    public String getPath() {
        return "/randomWallpaper";
    }

    /**
     * 获取响应类
     *
     * @return {@link Class}<{@link ResultResponse}>
     */
    @Override
    public Class<RandomWallpaperResponse> getResponseClass() {
        return RandomWallpaperResponse.class;
    }


    @Override
    public String getMethod() {
        return RequestMethodEnum.GET.getValue();
    }
}
