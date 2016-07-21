package com.xnjr.mall.bo.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.xnjr.mall.bo.IGoodsOrderBO;
import com.xnjr.mall.bo.base.PaginableBOImpl;
import com.xnjr.mall.core.OrderNoGenerater;
import com.xnjr.mall.dao.IGoodsOrderDAO;
import com.xnjr.mall.domain.GoodsOrder;
import com.xnjr.mall.enums.ENormalStatus;

/** 
 * @author: zuixian 
 * @since: 2016年7月21日 上午10:06:44 
 * @history:
 */
@Component
public class GoodsOrderBOImpl extends PaginableBOImpl<GoodsOrder> implements
        IGoodsOrderBO {

    @Autowired
    private IGoodsOrderDAO goodsOrderDAO;

    @Override
    public boolean isInvoiceExist(String code) {
        GoodsOrder condition = new GoodsOrder();
        condition.setCode(code);
        if (goodsOrderDAO.selectTotalCount(condition) == 1) {
            return true;
        }
        return false;
    }

    @Override
    public String saveGoodsOrder(GoodsOrder data) {
        if (data != null) {
            data.setCode(OrderNoGenerater.generateM("GO"));
            data.setStatus(ENormalStatus.NEW.getCode());
            data.setApplyDatetime(new Date());
            goodsOrderDAO.insert(data);
        }
        return data.getCode();
    }

    @Override
    public int approveGoodsOrder(String code, String approveUser,
            String approveNote, ENormalStatus status) {
        GoodsOrder data = new GoodsOrder();
        data.setCode(code);
        data.setApproveUser(approveUser);
        data.setApproveNote(approveNote);
        data.setApproveDatetime(new Date());
        data.setStatus(status.getCode());
        return goodsOrderDAO.updateGoodsOrderApprove(data);
    }

    @Override
    public GoodsOrder getGoodsOrder(String code) {
        GoodsOrder result = new GoodsOrder();
        if (code != null) {
            GoodsOrder condition = new GoodsOrder();
            condition.setCode(code);
            result = goodsOrderDAO.select(condition);
        }
        return result;
    }

    @Override
    public List<GoodsOrder> queryGoodsOrderList(GoodsOrder data) {
        return goodsOrderDAO.selectList(data);
    }
}
