package com.hngc.coupon.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.common.to.SkuReductionTo;
import com.hngc.coupon.entity.MemberPrice;
import com.hngc.coupon.entity.SkuFullReduction;
import com.hngc.coupon.entity.SkuLadder;
import com.hngc.coupon.mapper.SkuFullReductionMapper;
import com.hngc.coupon.service.MemberPriceService;
import com.hngc.coupon.service.SkuFullReductionService;
import com.hngc.coupon.service.SkuLadderService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 * 商品满减信息 服务实现类
 * </p>
 *
 * @author hn
 * @since 2023-04
 */
@Service
public class SkuFullReductionServiceImpl extends ServiceImpl<SkuFullReductionMapper, SkuFullReduction> implements SkuFullReductionService {

    @Autowired
    private SkuLadderService skuLadderService;
    @Autowired
    private MemberPriceService memberPriceService;

    /**
     * 保存sku的优惠、满减等信息
     *
     * @param skuReductionTo
     * @return
     */
    @Transactional
    @Override
    public boolean saveFullReduction(SkuReductionTo skuReductionTo) {
        //保存sku的优惠、满减等信息：gulimall_sms -> sms_sku_ladder sms_sku_full_reduction sms_member_price
        SkuLadder skuLadder = new SkuLadder();
        BeanUtils.copyProperties(skuReductionTo, skuLadder);
        skuLadder.setAddOther(skuReductionTo.getCountStatus());
        skuLadderService.save(skuLadder);
        SkuFullReduction skuFullReduction = new SkuFullReduction();
        BeanUtils.copyProperties(skuReductionTo, skuFullReduction);
        if (skuFullReduction.getFullPrice().compareTo(new BigDecimal(0)) > 0) {
            this.save(skuFullReduction);
        }
        List<MemberPrice> memberPriceList = skuReductionTo.getMemberPrice().stream().map(item -> {
            MemberPrice memberPrice = new MemberPrice();
            memberPrice.setSkuId(skuReductionTo.getSkuId());
            memberPrice.setAddOther(1);
            memberPrice.setMemberPrice(item.getPrice());
            memberPrice.setMemberLevelId(item.getId());
            memberPrice.setMemberLevelName(item.getName());
            return memberPrice;
        }).filter(item -> item.getMemberPrice().compareTo(new BigDecimal(0)) > 0).collect(Collectors.toList());
        memberPriceService.saveBatch(memberPriceList);
        return true;
    }
}
