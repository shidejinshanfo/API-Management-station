package com.api.apicommon.service;


import com.api.apicommon.model.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;


/**
 * 用户服务
 *
 * @author zzc
 */
public interface InnerUserService {

    /**
     * 数据库中查是否分配给用户密钥（accessKey）
     * @param accessKey
     * @return
     */
    User getInvokeUser(String accessKey);

}
