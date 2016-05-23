/**
 * @Title EProductStatus.java 
 * @Package com.xnjr.mall.enums 
 * @Description 
 * @author haiqingzheng  
 * @date 2016年5月17日 上午10:36:47 
 * @version V1.0   
 */
package com.xnjr.mall.enums;

/** 
 * @author: haiqingzheng 
 * @since: 2016年5月17日 上午10:36:47 
 * @history:
 */
public enum EPutStatus {
    todoAPPROVE("0", "待审核"), APPROVE_YES("1", "审核已通过"), APPROVE_NO("2",
            "初审不通过，进入可重提状态"), ONLINE("3", "已上架"), OFFLINE("4", "已下架");

    EPutStatus(String code, String value) {
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
