/**
 * @Title ERepairOrderStatus.java 
 * @Package com.xnjr.mall.enums 
 * @Description 
 * @author haiqingzheng  
 * @date 2016年5月31日 下午3:22:41 
 * @version V1.0   
 */
package com.xnjr.mall.enums;

/** 
 * @author: haiqingzheng 
 * @since: 2016年5月31日 下午3:22:41 
 * @history:
 */
public enum ERepairOrderStatus {
    NEW("1", "待处理"), PROCESSING("2", "已受理"), CLOSED("3", "已关闭");

    ERepairOrderStatus(String code, String value) {
        this.code = code;
        this.value = value;
    }

    private String code;

    private String value;

    public String getCode() {
        return code;
    }

    public String getValue() {
        return value;
    }
}
