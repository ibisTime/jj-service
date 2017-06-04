package com.cdkj.service.bo;

import java.util.List;

import com.cdkj.service.bo.base.IPaginableBO;
import com.cdkj.service.domain.Group;



//CHECK ��鲢��ע�� 
public interface IGroupBO extends IPaginableBO<Group> {


	public boolean isGroupExist(String code);


	public String saveGroup(Group data);


	public int removeGroup(String code);


	public int refreshGroup(Group data);


	public List<Group> queryGroupList(Group condition);


	public Group getGroup(String code);


}