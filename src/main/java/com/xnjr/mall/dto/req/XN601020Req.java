package com.xnjr.mall.dto.req;

import java.util.List;

import com.xnjr.mall.domain.ModelSpecs;

/**
 * @author: xieyj 
 * @since: 2016年5月23日 上午8:46:53 
 * @history:
 */
public class XN601020Req {

    // 名称（必填）
    private String name;

    // pic1（必填）
    private String pic1;

    // pic2（必填）
    private String pic2;

    // pic3（必填）
    private String pic3;

    // 状态（必填）
    private String status;

    // 描述（必填）
    private String description;

    // 产品编号（必填）
    private String productCode;

    // 模型参数列表（必填）
    private List<ModelSpecs> modelSpecsList;

    // 更新人（必填）
    private String updater;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPic1() {
        return pic1;
    }

    public void setPic1(String pic1) {
        this.pic1 = pic1;
    }

    public String getPic2() {
        return pic2;
    }

    public void setPic2(String pic2) {
        this.pic2 = pic2;
    }

    public String getPic3() {
        return pic3;
    }

    public void setPic3(String pic3) {
        this.pic3 = pic3;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public List<ModelSpecs> getModelSpecsList() {
        return modelSpecsList;
    }

    public void setModelSpecsList(List<ModelSpecs> modelSpecsList) {
        this.modelSpecsList = modelSpecsList;
    }

    public String getUpdater() {
        return updater;
    }

    public void setUpdater(String updater) {
        this.updater = updater;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
