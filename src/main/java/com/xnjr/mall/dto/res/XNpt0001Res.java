/**
 * @Title XN803547Res.java 
 * @Package com.xnjr.moom.dto.res 
 * @Description 
 * @author haiqingzheng  
 * @date 2016年3月4日 下午10:40:41 
 * @version V1.0   
 */
package com.xnjr.mall.dto.res;

/** 
 * @author: haiqingzheng 
 * @since: 2016年3月4日 下午10:40:41 
 * @history:
 */
public class XNpt0001Res {
    // 是否成功
    private boolean isSuccess;

    public XNpt0001Res() {
    }

    public XNpt0001Res(boolean isSuccess) {
        this.isSuccess = isSuccess;
    }

    public boolean getIsSuccess() {
        return isSuccess;
    }

    public void setIsSuccess(boolean isSuccess) {
        this.isSuccess = isSuccess;
    }
}
