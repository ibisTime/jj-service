package com.cdkj.service.ao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdkj.service.ao.ICbIntentionAO;
import com.cdkj.service.bo.ICbIntentionBO;
import com.cdkj.service.bo.base.Paginable;
import com.cdkj.service.domain.CbIntention;
import com.cdkj.service.exception.BizException;



//CHECK ��鲢��ע�� 
@Service
public class CbIntentionAOImpl implements ICbIntentionAO {

	@Autowired
	private ICbIntentionBO CbIntentionBO;

	@Override
	public String addCbIntention(CbIntention data) {
		return CbIntentionBO.saveCbIntention(data);
	}

	@Override
	public int editCbIntention(CbIntention data) {
		if (!CbIntentionBO.isCbIntentionExist(data.getCode())) {
			throw new BizException("xn0000", "记录编号不存在");
		}
		return CbIntentionBO.refreshCbIntention(data);
	}

	@Override
	public int dropCbIntention(String code) {
		if (!CbIntentionBO.isCbIntentionExist(code)) {
			throw new BizException("xn0000", "记录编号不存在");
		}
		return CbIntentionBO.removeCbIntention(code);
	}

	@Override
	public Paginable<CbIntention> queryCbIntentionPage(int start, int limit,
			CbIntention condition) {
		return CbIntentionBO.getPaginable(start, limit, condition);
	}

	@Override
	public List<CbIntention> queryCbIntentionList(CbIntention condition) {
		return CbIntentionBO.queryCbIntentionList(condition);
	}

	@Override
	public CbIntention getCbIntention(String code) {
		return CbIntentionBO.getCbIntention(code);
	}
}