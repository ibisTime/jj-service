/**
 * @Title BuyGuideAOImpl.java 
 * @Package com.xnjr.mall.ao.impl 
 * @Description 
 * @author xieyj  
 * @date 2016年5月24日 上午8:49:21 
 * @version V1.0   
 */
package com.xnjr.mall.ao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xnjr.mall.ao.IBuyGuideAO;
import com.xnjr.mall.bo.IBuyGuideBO;
import com.xnjr.mall.bo.IModelBO;
import com.xnjr.mall.bo.base.Paginable;
import com.xnjr.mall.domain.BuyGuide;
import com.xnjr.mall.domain.Model;
import com.xnjr.mall.enums.EPutStatus;
import com.xnjr.mall.exception.BizException;

/** 
 * @author: xieyj 
 * @since: 2016年5月24日 上午8:49:21 
 * @history:
 */
@Service
public class BuyGuideAOImpl implements IBuyGuideAO {
    @Autowired
    private IBuyGuideBO buyGuideBO;

    @Autowired
    private IModelBO modelBO;

    /** 
     * @see com.xnjr.mall.ao.IBuyGuideAO#addBuyGuide(com.xnjr.mall.domain.BuyGuide)
     */
    @Override
    public String addBuyGuide(BuyGuide data) {
        Model model = modelBO.getModel(data.getModelCode());
        if (!EPutStatus.ONLINE.getCode().equals(model.getStatus())) {
            throw new BizException("xn0000", "该型号不是已上架状态");
        }
        return buyGuideBO.saveBuyGuide(data);
    }

    /** 
     * @see com.xnjr.mall.ao.IBuyGuideAO#editBuyGuide(com.xnjr.mall.domain.BuyGuide)
     */
    @Override
    public int editBuyGuide(BuyGuide data) {
        Model model = modelBO.getModel(data.getModelCode());
        if (!EPutStatus.ONLINE.getCode().equals(model.getStatus())) {
            throw new BizException("xn0000", "该型号不是已上架状态");
        }
        if (!buyGuideBO.isBuyGuideExist(data.getCode())) {
            throw new BizException("xn0000", "购买引导编号不存在");
        }
        return buyGuideBO.refreshBuyGuide(data);
    }

    /** 
     * @see com.xnjr.mall.ao.IBuyGuideAO#queryBuyGuideList(com.xnjr.mall.domain.BuyGuide)
     */
    @Override
    public List<BuyGuide> queryBuyGuideList(BuyGuide condition) {
        return buyGuideBO.queryBuyGuideList(condition);
    }

    /** 
     * @see com.xnjr.mall.ao.IBuyGuideAO#queryBuyGuidePage(int, int, com.xnjr.mall.domain.BuyGuide)
     */
    @Override
    public Paginable<BuyGuide> queryBuyGuidePage(int start, int limit,
            BuyGuide condition) {
        return buyGuideBO.getPaginable(start, limit, condition);
    }

    /** 
     * @see com.xnjr.mall.ao.IBuyGuideAO#getBuyGuide(java.lang.String)
     */
    @Override
    public BuyGuide getBuyGuide(String code) {
        return buyGuideBO.getBuyGuide(code);
    }
}
