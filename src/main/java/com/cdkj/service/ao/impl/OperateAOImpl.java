package com.cdkj.service.ao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdkj.service.ao.IOperateAO;
import com.cdkj.service.bo.IOperateBO;
import com.cdkj.service.bo.base.Paginable;
import com.cdkj.service.domain.Operate;
import com.cdkj.service.exception.BizException;



//CHECK ��鲢��ע�� 
@Service
public class OperateAOImpl implements IOperateAO {

	@Autowired
	private IOperateBO operateBO;

	@Override
	public String addOperate(Operate data) {
		return operateBO.saveOperate(data);
	}

	@Override
	public int editOperate(Operate data) {
		if (!operateBO.isOperateExist(data.getCode())) {
			throw new BizException("xn0000", "记录编号不存在");
		}
		return operateBO.refreshOperate(data);
	}

	@Override
	public int dropOperate(String code) {
		if (!operateBO.isOperateExist(code)) {
			throw new BizException("xn0000", "记录编号不存在");
		}
		return operateBO.removeOperate(code);
	}

	@Override
	public Paginable<Operate> queryOperatePage(int start, int limit,
			Operate condition) {
		return operateBO.getPaginable(start, limit, condition);
	}

	@Override
	public List<Operate> queryOperateList(Operate condition) {
		return operateBO.queryOperateList(condition);
	}

	@Override
	public Operate getOperate(String code) {
		return operateBO.getOperate(code);
	}
}