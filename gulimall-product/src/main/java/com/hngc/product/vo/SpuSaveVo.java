package com.hngc.product.vo;

import com.common.to.MemberPrice;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.List;


@Data
public class SpuSaveVo {
    @NotBlank
    private String spuName;
    @NotBlank
    private String spuDescription;
    @NotNull
    private Long catelogId;
    @NotNull
    private Long brandId;
    @NotNull
    private BigDecimal weight;
    @NotNull
    private Integer publishStatus;
    @NotBlank
    private List<String> decript;
    @NotBlank
    private List<String> images;
    @NotNull
    @NotBlank
    private BoundsDTO bounds;
    @NotNull
    @NotBlank
    private List<BaseAttrsDTO> baseAttrs;
    @NotNull
    @NotBlank
    private List<SkusDTO> skus;


    @Data
    public static class BoundsDTO {
        private BigDecimal buyBounds;
        private BigDecimal growBounds;
    }


    @Data
    public static class BaseAttrsDTO {
        private Long attrId;
        private String attrValues;
        private Integer showDesc;
    }


    @Data
    public static class SkusDTO {
        private List<AttrDTO> attr;
        private String skuName;
        private BigDecimal price;
        private String skuTitle;
        private String skuSubtitle;
        private List<Images> images;
        private List<String> descar;
        private Integer fullCount;
        private BigDecimal discount;
        private Integer countStatus;
        private BigDecimal fullPrice;
        private BigDecimal reducePrice;
        private Integer priceStatus;
        private List<MemberPrice> memberPrice;


        @Data
        public static class AttrDTO {
            private Long attrId;
            private String attrName;
            private String attrValue;
        }


        @Data
        public static class Images {
            private String imgUrl;
            private Integer defaultImg;
        }
    }
}
