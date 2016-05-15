package com.xnjr.mall.enums;

public enum EKYCStatus {
    DRAFT("0", "草稿"), TODO_KYC("1", "待kyc"), KYC_YES("2", "kyc通过"), KYC_NO("3",
            "kyc不通过");

    EKYCStatus(String code, String value) {
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
