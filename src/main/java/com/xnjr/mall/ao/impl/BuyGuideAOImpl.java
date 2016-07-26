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

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xnjr.mall.ao.IBuyGuideAO;
import com.xnjr.mall.bo.IBuyGuideBO;
import com.xnjr.mall.bo.IModelBO;
import com.xnjr.mall.bo.IModelSpecsBO;
import com.xnjr.mall.bo.base.Paginable;
import com.xnjr.mall.domain.BuyGuide;
import com.xnjr.mall.domain.Model;
import com.xnjr.mall.domain.ModelSpecs;
import com.xnjr.mall.enums.EPutStatus;
import com.xnjr.mall.enums.ETypeStatus;
import com.xnjr.mall.enums.EUserLevel;
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

    @Autowired
    private IModelSpecsBO modelSpecsBO;

    /** 
     * @see com.xnjr.mall.ao.IBuyGuideAO#addBuyGuide(com.xnjr.mall.domain.BuyGuide)
     */
    @Override
    public String addBuyGuide(BuyGuide data) {
        String result = null;
        BuyGuide condition = new BuyGuide();
        condition.setModelCode(data.getModelCode());
        List<BuyGuide> list = buyGuideBO.queryBuyGuideList(condition);
        // 设置状态为启用
        data.setStatus(ETypeStatus.ONLINE.getCode());
        // 默认等级设置
        if (StringUtils.isBlank(data.getToLevel())) {
            data.setToLevel(EUserLevel.ZERO.getCode());
        }
        // 设置默认折扣价
        if (data.getDiscountPrice() == null || data.getDiscountPrice() == 0) {
            data.setDiscountPrice(data.getOriginalPrice());
        }
        if (!CollectionUtils.sizeIsEmpty(list)) {
            BuyGuide buyGuide = list.get(0);
            data.setCode(buyGuide.getCode());
            buyGuideBO.refreshBuyGuide(data);
            result = data.getCode();
        } else {
            result = buyGuideBO.saveBuyGuide(data);
        }
        return result;
    }

    public int offBuyGuide(BuyGuide data) {
        data.setStatus(ETypeStatus.OFFLINE.getCode());
        return buyGuideBO.refreshBuyGuideStatus(data);
    }

    /** 
     * @see com.xnjr.mall.ao.IBuyGuideAO#editBuyGuide(com.xnjr.mall.domain.BuyGuide)
     */
    @Override
    public int editBuyGuide(BuyGuide data) {
        Model model = modelBO.getModel(data.getModelCode());
        // 默认等级设置
        if (StringUtils.isBlank(data.getToLevel())) {
            data.setToLevel(EUserLevel.ZERO.getCode());
        }
        // 设置默认折扣价
        if (data.getDiscountPrice() == null || data.getDiscountPrice() == 0) {
            data.setDiscountPrice(data.getOriginalPrice());
        }
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
        List<BuyGuide> list = buyGuideBO.queryBuyGuideList(condition);
        for (BuyGuide buyGuide : list) {
            addModelAndSpecs(buyGuide);
        }
        return list;
    }

    private void addModelAndSpecs(BuyGuide buyGuide) {
        Model model = modelBO.getModel(buyGuide.getModelCode());
        buyGuide.setModel(model);
        ModelSpecs msCondition = new ModelSpecs();
        msCondition.setModelCode(model.getCode());
        List<ModelSpecs> modelSpecsList = modelSpecsBO
            .queryModelSpecsList(msCondition);
        buyGuide.setModelSpecsList(modelSpecsList);
    }

    /** 
     * @see com.xnjr.mall.ao.IBuyGuideAO#queryBuyGuidePage(int, int, com.xnjr.mall.domain.BuyGuide)
     */
    @Override
    public Paginable<BuyGuide> queryBuyGuidePage(int start, int limit,
            BuyGuide condition) {
        Paginable<BuyGuide> page = buyGuideBO.getPaginable(start, limit,
            condition);
        if (page != null && page.getList() != null) {
            for (BuyGuide buyGuide : page.getList()) {
                addModelAndSpecs(buyGuide);
            }
        }
        return page;
    }

    /** 
     * @see com.xnjr.mall.ao.IBuyGuideAO#getBuyGuide(java.lang.String)
     */
    @Override
    public BuyGuide getBuyGuide(String code) {
        BuyGuide buyGuide = buyGuideBO.getBuyGuide(code);
        if (buyGuide != null) {
            addModelAndSpecs(buyGuide);
        }
        return buyGuide;
    }
}
