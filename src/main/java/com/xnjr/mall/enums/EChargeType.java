package com.xnjr.mall.enums;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: xieyj 
 * @since: 2016年7月23日 下午7:48:57 
 * @history:
 */
public enum EChargeType {
    UNDERUSER("1", "下家"), ENDUSER("2", "终端用户");
    public static Map<String, EChargeType> getBooleanResultMap() {
        Map<String, EChargeType> map = new HashMap<String, EChargeType>();
        for (EChargeType status : EChargeType.values()) {
            map.put(status.getCode(), status);
        }
        return map;
    }

    EChargeType(String code, String value) {
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
