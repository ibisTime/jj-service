/**
 * @Title UserAOImpl.java 
 * @Package com.xnjr.mall.ao.impl 
 * @Description 
 * @author xieyj  
 * @date 2016年7月26日 下午12:32:53 
 * @version V1.0   
 */
package com.xnjr.mall.ao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xnjr.mall.ao.IUserAO;
import com.xnjr.mall.bo.ISaleGuideBO;
import com.xnjr.mall.bo.IUserBO;
import com.xnjr.mall.dto.req.XN805042Req;
import com.xnjr.mall.enums.EUserKind;

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

    /** 
     * @see com.xnjr.mall.ao.IUserAO#doAddJfUser(com.xnjr.mall.domain.User)
     */
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
        // TODO
        // 未自动添加仓库
        // 设置更新人为推荐人
        data.setUpdater(data.getUserReferee());
        // 设置积分商身份
        data.setKind(EUserKind.Goods.getCode());
        return userBO.doSaveUser(data);
    }
}
