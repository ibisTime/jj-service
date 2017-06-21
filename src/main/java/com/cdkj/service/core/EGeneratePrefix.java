package com.cdkj.service.core;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: xieyj 
 * @since: 2016年5月24日 上午8:29:02 
 * @history:
 */
public enum EGeneratePrefix {
    NEWS("N", "资讯"), QUALIFY("ZZ", "资质"), GROUP("Z", "组"), FOCUS("F", "关注"), FW(
            "FW", "服务"), XQ("XQ", "需求"), BCYX("BC", "BC意向"), JL("JL", "简历"), ZW(
            "ZW", "职位"), COMPANY("C", "公司"), GSQUALIFY("GQ", "公司资质"), TRAIN(
            "TR", "培训"), PHOTO("SY", "照片"), OPERATE("YY", "运营"), CBYX("CB",
            "CB意向");

    public static Map<String, EGeneratePrefix> getOrderTypeMap() {
        Map<String, EGeneratePrefix> map = new HashMap<String, EGeneratePrefix>();
        for (EGeneratePrefix orderType : EGeneratePrefix.values()) {
            map.put(orderType.getCode(), orderType);
        }
        return map;
    }

    EGeneratePrefix(String code, String value) {
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
