package com.api.apicommon.service;

/**
 *
 */
public interface InnerUserInterfaceInfoService {

    /**
     * 调用接口计数
     * @param interfaceInfoId
     * @param userId
     * @return
     */
    boolean invokeCount (long interfaceInfoId,long userId);

    /**
     * 是否还有可调用的次数
     * @param interfaceInfoId
     * @param userId
     * @return
     */
    boolean invokeLeftNum (long interfaceInfoId, long userId);

}
