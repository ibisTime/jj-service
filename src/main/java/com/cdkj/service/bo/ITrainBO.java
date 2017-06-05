package com.cdkj.service.bo;

import java.util.List;

import com.cdkj.service.bo.base.IPaginableBO;
import com.cdkj.service.domain.Train;



//CHECK ��鲢��ע�� 
public interface ITrainBO extends IPaginableBO<Train> {


	public boolean isTrainExist(String code);


	public String saveTrain(Train data);


	public int removeTrain(String code);


	public int refreshTrain(Train data);


	public List<Train> queryTrainList(Train condition);


	public Train getTrain(String code);


}