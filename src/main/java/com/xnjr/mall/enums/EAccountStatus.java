/**
 * @Title EAccountState.java 
 * @Package com.ibis.account.enums 
 * @Description 
 * @author miyb  
 * @date 2015-2-26 下午2:42:59 
 * @version V1.0   
 */
package com.xnjr.mall.enums;

/** 
 * @author: miyb 
 * @since: 2015-2-26 下午2:42:59 
 * @history:
 */
public enum EAccountStatus {
    NORMAL("0", "正常"), LI_LOCK("1", "程序锁定"), RG_LOCK("2", "人工锁定");

    EAccountStatus(String code, String value) {
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
