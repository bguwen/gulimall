package com.hngc.coupon.controller;

import com.common.utils.Result;
import com.hngc.coupon.entity.Coupon;
import com.hngc.coupon.service.CouponService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * <p>
 * 优惠券信息 前端控制器
 * </p>
 *
 * @author hn
 * @since 2023-04
 */
@RefreshScope
@Api(tags = "优惠券信息")
@RestController
@RequestMapping("/coupon")
public class CouponController {

    @Resource
    private CouponService couponService;

    @Value("${test.name}")
    private String name;
    @Value("${test.age}")
    private String age;


    @GetMapping("/test")
    public Result test() {
        return Result.success().put("name", name).put("age", age);
    }

    @GetMapping("/member/list")
    public Result memberCoupons() {
        Coupon coupon = new Coupon();
        coupon.setCouponName("满100减10");
        return Result.success().put("coupon", coupon);
    }
}
