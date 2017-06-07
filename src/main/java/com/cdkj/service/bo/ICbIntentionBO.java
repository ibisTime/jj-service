package com.cdkj.service.bo;

import java.util.List;

import com.cdkj.service.bo.base.IPaginableBO;
import com.cdkj.service.domain.CbIntention;
import com.cdkj.service.enums.ECbIntentionStatus;

public interface ICbIntentionBO extends IPaginableBO<CbIntention> {

    public boolean isCbIntentionExist(String code);

    public void saveCbIntention(CbIntention data);

    public void dropCbIntention(String code);

    public void refreshCbIntention(CbIntention data, ECbIntentionStatus status,
            String updater, String remark);

    public List<CbIntention> queryCbIntentionList(String positionCode,
            String resumeCode, String serviceCode);

    public CbIntention getCbIntention(String code);

}
