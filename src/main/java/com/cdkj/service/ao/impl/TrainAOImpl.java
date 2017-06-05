package com.cdkj.service.ao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdkj.service.ao.ITrainAO;
import com.cdkj.service.bo.ITrainBO;
import com.cdkj.service.bo.base.Paginable;
import com.cdkj.service.domain.Train;
import com.cdkj.service.exception.BizException;



//CHECK ��鲢��ע�� 
@Service
public class TrainAOImpl implements ITrainAO {

	@Autowired
	private ITrainBO trainBO;

	@Override
	public String addTrain(Train data) {
		return trainBO.saveTrain(data);
	}

	@Override
	public int editTrain(Train data) {
		if (!trainBO.isTrainExist(data.getCode())) {
			throw new BizException("xn0000", "记录编号不存在");
		}
		return trainBO.refreshTrain(data);
	}

	@Override
	public int dropTrain(String code) {
		if (!trainBO.isTrainExist(code)) {
			throw new BizException("xn0000", "记录编号不存在");
		}
		return trainBO.removeTrain(code);
	}

	@Override
	public Paginable<Train> queryTrainPage(int start, int limit,
			Train condition) {
		return trainBO.getPaginable(start, limit, condition);
	}

	@Override
	public List<Train> queryTrainList(Train condition) {
		return trainBO.queryTrainList(condition);
	}

	@Override
	public Train getTrain(String code) {
		return trainBO.getTrain(code);
	}
}