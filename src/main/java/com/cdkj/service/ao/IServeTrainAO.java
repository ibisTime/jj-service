package com.cdkj.service.ao;

import java.util.List;

import com.cdkj.service.bo.base.Paginable;
import com.cdkj.service.domain.ServeTrain;

public interface IServeTrainAO {
    static final String DEFAULT_ORDER_COLUMN = "code";

    public String addServeTrain(ServeTrain data);

    public int dropServeTrain(String code);

    public int editServeTrain(ServeTrain data);

    public Paginable<ServeTrain> queryServeTrainPage(int start, int limit,
            ServeTrain condition);

    public List<ServeTrain> queryServeTrainList(ServeTrain condition);

    public ServeTrain getServeTrain(String code);

}
