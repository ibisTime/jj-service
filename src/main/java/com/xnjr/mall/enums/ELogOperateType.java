/**
 * @Title EOperateType.java 
 * @Package com.xnjr.moom.enums 
 * @Description 
 * @author haiqingzheng  
 * @date 2016年4月16日 下午8:55:06 
 * @version V1.0   
 */
package com.xnjr.mall.enums;

/** 
 * @author: haiqingzheng 
 * @since: 2016年4月16日 下午8:55:06 
 * @history:
 */
public enum ELogOperateType {
    INSERT("1", "增加"), DELETE("2", "删除"), UPDATE("3", "修改"), LOGIN("4", "登录");

    ELogOperateType(String code, String value) {
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
