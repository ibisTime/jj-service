package com.xnjr.mall.ao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xnjr.mall.ao.IGoodsOrderAO;
import com.xnjr.mall.bo.IGoodsOrderBO;
import com.xnjr.mall.bo.base.Paginable;
import com.xnjr.mall.domain.GoodsOrder;
import com.xnjr.mall.enums.EBoolean;
import com.xnjr.mall.enums.ENormalStatus;

@Service
public class GoodsOrderAOImpl implements IGoodsOrderAO {

    @Autowired
    private IGoodsOrderBO goodsOrderBO;

    @Override
    public String doApplyGoodsOrder(GoodsOrder data) {
        return goodsOrderBO.saveGoodsOrder(data);
    }

    @Override
    public int approveGoodsOrder(String code, String approveUser,
            String approveNote, EBoolean eboolean) {
        ENormalStatus status = null;
        if (EBoolean.YES.getCode().equalsIgnoreCase(eboolean.getCode())) {
            status = ENormalStatus.PASS;
        } else {
            status = ENormalStatus.UNPASS;
        }
        return goodsOrderBO.approveGoodsOrder(code, approveUser, approveNote,
            status);
    }

    @Override
    public GoodsOrder getGoodsOrder(String code) {
        return goodsOrderBO.getGoodsOrder(code);
    }

    @Override
    public List<GoodsOrder> queryGoodsOrderList(GoodsOrder condition) {
        return goodsOrderBO.queryGoodsOrderList(condition);
    }

    @Override
    public Paginable<GoodsOrder> queryGoodsOrderPage(int start, int limit,
            GoodsOrder condition) {
        return goodsOrderBO.getPaginable(start, limit, condition);
    }

}
