/**
 * @Title Product.java 
 * @Package com.xnjr.mall.domain 
 * @Description 
 * @author haiqingzheng  
 * @date 2016年5月16日 下午8:01:28 
 * @version V1.0   
 */
package com.xnjr.mall.domain;

import com.xnjr.mall.dao.base.ABaseDO;

/** 
 * @author: haiqingzheng 
 * @since: 2016年5月16日 下午8:01:28 
 * @history:
 */
public class Product extends ABaseDO {

    /** 
     * @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么) 
     */
    private static final long serialVersionUID = 8925323602686009210L;

    // 产品编号
    private String code;

    // 产品大类
    private String type;

    // 产品名称
    private String name;

    // 广告语
    private String advTitle;

    // 广告图片
    private String advPic;

    // 主推图
    private String majorPic;

    // 主推文本
    private String majorText;

    // 全家福图
    private String familyPic;

    // 全家福文本
    private String familyText;

    // 亮点图
    private String highlightPic;

    // 亮点文本
    private String highlighText;

    // 状态
    private String status;

    // 更新人
    private String updater;

    // 更新时间
    private String updateDatetime;

    // 备注
    private String remark;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAdvTitle() {
        return advTitle;
    }

    public void setAdvTitle(String advTitle) {
        this.advTitle = advTitle;
    }

    public String getAdvPic() {
        return advPic;
    }

    public void setAdvPic(String advPic) {
        this.advPic = advPic;
    }

    public String getMajorPic() {
        return majorPic;
    }

    public void setMajorPic(String majorPic) {
        this.majorPic = majorPic;
    }

    public String getMajorText() {
        return majorText;
    }

    public void setMajorText(String majorText) {
        this.majorText = majorText;
    }

    public String getFamilyPic() {
        return familyPic;
    }

    public void setFamilyPic(String familyPic) {
        this.familyPic = familyPic;
    }

    public String getFamilyText() {
        return familyText;
    }

    public void setFamilyText(String familyText) {
        this.familyText = familyText;
    }

    public String getHighlightPic() {
        return highlightPic;
    }

    public void setHighlightPic(String highlightPic) {
        this.highlightPic = highlightPic;
    }

    public String getHighlighText() {
        return highlighText;
    }

    public void setHighlighText(String highlighText) {
        this.highlighText = highlighText;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getUpdater() {
        return updater;
    }

    public void setUpdater(String updater) {
        this.updater = updater;
    }

    public String getUpdateDatetime() {
        return updateDatetime;
    }

    public void setUpdateDatetime(String updateDatetime) {
        this.updateDatetime = updateDatetime;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
