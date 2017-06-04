package com.cdkj.service.ao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdkj.service.ao.IFocusAO;
import com.cdkj.service.bo.IFocusBO;
import com.cdkj.service.bo.base.Paginable;
import com.cdkj.service.domain.Focus;
import com.cdkj.service.exception.BizException;



//CHECK ��鲢��ע�� 
@Service
public class FocusAOImpl implements IFocusAO {

	@Autowired
	private IFocusBO focusBO;

	@Override
	public String addFocus(Focus data) {
		return focusBO.saveFocus(data);
	}

	@Override
	public int editFocus(Focus data) {
		if (!focusBO.isFocusExist(data.getCode())) {
			throw new BizException("xn0000", "记录编号不存在");
		}
		return focusBO.refreshFocus(data);
	}

	@Override
	public int dropFocus(String code) {
		if (!focusBO.isFocusExist(code)) {
			throw new BizException("xn0000", "记录编号不存在");
		}
		return focusBO.removeFocus(code);
	}

	@Override
	public Paginable<Focus> queryFocusPage(int start, int limit,
			Focus condition) {
		return focusBO.getPaginable(start, limit, condition);
	}

	@Override
	public List<Focus> queryFocusList(Focus condition) {
		return focusBO.queryFocusList(condition);
	}

	@Override
	public Focus getFocus(String code) {
		return focusBO.getFocus(code);
	}
}