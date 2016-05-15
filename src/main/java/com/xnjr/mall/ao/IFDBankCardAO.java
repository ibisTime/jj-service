package com.xnjr.mall.ao;

import java.util.List;

import com.xnjr.mall.bo.base.Paginable;
import com.xnjr.mall.domain.FDBankCard;
import com.xnjr.mall.spring.ServiceModule;

/**
 * @author: xieyj 
 * @since: 2016年4月23日 上午9:15:20 
 * @history:
 */
@ServiceModule
public interface IFDBankCardAO {

    String DEFAULT_ORDER_COLUMN = "id";

    public Long addBankCard(String userId, String bankCode, String subbranch,
            String bankCardNo);

    public void editBankCard(Long id, String userId, String bankCode,
            String subbranch, String bankCardNo);

    public void dropBankCard(Long id);

    public FDBankCard getBankCard(Long id);

    public List<FDBankCard> queryBankCardList(FDBankCard data);

    public Paginable<FDBankCard> queryBankCardPage(int start, int limit,
            FDBankCard condition);

}
