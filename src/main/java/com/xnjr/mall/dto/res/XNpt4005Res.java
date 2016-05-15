/**
 * @Title XN803564Res.java 
 * @Package com.xnjr.moom.dto.res 
 * @Description 
 * @author xieyj  
 * @date 2016年3月6日 上午9:42:02 
 * @version V1.0   
 */
package com.xnjr.mall.dto.res;

/** 
 * @author: xieyj 
 * @since: 2016年3月6日 上午9:42:02 
 * @history:
 */
public class XNpt4005Res {
    // 是否成功
    private boolean isSuccess;

    public boolean isSuccess() {
        return isSuccess;
    }

    public void setSuccess(boolean isSuccess) {
        this.isSuccess = isSuccess;
    }

    public XNpt4005Res(int count) {
        if (count > 0) {
            this.isSuccess = true;
        } else {
            this.isSuccess = false;
        }
    }
}
