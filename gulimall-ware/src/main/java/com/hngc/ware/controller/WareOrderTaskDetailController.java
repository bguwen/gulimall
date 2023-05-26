package com.hngc.ware.controller;

import com.common.utils.PageParams;
import com.common.utils.Result;
import com.hngc.ware.service.WareOrderTaskDetailService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 库存工作单 前端控制器
 * </p>
 *
 * @author hn
 * @since 2023-04
 */
@Api(tags = "库存工作单")
@RestController
@RequestMapping("/wareOrderTaskDetail")
public class WareOrderTaskDetailController {

    @Autowired
    private WareOrderTaskDetailService wareOrderTaskDetailService;

    /**
     * 查询采购需求
     *
     * @param pageParams
     * @param status
     * @param wareId
     * @return
     */
    @PostMapping("page")
    public Result page(@RequestBody PageParams pageParams, @RequestParam(required = false) Integer status, @RequestParam(required = false) Long wareId) {
        return Result.success().put("page", wareOrderTaskDetailService.pageInfo(pageParams, status, wareId));
    }
}
