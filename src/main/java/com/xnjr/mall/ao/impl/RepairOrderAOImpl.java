/**
 * @Title RepairOrderAOImpl.java 
 * @Package com.xnjr.mall.ao.impl 
 * @Description 
 * @author haiqingzheng  
 * @date 2016年5月31日 下午4:01:23 
 * @version V1.0   
 */
package com.xnjr.mall.ao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xnjr.mall.ao.IRepairOrderAO;
import com.xnjr.mall.bo.IGoodsBO;
import com.xnjr.mall.bo.IModelBO;
import com.xnjr.mall.bo.IProductBO;
import com.xnjr.mall.bo.IRepairOrderBO;
import com.xnjr.mall.bo.base.Paginable;
import com.xnjr.mall.domain.Goods;
import com.xnjr.mall.domain.Model;
import com.xnjr.mall.domain.Product;
import com.xnjr.mall.domain.RepairOrder;
import com.xnjr.mall.enums.EBoolean;
import com.xnjr.mall.enums.ERepairOrderStatus;
import com.xnjr.mall.exception.BizException;

/** 
 * @author: haiqingzheng 
 * @since: 2016年5月31日 下午4:01:23 
 * @history:
 */
@Service
public class RepairOrderAOImpl implements IRepairOrderAO {

    @Autowired
    IRepairOrderBO repairOrderBO;

    @Autowired
    IGoodsBO goodsBO;

    @Autowired
    IModelBO modelBO;

    @Autowired
    IProductBO productBO;

    /** 
     * @see com.xnjr.mall.ao.IRepairOrderAO#addRepairOrder(com.xnjr.mall.domain.RepairOrder)
     */
    @Override
    public String addRepairOrder(RepairOrder data) {
        Goods goods = goodsBO.getGoods(data.getGoodsCode());
        Model model = modelBO.getModel(goods.getModelCode());
        Product product = productBO.getProduct(model.getProductCode());
        data.setModelName(model.getName());
        data.setProductName(product.getName());
        if (!goods.getUserId().equals(data.getUserId())) {
            throw new BizException("xn000000", "该用户不是货的拥有者！");
        }
        RepairOrder condition = new RepairOrder();
        condition.setGoodsCode(data.getGoodsCode());
        condition.setStatus(ERepairOrderStatus.NEW.getCode());
        if (repairOrderBO.getTotalCount(condition) > 0) {
            throw new BizException("xn000000", "您已经提交了维修单，客服会联系您，请耐心等待处理！");
        }
        return repairOrderBO.saveRepairOrder(data);
    }

    /** 
     * @see com.xnjr.mall.ao.IRepairOrderAO#queryRepairOrderPage(int, int, com.xnjr.mall.domain.RepairOrder)
     */
    @Override
    public Paginable<RepairOrder> queryRepairOrderPage(int start, int limit,
            RepairOrder condition) {
        return repairOrderBO.getPaginable(start, limit, condition);
    }

    /** 
     * @see com.xnjr.mall.ao.IRepairOrderAO#getRepairOrder(java.lang.String)
     */
    @Override
    public RepairOrder getRepairOrder(String code) {
        return repairOrderBO.getRepairOrder(code);
    }

    /** 
     * @see com.xnjr.mall.ao.IRepairOrderAO#dealWithRepairOrder(java.lang.String, java.lang.String, java.lang.String, java.lang.String)
     */
    @Override
    public int dealWithRepairOrder(String code, String checkResult,
            String checkUser, String remark) {
        int count = 0;
        RepairOrder repairOrder = repairOrderBO.getRepairOrder(code);
        if (!ERepairOrderStatus.NEW.getCode().equalsIgnoreCase(
            repairOrder.getStatus())) {
            throw new BizException("xn000000", "维修单号不处于待处理状态");
        }
        if (EBoolean.YES.getCode().equalsIgnoreCase(checkResult)) {
            count = repairOrderBO.refreshStatus(code,
                ERepairOrderStatus.PROCESSING.getCode(), checkUser, remark);
        } else if (EBoolean.NO.getCode().equalsIgnoreCase(checkResult)) {
            count = repairOrderBO.refreshStatus(code,
                ERepairOrderStatus.CLOSED.getCode(), checkUser, remark);
        } else {
            throw new BizException("xn000000", "审核结果传值不正确");
        }
        return count;
    }

}
