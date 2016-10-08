package com.cdkj.service.bo;

import java.util.List;

import com.cdkj.service.bo.base.IPaginableBO;
import com.cdkj.service.domain.Intention;

/**
 * @author: xieyj 
 * @since: 2016年10月7日 下午8:12:11 
 * @history:
 */
public interface IIntentionBO extends IPaginableBO<Intention> {

    public boolean isIntentionExist(String code);

    public String saveIntention(Intention data);

    public int removeIntention(String code);

    public int refreshIntentionStatus(String code, String dealer,
            String dealNote);

    public List<Intention> queryIntentionList(Intention condition);

    public Intention getIntention(String code);

}
