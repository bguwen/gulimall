package com.hngc.ware.controller;

import com.common.utils.PageParams;
import com.common.utils.Result;
import com.common.valid.AddGroup;
import com.common.valid.UpdateGroup;
import com.hngc.ware.entity.WareInfo;
import com.hngc.ware.entity.WareSku;
import com.hngc.ware.service.WareInfoService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 仓库信息 前端控制器
 * </p>
 *
 * @author hn
 * @since 2023-04
 */
@Api(tags = "仓库信息")
@RestController
@RequestMapping("/wareInfo")
public class WareInfoController {

    @Autowired
    private WareInfoService wareInfoService;

    /**
     * 分页查询仓库信息
     *
     * @param pageParams
     * @return
     */
    @PostMapping("page")
    private Result page(@RequestBody PageParams pageParams) {
        return Result.success().put("page", wareInfoService.pageInfo(pageParams));
    }

    /**
     * 新增仓库信息
     *
     * @param wareSku
     * @return
     */
    @PostMapping("save")
    private Result save(@Validated(AddGroup.class) @RequestBody WareInfo wareSku) {
        return wareInfoService.save(wareSku) ? Result.success() : Result.error();
    }

    /**
     * 修改仓库信息
     *
     * @param wareSku
     * @return
     */
    @PostMapping("update")
    private Result update(@Validated(UpdateGroup.class) @RequestBody WareInfo wareSku) {
        return wareInfoService.updateById(wareSku) ? Result.success() : Result.error();
    }
    /**
     * 根据id查询仓库信息
     *
     * @param id
     * @return
     */
    @GetMapping("info/{id}")
    private Result info(@PathVariable Long id) {
        return Result.success().put("wareSku",wareInfoService.getById(id) );
    }
}
