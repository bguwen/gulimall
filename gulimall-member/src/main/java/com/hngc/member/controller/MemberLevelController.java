package com.hngc.member.controller;

import com.common.utils.PageParams;
import com.common.utils.Result;
import com.common.valid.AddGroup;
import com.common.valid.UpdateGroup;
import com.hngc.member.entity.MemberLevel;
import com.hngc.member.service.MemberLevelService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 会员等级 前端控制器
 * </p>
 *
 * @author hn
 * @since 2023-04
 */
@Api(tags = "会员等级")
@RestController
@RequestMapping("/memberLevel")
public class MemberLevelController {

    @Autowired
    private MemberLevelService memberLevelService;

    /**
     * 分页获取会员等级
     *
     * @param pageParams
     * @return
     */
    @PostMapping("level")
    public Result getLevel(@RequestBody PageParams pageParams) {
        return Result.success().put("page", memberLevelService.levelPage(pageParams));
    }

    /**
     * 添加会员等级
     *
     * @param memberLevel
     * @return
     */
    @PostMapping("save")
    public Result save(@Validated(AddGroup.class) @RequestBody MemberLevel memberLevel) {
        return memberLevelService.save(memberLevel) ? Result.success() : Result.error();
    }

    /**
     * 修改会员等级
     *
     * @param memberLevel
     * @return
     */
    @PostMapping("update")
    public Result update(@Validated(UpdateGroup.class) @RequestBody MemberLevel memberLevel) {
        return memberLevelService.updateById(memberLevel) ? Result.success() : Result.error();
    }

    /**
     * 根据id获取会员等级详细信息
     *
     * @param
     * @return
     */
    @GetMapping("info/{id}")
    public Result save(@PathVariable Long id) {
        return Result.success().put("memberLevel", memberLevelService.getById(id));
    }
    /**
     * 根据id批量删除会员等级信息
     *
     * @param
     * @return
     */
    @DeleteMapping("delete")
    public Result delete(@RequestBody List<Long> ids) {
        return memberLevelService.removeBatchByIds(ids)? Result.success():Result.error();
    }
}
