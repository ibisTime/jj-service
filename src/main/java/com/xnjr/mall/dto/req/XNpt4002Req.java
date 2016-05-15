/**
 * @Title XN803562Req.java 
 * @Package com.xnjr.moom.dto.req 
 * @Description 
 * @author xieyj  
 * @date 2016年3月6日 上午9:24:44 
 * @version V1.0   
 */
package com.xnjr.mall.dto.req;

/** 
 * 审批通过平台账户
 * @author: xieyj 
 * @since: 2016年3月6日 上午9:24:44 
 * @history:
 */
public class XNpt4002Req {
    // 编号
    private String code;

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
