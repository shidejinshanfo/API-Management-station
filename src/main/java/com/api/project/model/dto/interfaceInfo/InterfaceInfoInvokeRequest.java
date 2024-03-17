package com.api.project.model.dto.interfaceInfo;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * 更新请求
 *
 * @TableName product
 */
@Data
public class InterfaceInfoInvokeRequest implements Serializable {

    /**
     * 主键
     */
    private Long id;

    /**
     * 用户请求参数
     */
    private String userRequestParams;
    /**
     * 用户请求参数
     */
    private List<Field> requestParams;



    private static final long serialVersionUID = 1L;
    @Data
    public static class Field {
        private String fieldName;
        private String value;
    }
}