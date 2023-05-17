package com.common.constant;

public enum ProductConstant {
    ATTR_TYPE_BASE("基本属性", 1), ATTR_TYPE_SALE("销售属性", 0);
    private final String msg;
    private final Integer code;

    public String getMsg() {
        return msg;
    }

    public Integer getCode() {
        return code;
    }

    ProductConstant(String msg, Integer code) {
        this.msg = msg;
        this.code = code;
    }
}
