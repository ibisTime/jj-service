package com.cdkj.service.ao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdkj.service.ao.IQualifyAO;
import com.cdkj.service.bo.IQualifyBO;
import com.cdkj.service.bo.base.Paginable;
import com.cdkj.service.domain.Qualify;
import com.cdkj.service.exception.BizException;



//CHECK ��鲢��ע�� 
@Service
public class QualifyAOImpl implements IQualifyAO {

	@Autowired
	private IQualifyBO qualifyBO;

	@Override
	public String addQualify(Qualify data) {
		return qualifyBO.saveQualify(data);
	}

	@Override
	public int editQualify(Qualify data) {
		if (!qualifyBO.isQualifyExist(data.getCode())) {
			throw new BizException("xn0000", "记录编号不存在");
		}
		return qualifyBO.refreshQualify(data);
	}

	@Override
	public int dropQualify(String code) {
		if (!qualifyBO.isQualifyExist(code)) {
			throw new BizException("xn0000", "记录编号不存在");
		}
		return qualifyBO.removeQualify(code);
	}

	@Override
	public Paginable<Qualify> queryQualifyPage(int start, int limit,
			Qualify condition) {
		return qualifyBO.getPaginable(start, limit, condition);
	}

	@Override
	public List<Qualify> queryQualifyList(Qualify condition) {
		return qualifyBO.queryQualifyList(condition);
	}

	@Override
	public Qualify getQualify(String code) {
		return qualifyBO.getQualify(code);
	}
}