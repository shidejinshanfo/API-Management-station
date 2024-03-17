package com.api.project.service;

import com.api.apicommon.model.entity.UserInterfaceInfo;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 *
 */
public interface UserInterfaceInfoService extends IService<UserInterfaceInfo> {
    void validUserInterfaceInfo(UserInterfaceInfo userInterfaceInfo, boolean add);

    /**
     * 调用接口计数
     * @param interfaceInfoId
     * @param userId
     * @return
     */
    boolean invokeCount (long interfaceInfoId,long userId);

}
