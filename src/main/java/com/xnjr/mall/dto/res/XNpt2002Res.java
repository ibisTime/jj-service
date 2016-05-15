/**
 * @Title XN803543Res.java 
 * @Package com.xnjr.moom.dto.res 
 * @Description 
 * @author haiqingzheng  
 * @date 2016年3月4日 下午9:57:22 
 * @version V1.0   
 */
package com.xnjr.mall.dto.res;

/** 
 * @author: haiqingzheng 
 * @since: 2016年3月4日 下午9:57:22 
 * @history:
 */
public class XNpt2002Res {
    // 是否成功
    private boolean isSuccess;

    public XNpt2002Res() {
    }

    public XNpt2002Res(boolean isSuccess) {
        this.isSuccess = isSuccess;
    }

    public boolean getIsSuccess() {
        return isSuccess;
    }

    public void setIsSuccess(boolean isSuccess) {
        this.isSuccess = isSuccess;
    }
}
