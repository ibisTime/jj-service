/**
 * @Title XN803563Req.java 
 * @Package com.xnjr.moom.dto.req 
 * @Description 
 * @author xieyj  
 * @date 2016年3月6日 上午9:25:56 
 * @version V1.0   
 */
package com.xnjr.mall.dto.req;

/** 
 * 审核平台账户
 * @author: xieyj 
 * @since: 2016年3月6日 上午9:25:56 
 * @history:
 */
public class XNpt4003Req {
    // 编号（必填）
    private String code;

    // 审核人（必填）
    private String updater;

    // 审核意见（必填）
    private String remark;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
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
