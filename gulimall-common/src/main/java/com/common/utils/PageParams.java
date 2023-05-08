package com.common.utils;

import lombok.Data;

/**
 * 分页请求参数
 */

@Data
public class PageParams {

    /**
     * 当前页码
     */
    private Long page= 1L;
    /**
     * 每页记录数
     */
    private Long limit=10L;
    /**
     * 排序字段
     */
    private String sidx;
    /**
     * 排序方式
     */
    private String order;
    /**
     * 检索关键字
     */
    private String key;
}
