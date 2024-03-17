package com.api.project.service.impl.inner;

import com.api.apicommon.model.entity.UserInterfaceInfo;
import com.api.apicommon.service.InnerUserInterfaceInfoService;
import com.api.project.common.ErrorCode;
import com.api.project.exception.BusinessException;
import com.api.project.mapper.UserInterfaceInfoMapper;
import com.api.project.service.UserInterfaceInfoService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.apache.commons.lang3.StringUtils;
import org.apache.dubbo.config.annotation.DubboService;

import javax.annotation.Resource;
@DubboService
public class InnerUserInterfaceInfoServiceImpl implements InnerUserInterfaceInfoService {
    @Resource
    private UserInterfaceInfoService userInterfaceInfoService;
    @Resource
    private UserInterfaceInfoMapper userInterfaceInfoMapper;

    @Override
    public boolean invokeCount(long interfaceInfoId, long userId) {
        //调用注入的UserInterfaceInfoService的invoke方法
        return userInterfaceInfoService.invokeCount(interfaceInfoId, userId);
    }
    @Override
    public boolean invokeLeftNum (long interfaceInfoId, long userId){
        QueryWrapper<UserInterfaceInfo> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("interfaceInfoId", interfaceInfoId);
        queryWrapper.eq("userId", userId);

        UserInterfaceInfo userInterfaceInfo = userInterfaceInfoMapper.selectOne(queryWrapper);
        Integer leftNum = userInterfaceInfo.getLeftNum();
        if (leftNum > 0) {
            return true; // 如果 leftNum 大于 0，则表示有剩余次数
        } else {
            throw new BusinessException(ErrorCode.PARAMS_ERROR, "该接口剩余次数小于0");
            // 如果 leftNum 不大于 0，则表示没有剩余次数
        }
    }
}
