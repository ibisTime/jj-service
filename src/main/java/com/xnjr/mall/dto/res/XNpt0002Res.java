/**
 * @Title XNpt0002Res.java 
 * @Package com.xnjr.moom.dto.res 
 * @Description 
 * @author haiqingzheng  
 * @date 2016年3月4日 下午10:40:27 
 * @version V1.0   
 */
package com.xnjr.mall.dto.res;

/** 
 * @author: haiqingzheng 
 * @since: 2016年3月4日 下午10:40:27 
 * @history:
 */
public class XNpt0002Res {
    // 是否成功
    private boolean isSuccess;

    public XNpt0002Res() {
    }

    public XNpt0002Res(boolean isSuccess) {
        this.isSuccess = isSuccess;
    }

    public boolean getIsSuccess() {
        return isSuccess;
    }

    public void setIsSuccess(boolean isSuccess) {
        this.isSuccess = isSuccess;
    }
}
