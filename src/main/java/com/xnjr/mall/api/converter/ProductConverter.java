package com.xnjr.mall.api.converter;

import com.xnjr.mall.domain.Product;
import com.xnjr.mall.dto.req.XN601000Req;
import com.xnjr.mall.dto.req.XN601001Req;

public class ProductConverter {
    // 新增
    public static Product converter(XN601000Req req) {
        Product data = new Product();
        data.setCategory(req.getCategory());
        data.setType(req.getType());
        data.setTypePic(req.getTypePic());
        data.setName(req.getName());
        data.setOrderNo(req.getOrderNo());
        data.setStatus(req.getStatus());
        data.setAdvTitle(req.getAdvTitle());
        data.setAdvPic(req.getAdvPic());
        data.setMajorPic(req.getMajorPic());
        data.setMajorText(req.getMajorText());
        data.setFamilyPic(req.getFamilyPic());
        data.setFamilyText(req.getFamilyText());
        data.setHighlightPic(data.getHighlightPic());
        data.setHighlightText(req.getHighlightText());
        data.setUpdater(req.getUpdater());
        return data;
    }

    // 修改
    public static Product converter(XN601001Req req) {
        Product data = new Product();
        data.setCode(req.getCode());
        data.setCategory(req.getCategory());
        data.setType(req.getType());
        data.setTypePic(req.getTypePic());
        data.setName(req.getName());
        data.setOrderNo(req.getOrderNo());
        data.setStatus(req.getStatus());
        data.setAdvTitle(req.getAdvTitle());
        data.setAdvPic(req.getAdvPic());
        data.setMajorPic(req.getMajorPic());
        data.setMajorText(req.getMajorText());
        data.setFamilyPic(req.getFamilyPic());
        data.setFamilyText(req.getFamilyText());
        data.setHighlightPic(req.getHighlightPic());
        data.setHighlightText(req.getHighlightText());
        data.setUpdater(req.getUpdater());
        data.setRemark(req.getRemark());
        return data;
    }
}
