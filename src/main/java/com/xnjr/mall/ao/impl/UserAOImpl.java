/**
 * @Title UserAOImpl.java 
 * @Package com.xnjr.mall.ao.impl 
 * @Description 
 * @author xieyj  
 * @date 2016年7月26日 下午12:32:53 
 * @version V1.0   
 */
package com.xnjr.mall.ao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xnjr.mall.ao.IUserAO;
import com.xnjr.mall.bo.IBuyGuideBO;
import com.xnjr.mall.bo.IModelBO;
import com.xnjr.mall.bo.ISaleGuideBO;
import com.xnjr.mall.bo.IUserBO;
import com.xnjr.mall.domain.BuyGuide;
import com.xnjr.mall.domain.Model;
import com.xnjr.mall.dto.req.XN805042Req;
import com.xnjr.mall.enums.EBoolean;
import com.xnjr.mall.enums.EUserKind;
import com.xnjr.mall.enums.EUserLevel;

/** 
 * 用户AO
 * @author: xieyj 
 * @since: 2016年7月26日 下午12:32:53 
 * @history:
 */
@Service
public class UserAOImpl implements IUserAO {

    @Autowired
    IUserBO userBO;

    @Autowired
    ISaleGuideBO saleGuideBO;

    @Autowired
    IBuyGuideBO buyGuideBO;

    @Autowired
    IModelBO modelBO;

    @Override
    public String doAddZdUser(XN805042Req data) {
        // 设置更新人为推荐人
        data.setUpdater(data.getUserReferee());
        // 设置积分商身份
        data.setKind(EUserKind.F1.getCode());
        return userBO.doSaveUser(data);
    }

    @Override
    public String doAddJfUser(XN805042Req data) {
        // 设置更新人为推荐人
        data.setUpdater(data.getUserReferee());
        // 设置积分商身份
        data.setKind(EUserKind.Integral.getCode());
        return userBO.doSaveUser(data);
    }

    @Override
    public String doAddHpUser(XN805042Req data) {
        // 设置更新人为推荐人
        data.setUpdater(data.getUserReferee());
        // 设置货品商身份
        data.setKind(EUserKind.Goods.getCode());
        String userId = userBO.doSaveUser(data);
        Model condition = new Model();
        List<Model> list = modelBO.queryModelList(condition);
        BuyGuide buyGuide = new BuyGuide();
        for (Model model : list) {
            buyGuide.setModelCode(model.getCode());
            buyGuide.setFromUser(userId);
            buyGuide.setFromQuantity("0");
            buyGuide.setStatus(EBoolean.NO.getCode());
            Long price = saleGuideBO.getSaleGuide(model.getCode(),
                EUserLevel.ZERO, Long.valueOf(buyGuide.getFromQuantity()))
                .getPrice();
            if (price != null) {
                buyGuide.setCostPrice(price);
            }
            buyGuideBO.saveBuyGuide(buyGuide);
        }
        return userId;
    }

    @Override
    public String doAddJmsUser(XN805042Req data) {
        // 设置更新人为推荐人
        data.setUpdater(data.getUserReferee());
        // 设置货品商身份
        data.setKind(EUserKind.CaiGo.getCode());
        String userId = userBO.doSaveUser(data);
        Model condition = new Model();
        List<Model> list = modelBO.queryModelList(condition);
        BuyGuide buyGuide = new BuyGuide();
        for (Model model : list) {
            buyGuide.setModelCode(model.getCode());
            buyGuide.setFromUser(userId);
            buyGuide.setFromQuantity("0");
            buyGuide.setStatus(EBoolean.NO.getCode());
            Long price = saleGuideBO.getSaleGuide(model.getCode(),
                EUserLevel.ZERO, Long.valueOf(buyGuide.getFromQuantity()))
                .getPrice();
            if (price != null) {
                buyGuide.setCostPrice(price);
            }
            buyGuideBO.saveBuyGuide(buyGuide);
        }
        return userId;
    }
}
