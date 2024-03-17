package com.api.project.service.impl;

import com.api.apicommon.model.entity.UserInterfaceInfo;
import com.api.project.common.ErrorCode;
import com.api.project.exception.BusinessException;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.api.project.service.UserInterfaceInfoService;
import com.api.project.mapper.UserInterfaceInfoMapper;
import org.springframework.stereotype.Service;

/**
 *
 */
@Service
public class UserInterfaceInfoServiceImpl extends ServiceImpl<UserInterfaceInfoMapper, UserInterfaceInfo>
    implements UserInterfaceInfoService{
    @Override
    public void validUserInterfaceInfo(UserInterfaceInfo userinterfaceInfo, boolean add) {
        if (userinterfaceInfo == null) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        // 创建时，所有参数必须非空
        if (add) {
            if (userinterfaceInfo.getInterfaceInfoId()<=0 || userinterfaceInfo.getUserId() <= 0) {
                throw new BusinessException(ErrorCode.PARAMS_ERROR,"接口或用户不存在");
            }
        }
        if (userinterfaceInfo.getLeftNum()<0) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR, "剩余次数不能小于0");
        }
    }

    @Override
    public boolean invokeCount(long interfaceInfoId, long userId) {
        //判断（其实这里还应该校验不存在，这里不校验了，因为它不存在，也更新不到那条记录）
        if (interfaceInfoId <= 0 || userId < 0){
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        //是用UpdateWrapper 对象来构建更新条件
        UpdateWrapper<UserInterfaceInfo> updateWrapper = new UpdateWrapper<>();
        //在 updateWrapper 中设置了两个条件：interfaceInfoId等于给定的interfaceInfoId，userId的等于给定的userId
        updateWrapper.eq("interfaceInfoId",interfaceInfoId);
        updateWrapper.eq("userId",userId);
        //setSql 方法用于设置要更新的SQL语句。这里通过SQL表达式实现了两个字段的更新操作
        //leftNum = leftNum - 1和totalNum = totalNum + 1。意思是将leftNum字段减一，totalNum字段加一。
        updateWrapper.setSql("leftNum = leftNum - 1,totalNum = totalNum + 1");
        //最后调用update方法执行更新操作，并返回更新是否成功的结果
        return this.update(updateWrapper);
    }

}




