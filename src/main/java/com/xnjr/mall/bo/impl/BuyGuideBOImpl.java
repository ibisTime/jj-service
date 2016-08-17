/**
 * @Title BuyGuideBOImpl.java 
 * @Package com.xnjr.mall.bo.impl 
 * @Description 
 * @author xieyj  
 * @date 2016年5月24日 上午8:26:36 
 * @version V1.0   
 */
package com.xnjr.mall.bo.impl;

import java.util.Date;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.xnjr.mall.bo.IBuyGuideBO;
import com.xnjr.mall.bo.base.PaginableBOImpl;
import com.xnjr.mall.core.EGeneratePrefix;
import com.xnjr.mall.core.OrderNoGenerater;
import com.xnjr.mall.dao.IBuyGuideDAO;
import com.xnjr.mall.domain.BuyGuide;
import com.xnjr.mall.enums.EBoolean;
import com.xnjr.mall.enums.EUser;
import com.xnjr.mall.exception.BizException;

/** 
 * @author: xieyj 
 * @since: 2016年5月24日 上午8:26:36 
 * @history:
 */
@Component
public class BuyGuideBOImpl extends PaginableBOImpl<BuyGuide> implements
        IBuyGuideBO {

    @Autowired
    private IBuyGuideDAO buyGuideDAO;

    /** 
     * @see com.xnjr.mall.bo.IBuyGuideBO#isBuyGuideExist(java.lang.String)
     */
    @Override
    public boolean isBuyGuideExist(String code) {
        BuyGuide condition = new BuyGuide();
        condition.setCode(code);
        if (buyGuideDAO.selectTotalCount(condition) == 1) {
            return true;
        }
        return false;
    }

    /** 
     * @see com.xnjr.mall.bo.IBuyGuideBO#saveBuyGuide(com.xnjr.mall.domain.BuyGuide)
     */
    @Override
    public String saveBuyGuide(BuyGuide data) {
        String code = null;
        if (data != null) {
            code = OrderNoGenerater.generateM(EGeneratePrefix.BG.getCode());
            data.setCode(code);
            data.setUpdateDatetime(new Date());
            buyGuideDAO.insert(data);
        }
        return code;
    }

    /** 
     * @see com.xnjr.mall.bo.IBuyGuideBO#deleteBuyGuide(java.lang.String)
     */
    @Override
    public int deleteBuyGuide(String code) {
        int count = 0;
        if (StringUtils.isNotBlank(code)) {
            BuyGuide data = new BuyGuide();
            data.setCode(code);
            count = buyGuideDAO.delete(data);
        }
        return count;
    }

    /** 
     * @see com.xnjr.mall.bo.IBuyGuideBO#refreshBuyGuide(com.xnjr.mall.domain.BuyGuide)
     */
    @Override
    public int refreshBuyGuide(BuyGuide data) {
        int count = 0;
        if (StringUtils.isNotBlank(data.getCode())) {
            data.setUpdateDatetime(new Date());
            count = buyGuideDAO.update(data);
        }
        return count;
    }

    /** 
     * @see com.xnjr.mall.bo.IBuyGuideBO#queryBuyGuideList(com.xnjr.mall.domain.BuyGuide)
     */
    @Override
    public List<BuyGuide> queryBuyGuideList(BuyGuide condition) {
        return buyGuideDAO.selectList(condition);
    }

    /** 
     * @see com.xnjr.mall.bo.IBuyGuideBO#getBuyGuide(java.lang.String)
     */
    @Override
    public BuyGuide getBuyGuide(String code) {
        BuyGuide data = null;
        if (StringUtils.isNotBlank(code)) {
            BuyGuide condition = new BuyGuide();
            condition.setCode(code);
            data = buyGuideDAO.select(condition);
            if (data == null) {
                throw new BizException("xn0000", "购买引导编号不存在");
            }
        }
        return data;
    }

    @Override
    public BuyGuide getOnlineModel(String modelCode, String level,
            String fromUser) {
        BuyGuide buyGuide = null;
        if (StringUtils.isNotBlank(modelCode) && StringUtils.isNotBlank(level)) {
            BuyGuide condition = new BuyGuide();
            condition.setModelCode(modelCode);
            condition.setToLevel(String.valueOf(level));
            condition.setFromUser(EUser.Top_Model.getCode());
            condition.setStatus(EBoolean.YES.getCode());
            List<BuyGuide> list = buyGuideDAO.selectList(condition);
            if (!CollectionUtils.sizeIsEmpty(list)) {
                buyGuide = list.get(0);
            }
        }
        return buyGuide;
    }

    @Override
    public BuyGuide getModel(String modelCode, String level, String fromUser) {
        BuyGuide buyGuide = null;
        if (StringUtils.isNotBlank(modelCode) && StringUtils.isNotBlank(level)) {
            BuyGuide condition = new BuyGuide();
            condition.setModelCode(modelCode);
            condition.setToLevel(String.valueOf(level));
            condition.setFromUser(EUser.Top_Model.getCode());
            List<BuyGuide> list = buyGuideDAO.selectList(condition);
            if (!CollectionUtils.sizeIsEmpty(list)) {
                buyGuide = list.get(0);
            }
        }
        return buyGuide;
    }

    @Override
    public int refreshBuyGuideStatus(BuyGuide data) {
        int count = 0;
        if (StringUtils.isNotBlank(data.getCode())) {
            data.setUpdateDatetime(new Date());
            count = buyGuideDAO.updateStatus(data);
        }
        return count;
    }

}
