package com.cdkj.service.dto.req;

public class XN805905Req {
    // tokenId(必填)
    private String tokenId;

    // 拥有者(必填)
    private String ownerId;

    // 发送短信内容(必填)
    private String content;

    public String getTokenId() {
        return tokenId;
    }

    public void setTokenId(String tokenId) {
        this.tokenId = tokenId;
    }

    public String getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(String ownerId) {
        this.ownerId = ownerId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
