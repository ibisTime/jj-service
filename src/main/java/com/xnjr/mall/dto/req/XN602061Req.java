/**
 * @Title XN602061Req.java 
 * @Package com.xnjr.mall.dto.req 
 * @Description 
 * @author haiqingzheng  
 * @date 2016年5月29日 下午3:29:32 
 * @version V1.0   
 */
package com.xnjr.mall.dto.req;

/** 
 * @author: haiqingzheng 
 * @since: 2016年5月29日 下午3:29:32 
 * @history:
 */
public class XN602061Req extends APageReq {
    /** 
     * @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么) 
     */
    private static final long serialVersionUID = 2260452209702802925L;

    // 主键PK
    private String code;

    // 对应的型号编号
    private String modelCode;

    // 所属物流单号
    private String logisticsCode;

    // 所属用户ID
    private String userId;

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

    public String getLogisticsCode() {
        return logisticsCode;
    }

    public void setLogisticsCode(String logisticsCode) {
        this.logisticsCode = logisticsCode;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

}
