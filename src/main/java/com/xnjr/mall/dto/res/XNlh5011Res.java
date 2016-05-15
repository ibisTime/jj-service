/**
 * @Title XNlh5011Res.java 
 * @Package com.xnjr.moom.dto.res 
 * @Description 
 * @author haiqingzheng  
 * @date 2016年4月17日 下午6:38:46 
 * @version V1.0   
 */
package com.xnjr.mall.dto.res;

/** 
 * @author: haiqingzheng 
 * @since: 2016年4月17日 下午6:38:46 
 * @history:
 */
public class XNlh5011Res {
    // 是否成功
    private boolean isSuccess;

    public XNlh5011Res(boolean isSuccess) {
        super();
        this.isSuccess = isSuccess;
    }

    public boolean getIsSuccess() {
        return isSuccess;
    }

    public void setIsSuccess(boolean isSuccess) {
        this.isSuccess = isSuccess;
    }
}
