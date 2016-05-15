/**
 * @Title XN803564Req.java 
 * @Package com.xnjr.moom.dto.req 
 * @Description 
 * @author xieyj  
 * @date 2016年3月6日 上午9:29:25 
 * @version V1.0   
 */
package com.xnjr.mall.dto.req;

/** 
 * 久悬更新
 * @author: xieyj 
 * @since: 2016年3月6日 上午9:29:25 
 * @history:
 */
public class XNpt4005Req {

    // 编号
    private String code;

    // 最后一次流水更新时间
    private String jourDatetime;

    // 提交人
    private String updater;

    // 备注
    private String remark;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getJourDatetime() {
        return jourDatetime;
    }

    public void setJourDatetime(String jourDatetime) {
        this.jourDatetime = jourDatetime;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getUpdater() {
        return updater;
    }

    public void setUpdater(String updater) {
        this.updater = updater;
    }
}
