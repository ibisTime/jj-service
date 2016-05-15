/**
 * @Title XNbk2012Res.java 
 * @Package com.xnjr.moom.dto.res 
 * @Description 
 * @author haiqingzheng  
 * @date 2016年3月5日 下午4:42:47 
 * @version V1.0   
 */
package com.xnjr.mall.dto.res;

/** 
 * @author: haiqingzheng 
 * @since: 2016年3月5日 下午4:42:47 
 * @history:
 */
public class XNbk2012Res {
    // 是否成功
    private boolean isSuccess;

    public XNbk2012Res() {
    }

    public XNbk2012Res(boolean isSuccess) {
        this.isSuccess = isSuccess;
    }

    public boolean getIsSuccess() {
        return isSuccess;
    }

    public void setIsSuccess(boolean isSuccess) {
        this.isSuccess = isSuccess;
    }
}
