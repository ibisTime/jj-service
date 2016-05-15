/**
 * @Title FDUserIdentifyBOImpl.java 
 * @Package com.ibis.pz.user.impl 
 * @Description 
 * @author luoqi  
 * @date 2015年3月8日 上午11:32:00 
 * @version V1.0   
 */
package com.xnjr.mall.bo.impl;

import java.util.Date;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.xnjr.mall.bo.IFDUserIdentifyBO;
import com.xnjr.mall.bo.base.PaginableBOImpl;
import com.xnjr.mall.common.DateUtil;
import com.xnjr.mall.dao.IFDUserIdentifyDAO;
import com.xnjr.mall.domain.FDUserIdentify;
import com.xnjr.mall.exception.BizException;

/** 
 * @author: luoqi 
 * @since: 2015年3月8日 上午11:32:00 
 * @history:
 */
@Component
public class FDUserIdentifyBOImpl extends PaginableBOImpl<FDUserIdentify>
        implements IFDUserIdentifyBO {
    @Autowired
    private IFDUserIdentifyDAO userIdentifyDAO;

    /** 
     * @see com.IFDFDUserIdentifyBO.pz.user.IFDUserIdentifyBO#saveUserIdentify(com.FDUserIdentify.pz.domain.FDUserIdentifyDO)
     */
    @Override
    public int saveUserIdentify(String userId, String realName, String idKind,
            String idcard, String errorCode, String errorInfo) {
        FDUserIdentify data = new FDUserIdentify();
        data.setUserId(userId);
        data.setRealName(realName);
        data.setIdKind(idKind);
        data.setIdNo(idcard);
        data.setErrorCode(errorCode);
        data.setErrorInfo(errorInfo);
        data.setCreateDatetime(new Date());
        int count = 0;
        if (data != null) {
            count = userIdentifyDAO.insert(data);
        }
        return count;
    }

    /** 
     * @see com.IFDFDUserIdentifyBO.pz.user.IFDUserIdentifyBO#queryUserIdentifyList(java.lang.String)
     */
    @Override
    public List<FDUserIdentify> queryUserIdentifyList(String userId) {
        List<FDUserIdentify> list = null;
        if (StringUtils.isNotBlank(userId)) {
            FDUserIdentify condition = new FDUserIdentify();
            condition.setUserId(userId);
            list = userIdentifyDAO.selectList(condition);
        }
        return list;
    }

    /** 
     * @see com.IFDFDUserIdentifyBO.pz.user.IFDUserIdentifyBO#queryTodayIdentifyList(java.lang.String)
     */
    @Override
    public List<FDUserIdentify> queryTodayIdentifyList(String userId) {
        List<FDUserIdentify> list = null;
        if (StringUtils.isNotBlank(userId)) {
            FDUserIdentify condition = new FDUserIdentify();
            condition.setUserId(userId);
            condition.setCreateDatetimeStart(DateUtil.getTodayStart());
            list = userIdentifyDAO.selectList(condition);
        }
        return list;
    }

    /** 
     * @see com.IFDFDUserIdentifyBO.pz.user.IFDUserIdentifyBO#queryUserIdentifyList(com.FDUserIdentify.pz.domain.FDUserIdentifyDO)
     */
    @Override
    public List<FDUserIdentify> queryUserIdentifyList(FDUserIdentify data) {
        return userIdentifyDAO.selectList(data);
    }

    @Override
    public void isChecked(String realName, String idKind, String idNo) {
        FDUserIdentify userIdentify = this
            .getSuccessOne(realName, idKind, idNo);
        if (userIdentify != null) {
            throw new BizException("li01004", "该证件信息已经被认证过，不能二次认证");
        }
    }

    @Override
    public FDUserIdentify getSuccessOne(String realName, String idKind,
            String idNo) {
        FDUserIdentify data = null;
        if (StringUtils.isNotBlank(realName) && StringUtils.isNotBlank(idKind)
                && StringUtils.isNotBlank(idNo)) {
            FDUserIdentify condition = new FDUserIdentify();
            condition.setRealName(realName);
            condition.setIdKind(idKind);
            condition.setIdNo(idNo);
            condition.setErrorCode("0");
            List<FDUserIdentify> list = userIdentifyDAO.selectList(condition);
            if (CollectionUtils.isNotEmpty(list)) {
                data = list.get(0);
            }
        }
        return data;
    }

}
