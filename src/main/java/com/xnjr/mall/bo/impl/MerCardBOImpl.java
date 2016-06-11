/**
 * @Title MerCardBOImpl.java 
 * @Package com.xnjr.mall.bo.impl 
 * @Description 
 * @author xieyj  
 * @date 2016年6月11日 下午5:40:54 
 * @version V1.0   
 */
package com.xnjr.mall.bo.impl;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.xnjr.mall.bo.IMerCardBO;
import com.xnjr.mall.bo.base.PaginableBOImpl;
import com.xnjr.mall.core.OrderNoGenerater;
import com.xnjr.mall.dao.IMerCardDAO;
import com.xnjr.mall.domain.MerCard;
import com.xnjr.mall.exception.BizException;

/** 
 * @author: xieyj 
 * @since: 2016年6月11日 下午5:40:54 
 * @history:
 */
@Component
public class MerCardBOImpl extends PaginableBOImpl<MerCard> implements
        IMerCardBO {

    @Autowired
    private IMerCardDAO merCardDAO;

    /** 
     * @see com.xnjr.mall.bo.IMerCardBO#isMerCardExist(java.lang.String)
     */
    @Override
    public boolean isMerCardExist(String code) {
        MerCard condition = new MerCard();
        condition.setCode(code);
        if (merCardDAO.selectTotalCount(condition) == 1) {
            return true;
        }
        return false;
    }

    /** 
     * @see com.xnjr.mall.bo.IMerCardBO#saveMerCard(com.xnjr.mall.domain.MerCard)
     */
    @Override
    public String saveMerCard(MerCard data) {
        String code = null;
        if (data != null) {
            code = OrderNoGenerater.generateM("MC");
            data.setCode(code);
            data.setUpdateDatetime(new Date());
            merCardDAO.insert(data);
        }
        return code;
    }

    /** 
     * @see com.xnjr.mall.bo.IMerCardBO#deleteMerCard(java.lang.String)
     */
    @Override
    public int removeMerCard(String code) {
        int count = 0;
        if (StringUtils.isNotBlank(code)) {
            if (!isMerCardExist(code)) {
                throw new BizException("xn000000", "账号编号不存在");
            }
            MerCard data = new MerCard();
            data.setCode(code);
            count = merCardDAO.delete(data);
        }
        return count;
    }

    /** 
     * @see com.xnjr.mall.bo.IMerCardBO#refreshMerCard(com.xnjr.mall.domain.MerCard)
     */
    @Override
    public int refreshMerCard(MerCard data) {
        int count = 0;
        if (data != null) {
            if (!isMerCardExist(data.getCode())) {
                throw new BizException("xn000000", "账号编号不存在");
            }
            data.setUpdateDatetime(new Date());
            count = merCardDAO.updateMerCard(data);
        }
        return count;
    }

    /** 
     * @see com.xnjr.mall.bo.IMerCardBO#queryMerCardList(com.xnjr.mall.domain.MerCard)
     */
    @Override
    public List<MerCard> queryMerCardList(MerCard condition) {
        return merCardDAO.selectList(condition);
    }

    /** 
     * @see com.xnjr.mall.bo.IMerCardBO#getMerCard(java.lang.String)
     */
    @Override
    public MerCard getMerCard(String code) {
        MerCard data = null;
        if (StringUtils.isNotBlank(code)) {
            MerCard condition = new MerCard();
            condition.setCode(code);
            data = merCardDAO.select(condition);
            if (data == null) {
                throw new BizException("xn000000", "账号编号不存在");
            }
        }
        return data;
    }
}
