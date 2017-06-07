package com.cdkj.service.ao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.cdkj.service.bo.base.Paginable;
import com.cdkj.service.domain.Train;
import com.cdkj.service.dto.req.XN612090Req;
import com.cdkj.service.dto.req.XN612092Req;

@Component
public interface ITrainAO {
    static final String DEFAULT_ORDER_COLUMN = "code";

    public String addTrain(XN612090Req req);

    public void dropTrain(String code);

    public void editTrain(XN612092Req req);

    public Paginable<Train> queryTrainPage(int start, int limit, Train condition);

    public List<Train> queryTrainList(Train condition);

    public Train getTrain(String code);

}
