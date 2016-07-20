package com.xnjr.mall.dto.req;

/**
 * 形成积分块
 * @author: xieyj 
 * @since: 2016年7月20日 下午5:38:20 
 * @history:
 */
public class XN602100Req {
    // 用户编号(必填)
    private String userId;

    // 数据(必填)
    private Long quantity;

    // 价格(必填)
    private Long price;

    // 是否需要审核(必填)
    private String isApprove;

    // 更新人(必填)
    private String updater;

    // 备注(选填)
    private String remark;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public String getIsApprove() {
        return isApprove;
    }

    public void setIsApprove(String isApprove) {
        this.isApprove = isApprove;
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
