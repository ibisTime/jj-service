package com.xnjr.mall.enums;

/**
 * 结构
 * @author: Gejin 
 * @since: 2016年4月13日 上午11:44:11 
 * @history:
 */
public enum EPTStructureStatus {
    todoCheck("1", "启用"), CHECK_YES("0", "未启用");

    EPTStructureStatus(String code, String value) {
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
