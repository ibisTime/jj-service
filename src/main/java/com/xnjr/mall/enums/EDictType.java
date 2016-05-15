/**
 * @Title EDictType.java 
 * @Package com.xnjr.moom.enums 
 * @Description 
 * @author haiqingzheng  
 * @date 2016年4月17日 下午5:15:02 
 * @version V1.0   
 */
package com.xnjr.mall.enums;

import java.util.HashMap;
import java.util.Map;

/** 
 * @author: haiqingzheng 
 * @since: 2016年4月17日 下午5:15:02 
 * @history:
 */
public enum EDictType {
    // 数据字典类型
    FIRST("0", "第一层"), SECOND("1", "第二层");

    public static Map<String, EDictType> getDictTypeMap() {
        Map<String, EDictType> map = new HashMap<String, EDictType>();
        for (EDictType dictType : EDictType.values()) {
            map.put(dictType.getCode(), dictType);
        }
        return map;
    }

    EDictType(String code, String value) {
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
