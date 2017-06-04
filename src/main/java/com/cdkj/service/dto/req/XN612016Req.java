package com.cdkj.service.dto.req;

/**
 * 列表查询资质
 * @author: asus 
 * @since: 2017年6月4日 下午4:16:52 
 * @history:
 */
public class XN612016Req extends APageReq {
    /** 
     * @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么) 
     */
    private static final long serialVersionUID = 1L;

    // 类型
    private String type;

    // 名称
    private String name;

    // 更新人
    private String updater;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUpdater() {
        return updater;
    }

    public void setUpdater(String updater) {
        this.updater = updater;
    }
}
