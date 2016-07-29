package com.xnjr.mall.dto.req;

/**
 * 列表查询分销引导表Req
 * @author: xieyj 
 * @since: 2016年5月23日 上午8:46:53 
 * @history:
 */
public class XN602224Req {
    // 型号编号(必填)
    private String modelCode;

    // 用户等级(必填)
    private String toLevel;

    // 更新人(必填)
    private String updater;

    public String getModelCode() {
        return modelCode;
    }

    public void setModelCode(String modelCode) {
        this.modelCode = modelCode;
    }

    public String getToLevel() {
        return toLevel;
    }

    public void setToLevel(String toLevel) {
        this.toLevel = toLevel;
    }

    public String getUpdater() {
        return updater;
    }

    public void setUpdater(String updater) {
        this.updater = updater;
    }
}
