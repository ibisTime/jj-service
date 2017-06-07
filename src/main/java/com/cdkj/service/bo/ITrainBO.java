package com.cdkj.service.bo;

import java.util.List;

import com.cdkj.service.bo.base.IPaginableBO;
import com.cdkj.service.domain.Train;

public interface ITrainBO extends IPaginableBO<Train> {

    public boolean isTrainExist(String code);

    public void saveTrain(Train data);

    public void removeTrain(String code);

    public void refreshTrain(Train data);

    public List<Train> queryTrainList(Train condition);

    public Train getTrain(String code);

}
