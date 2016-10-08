package com.cdkj.service.bo;

import java.util.List;

import com.cdkj.service.bo.base.IPaginableBO;
import com.cdkj.service.domain.ServeTrain;

public interface IServeTrainBO extends IPaginableBO<ServeTrain> {

    public boolean isServeTrainExist(String code);

    public String saveServeTrain(ServeTrain data);

    public int removeServeTrain(String code);

    public int refreshServeTrain(ServeTrain data);

    public List<ServeTrain> queryServeTrainList(ServeTrain condition);

    public ServeTrain getServeTrain(String code);

}
