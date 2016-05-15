/**
 * @Title XNpt4004Res.java 
 * @Package com.xnjr.moom.dto.res 
 * @Description 
 * @author haiqingzheng  
 * @date 2016年4月15日 下午2:21:57 
 * @version V1.0   
 */
package com.xnjr.mall.dto.res;

/** 
 * @author: haiqingzheng 
 * @since: 2016年4月15日 下午2:21:57 
 * @history:
 */
public class XNpt4004Res {
    // 是否成功
    private boolean isSuccess;

    public boolean isSuccess() {
        return isSuccess;
    }

    public void setSuccess(boolean isSuccess) {
        this.isSuccess = isSuccess;
    }

    public XNpt4004Res(int count) {
        if (count > 0) {
            this.isSuccess = true;
        } else {
            this.isSuccess = false;
        }
    }
}
