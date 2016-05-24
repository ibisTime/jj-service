package com.xnjr.mall.dto.req;

/** 
 * @author: xieyj 
 * @since: 2016年5月24日 上午9:13:00 
 * @history:
 */
public class XN601043Req {
    // 编号（选填）
    private String code;

    // 型号编号（选填）
    private String modelCode;

    // 受众（选填）
    private String toLevel;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

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
}
