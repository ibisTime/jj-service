package com.xnjr.mall.enums;

public enum ERepayPlanType {
    LXM("1", "流项目"), NH_JS("2", "年化结束项目"), FC_JS("3", "分成结束项目"), BDFC_JS("4",
            "保底+分成结束项目");

    ERepayPlanType(String code, String value) {
        this.code = code;
        this.value = value;
    }

    private String code;

    private String value;

    public String getCode() {
        return code;
    }

    public String getValue() {
        return value;
    }
}
