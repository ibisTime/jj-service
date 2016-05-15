/**
 * @Title EBizType.java 
 * @Package com.ibis.account.enums 
 * @Description 
 * @author miyb  
 * @date 2015-2-26 下午2:15:22 
 * @version V1.0   
 */
package com.xnjr.mall.enums;

import java.util.HashMap;
import java.util.Map;

/** 
 * @author: miyb 
 * @since: 2015-2-26 下午2:15:22 
 * @history:
 */
public enum EBizType {
    AJ_CZ("11", "充值"), AJ_QX("-11", "取现"), AJ_XXDK("12", "线下打款"), AJ_RG("-12",
            "认购"), AJ_JD("13", "解冻"), AJ_DJ("-13", "冻结"), AJ_XSHK("14", "线上还款"), AJ_XXJS(
            "-14", "线下结算"), AJ_LB("19", "蓝补"), AJ_HC("-19", "红冲");
    public static Map<String, EBizType> getBizTypeMap() {
        Map<String, EBizType> map = new HashMap<String, EBizType>();
        for (EBizType bizType : EBizType.values()) {
            map.put(bizType.getCode(), bizType);
        }
        return map;
    }

    EBizType(String code, String value) {
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
