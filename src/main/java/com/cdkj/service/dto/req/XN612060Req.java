package com.cdkj.service.dto.req;

/**
 * 分页查询公司
 * @author: asus 
 * @since: 2017年6月6日 上午10:11:43 
 * @history:
 */
public class XN612060Req extends APageReq {

    /** 
     * @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么) 
     */
    private static final long serialVersionUID = 1L;

    // 编号
    private String code;

    // 名称
    private String name;

    // 类型
    private String type;

    // UI位置
    private String location;

    // 省
    private String province;

    // 市
    private String city;

    // 区
    private String area;

    // 归属用户ID
    private String userId;

    // 热门度
    private String gzNum;

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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getGzNum() {
        return gzNum;
    }

    public void setGzNum(String gzNum) {
        this.gzNum = gzNum;
    }
}
