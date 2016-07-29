package com.xnjr.mall.api.converter;

import com.xnjr.mall.domain.SaleGuide;
import com.xnjr.mall.dto.req.XNlh5102Req;
import com.xnjr.mall.dto.req.XNlh5103Req;
import com.xnjr.mall.dto.req.XNlh5104Req;

public class SaleGuideConverter {

    // 修改
    public static SaleGuide converter(XNlh5102Req req) {
        SaleGuide data = new SaleGuide();
        data.setCode(req.getCode());
        data.setQuantity(Long.valueOf(req.getQuantity()));
        data.setPrice(Long.valueOf(req.getPrice()));
        data.setUpdater(req.getUpdater());
        data.setRemark(req.getRemark());
        return data;
    }

    // 分页查询
    public static SaleGuide converter(XNlh5103Req req) {
        SaleGuide data = new SaleGuide();
        data.setModelCode(req.getModelCode());
        data.setToLevel(req.getToLevel());
        data.setUpdater(req.getUpdater());
        return data;
    }

    // 列表查询
    public static SaleGuide converter(XNlh5104Req req) {
        SaleGuide data = new SaleGuide();
        data.setModelCode(req.getModelCode());
        data.setToLevel(req.getToLevel());
        data.setUpdater(req.getUpdater());
        return data;
    }
}
