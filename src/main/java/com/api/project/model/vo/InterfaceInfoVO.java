package com.api.project.model.vo;

import com.api.apicommon.model.entity.InterfaceInfo;
import com.api.project.model.entity.Post;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Value Object
 * 一种表示系统中不可变的值的对象
 *
 * @author zzc
 * @TableName product
 */
@EqualsAndHashCode(callSuper = true)
@Data
//继承InterfaceInfo，补充一个调用次数字段
public class InterfaceInfoVO extends InterfaceInfo {

    /**
     * 调用次数
     */
    private Integer totalNum;

    private static final long serialVersionUID = 1L;
}