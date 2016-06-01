package com.xnjr.mall.dto.req;

public class XN805902Req {
    // 应用用户的唯一编号（目前暂用UserId,后期改进）
    private String tokenId;

    private String userId;

    // 待校验交易密码
    private String tradePwd;

    public String getTokenId() {
        return tokenId;
    }

    public void setTokenId(String tokenId) {
        this.tokenId = tokenId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getTradePwd() {
        return tradePwd;
    }

    public void setTradePwd(String tradePwd) {
        this.tradePwd = tradePwd;
    }

}
