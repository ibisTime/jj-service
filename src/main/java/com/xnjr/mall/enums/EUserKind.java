/**
 * @Title UserKind.java 
 * @Package com.ibis.pz.enums 
 * @Description 
 * @author miyb  
 * @date 2015-3-7 上午8:51:05 
 * @version V1.0   
 */
package com.xnjr.mall.enums;

/** 
 * @author: miyb 
 * @since: 2015-3-7 上午8:51:05 
 * @history:
 */
public enum EUserKind {
    F1("f1", "终端客户"), F2("f2", "渠道商"), Operator("01", "平台运营商"), Integral("02",
            "积分商"), Goods("03", "货品商"), CaiGo("05", "菜狗顶级货品商和积分商");

    EUserKind(String code, String value) {
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
