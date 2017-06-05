package com.cdkj.service.ao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdkj.service.ao.IGroupAO;
import com.cdkj.service.bo.IFocusBO;
import com.cdkj.service.bo.IGroupBO;
import com.cdkj.service.bo.base.Paginable;
import com.cdkj.service.domain.Focus;
import com.cdkj.service.domain.Group;
import com.cdkj.service.exception.BizException;

@Service
public class GroupAOImpl implements IGroupAO {

    @Autowired
    private IGroupBO groupBO;

    @Autowired
    private IFocusBO focusBO;

    @Override
    public String addGroup(String name, String userId) {
        return groupBO.saveGroup(name, userId);
    }

    @Override
    public void editGroup(String code, String name) {
        if (!groupBO.isGroupExist(code)) {
            throw new BizException("xn0000", "记录编号不存在");
        }
        groupBO.refreshGroup(code, name);
    }

    @Override
    public void dropGroup(String code) {
        if (!groupBO.isGroupExist(code)) {
            throw new BizException("xn0000", "记录编号不存在");
        }
        List<Focus> focusList = focusBO.queryFocusList(code);
        for (Focus focus : focusList) {
            focusBO.refreshFocus(focus, null);
        }
        groupBO.removeGroup(code);
    }

    @Override
    public Paginable<Group> queryGroupPage(int start, int limit, Group condition) {
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
