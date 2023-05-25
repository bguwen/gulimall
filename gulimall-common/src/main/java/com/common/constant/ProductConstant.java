package com.common.constant;

public enum ProductConstant {
    ATTR_TYPE_BASE("基本属性", 1), ATTR_TYPE_SALE("销售属性", 0),
    SPU_NO_PUBLISH("未上架", 0), SPU_YES_PUBLISH("已上架", 1),
    SPU_UNDEFINED_PUBLISH("未定义", -1);

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
