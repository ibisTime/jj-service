/**
 * @Title XN602601Req.java 
 * @Package com.xnjr.mall.dto.req 
 * @Description 
 * @author xieyj  
 * @date 2016年7月26日 上午11:39:26 
 * @version V1.0   
 */
package com.xnjr.mall.dto.req;

/** 
 * 终端入驻Req
 * @author: xieyj 
 * @since: 2016年7月26日 上午11:39:26 
 * @history:
 */
public class XN602601Req {

    // 手机号（必填）
    private String mobile;

    // 推荐人（必填）
    private String userReferee;

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getUserReferee() {
        return userReferee;
    }

    public void setUserReferee(String userReferee) {
        this.userReferee = userReferee;
    }
}
