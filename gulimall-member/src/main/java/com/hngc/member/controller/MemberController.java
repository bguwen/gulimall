package com.hngc.member.controller;

import com.common.utils.Result;
import com.hngc.member.entity.Member;
import com.hngc.member.feign.CouponFeignService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    /**
     * 获取用户优惠券信息
     * @return
     */
    @GetMapping("/memberCoupon")
    public Result list() {
        Member member = new Member();
        member.setNickname("张三");
        Object coupon = couponFeignService.memberCoupons().get("coupon");
        return Result.success().put("coupon",coupon).put("member",member);
    }

}
