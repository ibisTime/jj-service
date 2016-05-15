package com.xnjr.mall.bo;

import java.util.List;

import com.xnjr.mall.bo.base.IPaginableBO;
import com.xnjr.mall.domain.FDBankCard;

public interface IFDBankCardBO extends IPaginableBO<FDBankCard> {

    public Long saveBankCard(String userId, String realName, String bankCode,
            String bankName, String subbranch, String bankCardNo);

    public int refreshBankCard(Long id, String userId, String realName,
            String bankCode, String bankName, String subbranch,
            String bankCardNo);

    public int removeBankCard(Long id);

    public FDBankCard getBankCard(Long id);

    public boolean isBankCardExist(Long id);

    public void checkBankCardNo(String bankCardNo);

    public List<FDBankCard> queryBankCardList(FDBankCard data);
}
