package com.xnjr.mall.dto.req;

public class XNlh5032Req extends APageReq {

    /** 
     * @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么) 
     */
    private static final long serialVersionUID = 1L;

    // key值(选填)
    private String ckey;

    // 兑换汇率标志(选填) notIn 查询不包括汇率的 in 查询只有汇率 什么都不传查所有
    private String dhhlFlag;

    public String getCkey() {
        return ckey;
    }

    public void setCkey(String ckey) {
        this.ckey = ckey;
    }

    public String getDhhlFlag() {
        return dhhlFlag;
    }

    public void setDhhlFlag(String dhhlFlag) {
        this.dhhlFlag = dhhlFlag;
    }
}
