/**
 * @Title EErrorCode.java 
 * @Package com.hsnet.pz.api.enums 
 * @Description 
 * @author miyb  
 * @date 2015-3-26 上午7:40:24 
 * @version V1.0   
 */
package com.cdkj.service.proxy;

/** 
 * @author: miyb 
 * @since: 2015-3-26 上午7:40:24 
 * @history:
 */
public enum EErrorCode {
    SUCCESS("0", "成功"), AUTH_ERR("1", "权限错误"), PARA_ERR("2", "参数错误"), BIZ_ERR(
            "3", "业务错误"), OTHER_ERR("9", "未知错误");
    EErrorCode(String code, String value) {
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
