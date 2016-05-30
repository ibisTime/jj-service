package com.xnjr.mall.dto.req;

import java.util.List;

/** 
 * @author: xieyj 
 * @since: 2015年8月19日 下午7:41:26 
 * @history:
 */
public class XN602006Req {

    // 购物车列表
    private List<String> cartCodeList;

    public List<String> getCartCodeList() {
        return cartCodeList;
    }

    public void setCartCodeList(List<String> cartCodeList) {
        this.cartCodeList = cartCodeList;
    }
}
