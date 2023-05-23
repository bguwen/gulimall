package com.hngc.product.vo;

public class BrandVo {
    private Long brandId;
    private String brandName;

    public Long getBrandId() {
        return brandId;
    }

    public BrandVo setBrandId(Long brandId) {
        this.brandId = brandId;
        return this;
    }

    public String getBrandName() {
        return brandName;
    }

    public BrandVo setBrandName(String brandName) {
        this.brandName = brandName;
        return this;
    }
}
