package com.cdkj.service.bo;

import java.util.List;

import com.cdkj.service.bo.base.IPaginableBO;
import com.cdkj.service.domain.Group;

public interface IGroupBO extends IPaginableBO<Group> {

    public boolean isGroupExist(String code);

    public String saveGroup(String name, String userId);

    public void removeGroup(String code);

    public void refreshGroup(String code, String name);

    public void refreshFocusNum(String code, Integer focusNum);

    public List<Group> queryGroupList(Group condition);

    public Group getGroup(String code);

}
