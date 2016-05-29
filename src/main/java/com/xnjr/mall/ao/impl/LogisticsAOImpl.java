/**
 * @Title LogisticsAOImpl.java 
 * @Package com.xnjr.mall.ao.impl 
 * @Description 
 * @author haiqingzheng  
 * @date 2016年5月29日 下午1:46:48 
 * @version V1.0   
 */
package com.xnjr.mall.ao.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xnjr.mall.ao.ILogisticsAO;
import com.xnjr.mall.bo.IGoodsBO;
import com.xnjr.mall.bo.IInvoiceBO;
import com.xnjr.mall.bo.ILogisticsBO;
import com.xnjr.mall.bo.IModelBO;
import com.xnjr.mall.bo.base.Paginable;
import com.xnjr.mall.domain.Goods;
import com.xnjr.mall.domain.Invoice;
import com.xnjr.mall.domain.Logistics;
import com.xnjr.mall.exception.BizException;

/** 
 * @author: haiqingzheng 
 * @since: 2016年5月29日 下午1:46:48 
 * @history:
 */
@Service
public class LogisticsAOImpl implements ILogisticsAO {

    @Autowired
    ILogisticsBO logisticsBO;

    @Autowired
    IGoodsBO goodsBO;

    @Autowired
    IModelBO modelBO;

    @Autowired
    IInvoiceBO invoiceBO;

    /** 
     * @see com.xnjr.mall.ao.ILogisticsAO#addLogistics(com.xnjr.mall.domain.Logistics, java.util.List)
     */
    @Override
    @Transactional
    public String addLogistics(Logistics logistics, List<Goods> goods) {
        // 保存物流单信息
        Invoice invoice = invoiceBO.getInvoice(logistics.getInvoiceCode());
        String code = logisticsBO.saveLogistics(logistics);
        // 记录改物流单已经添加的型号
        List<String> addedList = new ArrayList<String>();
        // 保存货品信息
        for (Goods item : goods) {
            // 判断型号有没有重复
            if (checkAdded(addedList, item.getModelCode())) {
                throw new BizException("xn000000", "相同型号的货不能添加多次");
            }
            addedList.add(item.getModelCode());
            // 添加N个货
            for (int i = 0; i < item.getQuantity(); i++) {
                if (!modelBO.isModelExist(item.getModelCode())) {
                    throw new BizException("xn000000", "型号编号不存在");
                }
                // 获取该型号最新的货编号
                Goods condition = new Goods();
                condition.setModelCode(item.getModelCode());
                Long count = goodsBO.getTotalCount(condition);
                // 保存货信息
                Goods newGoods = new Goods();
                newGoods.setCode(item.getModelCode() + "-" + (count + 1));
                newGoods.setCostPrice(item.getCostPrice());
                newGoods.setSalePrice(item.getSalePrice());
                newGoods.setModelCode(item.getModelCode());
                newGoods.setLogisticsCode(code);
                newGoods.setUserId(invoice.getApplyUser());
                goodsBO.saveGoods(newGoods);
            }
        }
        return code;
    }

    /** 
     * @see com.xnjr.mall.ao.ILogisticsAO#getLogistics(java.lang.String)
     */
    @Override
    public Logistics getLogistics(String code) {
        Logistics logistics = null;
        if (StringUtils.isNotBlank(code)) {
            logistics = logisticsBO.getLogistics(code);
            logistics.setGoodsList(goodsBO.queryGoodsInLogistics(code));
        }
        return logistics;
    }

    /** 
     * @see com.xnjr.mall.ao.ILogisticsAO#queryLogisticsPage(int, int, com.xnjr.mall.domain.Logistics)
     */
    @Override
    public Paginable<Logistics> queryLogisticsPage(int start, int limit,
            Logistics condition) {
        return logisticsBO.getPaginable(start, limit, condition);
    }

    private static boolean checkAdded(List<String> addedList, String modelCode) {
        for (String string : addedList) {
            if (string.equals(modelCode)) {
                return true;
            }
        }
        return false;
    }

}
