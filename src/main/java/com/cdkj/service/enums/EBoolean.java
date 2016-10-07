/**
 * @Title ECheckResult.java 
 * @Package com.ibis.account.enums 
 * @Description 
 * @author miyb  
 * @date 2015-2-26 下午2:58:54 
 * @version V1.0   
 */
package com.cdkj.service.enums;

import java.util.HashMap;
import java.util.Map;

/** 
 * @author: miyb 
 * @since: 2015-2-26 下午2:58:54 
 * @history:
 */
public enum EBoolean {
    YES("1", "对"), NO("0", "错");
    public static Map<String, EBoolean> getBooleanResultMap() {
        Map<String, EBoolean> map = new HashMap<String, EBoolean>();
        for (EBoolean status : EBoolean.values()) {
            map.put(status.getCode(), status);
        }
        return map;
    }

    EBoolean(String code, String value) {
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
