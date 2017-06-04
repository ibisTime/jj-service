package com.cdkj.service.dto.req;

/**
 * 列表查询资讯
 * @author: asus 
 * @since: 2017年6月4日 下午4:01:59 
 * @history:
 */
public class XN612006Req extends APageReq {

    /** 
     * @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么) 
     */
    private static final long serialVersionUID = 1L;

    // 类型
    private String type;

    // 标题
    private String title;

    // 摘要
    private String summary;

    // 状态（0 草稿 ，1发布，2下架）
    private String status;

    // 发送平台
    private String sendPlatform;

    // 更新人
    private String updater;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getSendPlatform() {
        return sendPlatform;
    }

    public void setSendPlatform(String sendPlatform) {
        this.sendPlatform = sendPlatform;
    }

    public String getUpdater() {
        return updater;
    }

    public void setUpdater(String updater) {
        this.updater = updater;
    }
}
