package com.xnjr.mall.dto.req;

/**
 * @author: xieyj 
 * @since: 2016年5月23日 上午8:53:02 
 * @history:
 */
public class XN601027Req extends APageReq {

    /** 
     * @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么) 
     */
    private static final long serialVersionUID = 1L;

    // 大类(选填)
    private String category;

    // 小类(选填)
    private String type;

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

}
