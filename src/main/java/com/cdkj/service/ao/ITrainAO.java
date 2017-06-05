package com.cdkj.service.ao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.cdkj.service.bo.base.Paginable;
import com.cdkj.service.domain.Train;

@Component
public interface ITrainAO {
    static final String DEFAULT_ORDER_COLUMN = "code";

    public String addTrain(Train data);

    public int dropTrain(String code);

    public int editTrain(Train data);

    public Paginable<Train> queryTrainPage(int start, int limit, Train condition);

    public List<Train> queryTrainList(Train condition);

    public Train getTrain(String code);

}
