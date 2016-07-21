package com.xnjr.mall.enums;

import java.util.HashMap;
import java.util.Map;

public enum EIntegralStatus {
    TO_PUT("0", "待发布"), PUT_YES("1", "已发布"), INVALID("2", "已过期");
    public static Map<String, EIntegralStatus> getIntegralStatusMap() {
        Map<String, EIntegralStatus> map = new HashMap<String, EIntegralStatus>();
        for (EIntegralStatus currency : EIntegralStatus.values()) {
            map.put(currency.getCode(), currency);
        }
        return map;
    }

    EIntegralStatus(String code, String value) {
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
