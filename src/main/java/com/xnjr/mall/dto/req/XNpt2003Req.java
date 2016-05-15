/**
 * @Title XNpt2003Req.java 
 * @Package com.xnjr.moom.dto.req 
 * @Description 
 * @author haiqingzheng  
 * @date 2016年3月4日 下午10:13:32 
 * @version V1.0   
 */
package com.xnjr.mall.dto.req;

/** 
 * @author: haiqingzheng 
 * @since: 2016年3月4日 下午10:13:32 
 * @history:
 */
public class XNpt2003Req extends APageReq {
    /** 
     * @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么) 
     */
    private static final long serialVersionUID = -7119085573189476697L;

    // 公司编号（选填）
    private String code;

    // 公司名称（选填）
    private String zwName;

    // 公司名称（选填）
    private String ywName;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getZwName() {
        return zwName;
    }

    public void setZwName(String zwName) {
        this.zwName = zwName;
    }

    public String getYwName() {
        return ywName;
    }

    public void setYwName(String ywName) {
        this.ywName = ywName;
    }

}
