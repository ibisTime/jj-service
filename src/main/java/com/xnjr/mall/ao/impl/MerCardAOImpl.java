/**
 * @Title MerCardAOImpl.java 
 * @Package com.xnjr.mall.ao.impl 
 * @Description 
 * @author xieyj  
 * @date 2016年6月11日 下午5:51:58 
 * @version V1.0   
 */
package com.xnjr.mall.ao.impl;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xnjr.mall.ao.IMerCardAO;
import com.xnjr.mall.bo.IMerCardBO;
import com.xnjr.mall.bo.base.Paginable;
import com.xnjr.mall.domain.MerCard;
import com.xnjr.mall.exception.BizException;

/** 
 * @author: xieyj 
 * @since: 2016年6月11日 下午5:51:58 
 * @history:
 */
@Service
public class MerCardAOImpl implements IMerCardAO {

    @Autowired
    IMerCardBO merCardBO;

    /** 
     * @see com.xnjr.mall.ao.IMerCardAO#addMerCard(com.xnjr.mall.domain.MerCard)
     */
    @Override
    public String addMerCard(MerCard data) {
        MerCard condition = new MerCard();
        condition.setCardNo(data.getCardNo());
        List<MerCard> list = merCardBO.queryMerCardList(condition);
        if (!CollectionUtils.sizeIsEmpty(list)) {
            throw new BizException("xn000000", "账号已存在");
        }
        return merCardBO.saveMerCard(data);
    }

    /** 
     * @see com.xnjr.mall.ao.IMerCardAO#dropMerCard(java.lang.String)
     */
    @Override
    public int dropMerCard(String code) {
        int count = 0;
        if (!merCardBO.isMerCardExist(code)) {
            throw new BizException("xn000000", "账号编号不存在");
        }
        count = merCardBO.removeMerCard(code);

        return count;
    }

    /** 
     * @see com.xnjr.mall.ao.IMerCardAO#editMerCard(com.xnjr.mall.domain.MerCard)
     */
    @Override
    public int editMerCard(MerCard data) {
        int count = 0;
        if (!merCardBO.isMerCardExist(data.getCode())) {
            throw new BizException("xn000000", "账号编号不存在");
        }
        MerCard condition = new MerCard();
        condition.setCardNo(data.getCardNo());
        List<MerCard> list = merCardBO.queryMerCardList(condition);
        if (!CollectionUtils.sizeIsEmpty(list)) {
            MerCard merCard = merCardBO.getMerCard(data.getCode());
            if (!merCard.getCardNo().equals(list.get(0).getCardNo())) {
                throw new BizException("xn000000", "账号已存在");
            }
        }
        count = merCardBO.refreshMerCard(data);
        return count;

    }

    /** 
     * @see com.xnjr.mall.ao.IMerCardAO#queryMerCardPage(int, int, com.xnjr.mall.domain.MerCard)
     */
    @Override
    public Paginable<MerCard> queryMerCardPage(int start, int limit,
            MerCard condition) {
        return merCardBO.getPaginable(start, limit, condition);
    }

    /** 
     * @see com.xnjr.mall.ao.IMerCardAO#queryMerCardList(com.xnjr.mall.domain.MerCard)
     */
    @Override
    public List<MerCard> queryMerCardList(MerCard condition) {
        return merCardBO.queryMerCardList(condition);
    }

    /** 
     * @see com.xnjr.mall.ao.IMerCardAO#getMerCard(java.lang.String)
     */
    @Override
    public MerCard getMerCard(String code) {
        return merCardBO.getMerCard(code);
    }
}
