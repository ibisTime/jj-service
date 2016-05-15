package com.xnjr.mall.dto.req;

public class XNfd2063Req {

    // 编号（必填）
    private String id;

    // kyc用户编号（必填）
    private String kycUser;

    // kyc审核结果 1-通过，0不通过（必填）
    private String kycResult;

    // kyc审核意见
    private String kycNote;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getKycUser() {
        return kycUser;
    }

    public void setKycUser(String kycUser) {
        this.kycUser = kycUser;
    }

    public String getKycResult() {
        return kycResult;
    }

    public void setKycResult(String kycResult) {
        this.kycResult = kycResult;
    }

    public String getKycNote() {
        return kycNote;
    }

    public void setKycNote(String kycNote) {
        this.kycNote = kycNote;
    }

}
