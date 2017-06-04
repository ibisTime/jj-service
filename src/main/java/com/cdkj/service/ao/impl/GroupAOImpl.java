package com.cdkj.service.ao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdkj.service.ao.IGroupAO;
import com.cdkj.service.bo.IGroupBO;
import com.cdkj.service.bo.base.Paginable;
import com.cdkj.service.domain.Group;
import com.cdkj.service.exception.BizException;



//CHECK ��鲢��ע�� 
@Service
public class GroupAOImpl implements IGroupAO {

	@Autowired
	private IGroupBO groupBO;

	@Override
	public String addGroup(Group data) {
		return groupBO.saveGroup(data);
	}

	@Override
	public int editGroup(Group data) {
		if (!groupBO.isGroupExist(data.getCode())) {
			throw new BizException("xn0000", "记录编号不存在");
		}
		return groupBO.refreshGroup(data);
	}

	@Override
	public int dropGroup(String code) {
		if (!groupBO.isGroupExist(code)) {
			throw new BizException("xn0000", "记录编号不存在");
		}
		return groupBO.removeGroup(code);
	}

	@Override
	public Paginable<Group> queryGroupPage(int start, int limit,
			Group condition) {
		return groupBO.getPaginable(start, limit, condition);
	}

	@Override
	public List<Group> queryGroupList(Group condition) {
		return groupBO.queryGroupList(condition);
	}

	@Override
	public Group getGroup(String code) {
		return groupBO.getGroup(code);
	}
}