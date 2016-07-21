package com.xnjr.mall.dto.req;

/**
 * 货订单列表
 * @author: xieyj 
 * @since: 2016年7月21日 下午2:26:24 
 * @history:
 */
public class XN602123Req {
    // 编号
    private String code;

    // 货品编号
    private String goodsCode;

    // 状态
    private String status;

    // 申请人
    private String applyUser;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getGoodsCode() {
        return goodsCode;
    }

    public void setGoodsCode(String goodsCode) {
        this.goodsCode = goodsCode;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getApplyUser() {
        return applyUser;
    }

    public void setApplyUser(String applyUser) {
        this.applyUser = applyUser;
    }
}
