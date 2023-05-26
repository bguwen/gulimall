package com.hngc.ware.controller;

import com.common.utils.PageParams;
import com.common.utils.Result;
import com.common.valid.AddGroup;
import com.common.valid.UpdateGroup;
import com.hngc.ware.entity.PurchaseDetail;
import com.hngc.ware.service.PurchaseDetailService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author hn
 * @since 2023-04
 */
@Api(tags = "")
@RestController
@RequestMapping("/purchaseDetail")
public class PurchaseDetailController {

    @Autowired
    private PurchaseDetailService purchaseDetailService;

    /**
     * 分页查询采购需求
     *
     * @param pageParams
     * @param status
     * @param wareId
     * @return
     */
    @PostMapping("page")
    private Result page(@RequestBody PageParams pageParams, @RequestParam(required = false) Integer status, Long wareId) {
        return Result.success().put("page", purchaseDetailService.pageInfo(pageParams, status, wareId));
    }

    /**
     * 保存采购需求
     *
     * @param purchaseDetail
     * @return
     */
    @PostMapping("save")
    private Result save(@Validated(AddGroup.class) @RequestBody PurchaseDetail purchaseDetail) {
        purchaseDetailService.save(purchaseDetail);
        return Result.success();
    }
    /**
     * 修改采购需求
     *
     * @param purchaseDetail
     * @return
     */
    @PostMapping("update")
    private Result update(@Validated(UpdateGroup.class) @RequestBody PurchaseDetail purchaseDetail) {
        purchaseDetailService.save(purchaseDetail);
        return Result.success();
    }
}
