package com.cdkj.service.bo;

import java.util.List;

import com.cdkj.service.bo.base.IPaginableBO;
import com.cdkj.service.domain.Qualify;

public interface IQualifyBO extends IPaginableBO<Qualify> {

    public boolean isQualifyExist(String code);

    public void refreshQualify(String code, String type, String name,
            String description, String updater, String remark);

    public List<Qualify> queryQualifyList(Qualify condition);

    public Qualify getQualify(String code);

}
