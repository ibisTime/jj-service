package com.xnjr.mall.dto.req;

/**
 * @author: xieyj 
 * @since: 2016年5月23日 上午8:53:02 
 * @history:
 */
public class XN601025Req {
    // 编号（选填）
    private String code;

    // 名称（选填）
    private String name;

    // 状态（选填）
    private String status;

    // 产品编号（选填）
    private String productCode;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }
}
