/**
 * @Title IMerCardAO.java 
 * @Package com.xnjr.mall.ao 
 * @Description 
 * @author xieyj  
 * @date 2016年6月11日 下午5:50:35 
 * @version V1.0   
 */
package com.xnjr.mall.ao;

import java.util.List;

import com.xnjr.mall.bo.base.Paginable;
import com.xnjr.mall.domain.MerCard;

/** 
 * @author: xieyj 
 * @since: 2016年6月11日 下午5:50:35 
 * @history:
 */
public interface IMerCardAO {
    static final String DEFAULT_ORDER_COLUMN = "code";

    public String addMerCard(MerCard data);

    public int dropMerCard(String code);

    public int editMerCard(MerCard data);

    public Paginable<MerCard> queryMerCardPage(int start, int limit,
            MerCard condition);

    public List<MerCard> queryMerCardList(MerCard condition);

    public MerCard getMerCard(String code);

}
