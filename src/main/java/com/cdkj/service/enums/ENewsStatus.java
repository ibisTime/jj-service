package com.cdkj.service.enums;

public enum ENewsStatus {
    DRAFT("0", "草稿"), SHELVES("1", "上架"), SOLDOUT("2", "下架");

    ENewsStatus(String code, String value) {
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
