/**
 * @Title EDirection.java 
 * @Package com.ibis.account.enums 
 * @Description 
 * @author miyb  
 * @date 2015-2-26 下午3:37:06 
 * @version V1.0   
 */
package com.xnjr.mall.enums;

import java.util.HashMap;
import java.util.Map;

/** 
 * @author: miyb 
 * @since: 2015-2-26 下午3:37:06 
 * @history:
 */
public enum EDirection {
    PLUS("1", "加钱"), MINUS("0", "减钱");
    public static Map<String, EDirection> getDirectionMap() {
        Map<String, EDirection> map = new HashMap<String, EDirection>();
        for (EDirection direction : EDirection.values()) {
            map.put(direction.getCode(), direction);
        }
        return map;
    }

    EDirection(String code, String value) {
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
