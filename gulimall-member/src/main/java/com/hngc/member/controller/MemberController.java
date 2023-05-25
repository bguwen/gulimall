package com.hngc.member.controller;

import com.common.utils.PageParams;
import com.common.utils.Result;
import com.hngc.feign.CouponFeignService;
import com.hngc.member.entity.Member;
import com.hngc.member.service.MemberService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 会员 前端控制器
 * </p>
 *
 * @author hn
 * @since 2023-04
 */
@Api(tags = "会员")
@RestController
@RequestMapping("/member")
public class MemberController {
    @Autowired
    private CouponFeignService couponFeignService;
    @Autowired
    private MemberService memberService;

    /**
     * 获取用户优惠券信息
     *
     * @return
     */
    @GetMapping("/memberCoupon")
    public Result list() {
        Member member = new Member();
        member.setNickname("张三");
        Object coupon = couponFeignService.memberCoupons().get("coupon");
        return Result.success().put("coupon", coupon).put("member", member);
    }

    /**
     * 分页获取会员信息
     *
     * @return
     */
    @PostMapping("page")
    public Result page(@RequestBody PageParams pageParams) {
        return Result.success().put("page", memberService.pageMember(pageParams));
    }
}
