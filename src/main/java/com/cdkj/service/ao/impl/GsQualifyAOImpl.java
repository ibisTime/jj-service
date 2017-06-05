package com.cdkj.service.ao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdkj.service.ao.IGsQualifyAO;
import com.cdkj.service.bo.IGsQualifyBO;
import com.cdkj.service.bo.base.Paginable;
import com.cdkj.service.domain.GsQualify;
import com.cdkj.service.exception.BizException;



//CHECK ��鲢��ע�� 
@Service
public class GsQualifyAOImpl implements IGsQualifyAO {

	@Autowired
	private IGsQualifyBO gsQualifyBO;

	@Override
	public String addGsQualify(GsQualify data) {
		return gsQualifyBO.saveGsQualify(data);
	}

	@Override
	public int editGsQualify(GsQualify data) {
		if (!gsQualifyBO.isGsQualifyExist(data.getCode())) {
			throw new BizException("xn0000", "记录编号不存在");
		}
		return gsQualifyBO.refreshGsQualify(data);
	}

	@Override
	public int dropGsQualify(String code) {
		if (!gsQualifyBO.isGsQualifyExist(code)) {
			throw new BizException("xn0000", "记录编号不存在");
		}
		return gsQualifyBO.removeGsQualify(code);
	}

	@Override
	public Paginable<GsQualify> queryGsQualifyPage(int start, int limit,
			GsQualify condition) {
		return gsQualifyBO.getPaginable(start, limit, condition);
	}

	@Override
	public List<GsQualify> queryGsQualifyList(GsQualify condition) {
		return gsQualifyBO.queryGsQualifyList(condition);
	}

	@Override
	public GsQualify getGsQualify(String code) {
		return gsQualifyBO.getGsQualify(code);
	}
}