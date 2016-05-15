/**
 * @Title XN803544Res.java 
 * @Package com.xnjr.moom.dto.res 
 * @Description 
 * @author haiqingzheng  
 * @date 2016年3月4日 下午10:04:12 
 * @version V1.0   
 */
package com.xnjr.mall.dto.res;

/** 
 * @author: haiqingzheng 
 * @since: 2016年3月4日 下午10:04:12 
 * @history:
 */
public class XNpt2001Res {
    // 是否成功
    private boolean isSuccess;

    public XNpt2001Res() {
    }

    public XNpt2001Res(boolean isSuccess) {
        this.isSuccess = isSuccess;
    }

    public boolean getIsSuccess() {
        return isSuccess;
    }

    public void setIsSuccess(boolean isSuccess) {
        this.isSuccess = isSuccess;
    }
}
