/**
 * @Title XNpt0000Res.java 
 * @Package com.xnjr.moom.dto.res 
 * @Description 
 * @author haiqingzheng  
 * @date 2016年3月4日 下午10:39:51 
 * @version V1.0   
 */
package com.xnjr.mall.dto.res;

/** 
 * @author: haiqingzheng 
 * @since: 2016年3月4日 下午10:39:51 
 * @history:
 */
public class XNpt0000Res {
    private String userId;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public XNpt0000Res(String userId) {
        super();
        this.userId = userId;
    }
}
