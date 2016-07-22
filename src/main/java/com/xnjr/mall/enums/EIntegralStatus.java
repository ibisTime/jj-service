package com.xnjr.mall.enums;

import java.util.HashMap;
import java.util.Map;

public enum EIntegralStatus {
    TO_PUT("1", "使用中"), PUT_ON("2", "已上架"), PUT_OFF("3", "已下架"), INVALID("4",
            "已废弃");
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
