package com.cdkj.service.dto.req;

public class XN001200Req {
    // 应用用户的唯一编号（目前暂用UserId,后期改进）
    private String tokenId;

    private String userId;

    // 发送短信的内容（必填）
    private String content;

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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
