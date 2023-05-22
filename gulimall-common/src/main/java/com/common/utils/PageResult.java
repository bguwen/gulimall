package com.common.utils;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.OrderItem;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import lombok.Data;

import java.util.List;

/**
 * 分页查询工具类
 * @param <T>
 */
@Data
public class PageResult<T> {
    /**
     * 总记录数
     */
    private Long totalCount;
    /**
     * 每页大小
     */
    private Long pageSize;
    /**
     * 总页码
     */
    private Long totalPage;
    /**
     * 当前页码
     */
    private Long currPage;
    /**
     * 当前页所有数据
     */
    private List<T> list;

    public PageResult() {
    }

    public PageResult(Long totalCount, Long pageSize, Long totalPage, Long currPage, List<T> list) {
        this.totalCount = totalCount;
        this.pageSize = pageSize;
        this.totalPage = totalPage;
        this.currPage = currPage;
        this.list = list;
    }

    /**
     * 分页查询
     *
     * @param service
     * @param pageParams
     * @return
     */

    public PageResult<T> page(IService<T> service, PageParams pageParams) {
        Page<T> page = new Page<>(pageParams.getPage(), pageParams.getLimit());
        //封装 排序字段、排序方式
        page.addOrder(new OrderItem(pageParams.getSidx(), "asc".equalsIgnoreCase(pageParams.getOrder())));
        Page<T> pageResult = service.page(page);
        return new PageResult<T>(pageResult.getTotal(), pageResult.getSize(), pageResult.getPages(), pageResult.getCurrent(), pageResult.getRecords());
    }

    public PageResult<T> page(IService<T> service, PageParams pageParams, LambdaQueryWrapper<T> lambdaQueryWrapper) {
        Page<T> page = new Page<>(pageParams.getPage(), pageParams.getLimit());
        //封装 排序字段、排序方式
        page.addOrder(new OrderItem(pageParams.getSidx(), "asc".equalsIgnoreCase(pageParams.getOrder())));
        Page<T> pageResult = service.page(page);
        return new PageResult<T>(pageResult.getTotal(), pageResult.getSize(), pageResult.getPages(), pageResult.getCurrent(), pageResult.getRecords());
    }
}
