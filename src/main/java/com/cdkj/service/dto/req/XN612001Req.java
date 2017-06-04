package com.cdkj.service.dto.req;

/**
 * 修改资讯
 * @author: asus 
 * @since: 2017年6月4日 下午3:54:46 
 * @history:
 */
public class XN612001Req {
    // 编号
    private String code;

    // 标题
    private String title;

    // 类型
    private String type;

    // 发送方
    private String sendPlatform;

    // 摘要
    private String summary;

    // 内容
    private String content;

    // 是否发布
    private String isPublish;

    // 更新人
    private String updater;

    // 备注
    private String remark;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSendPlatform() {
        return sendPlatform;
    }

    public void setSendPlatform(String sendPlatform) {
        this.sendPlatform = sendPlatform;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getIsPublish() {
        return isPublish;
    }

    public void setIsPublish(String isPublish) {
        this.isPublish = isPublish;
    }

    public String getUpdater() {
        return updater;
    }

    public void setUpdater(String updater) {
        this.updater = updater;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
