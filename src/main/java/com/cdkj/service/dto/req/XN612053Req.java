package com.cdkj.service.dto.req;

/**
 * 公司热门设置
 * @author: asus 
 * @since: 2017年6月6日 上午10:06:49 
 * @history:
 */
public class XN612053Req {
    // 编号
    private String code;

    // UI顺序
    private String orderNo;

    // 更新人
    private String updater;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public String getUpdater() {
        return updater;
    }

    public void setUpdater(String updater) {
        this.updater = updater;
    }
}
