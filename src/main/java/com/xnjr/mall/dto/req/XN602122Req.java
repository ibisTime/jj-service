package com.xnjr.mall.dto.req;

/**
 * 货订单分页
 * @author: xieyj 
 * @since: 2016年7月21日 下午2:26:37 
 * @history:
 */
public class XN602122Req extends APageReq {
    /** 
     * @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么) 
     */
    private static final long serialVersionUID = 1L;

    // 编号(选填)
    private String code;

    // 货品编号(选填)
    private String goodsCode;

    // 状态(选填) 0 申请中 1 审核通过 2 审核不通过
    private String status;

    // 申请人(选填)
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
