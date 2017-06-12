package com.cdkj.service.ao.impl;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
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
        if (StringUtils.isNotBlank(condition.getUserId())) {
            String userId = condition.getUserId();
            this.checkIsUserId(userId);
        }
        return groupBO.getPaginable(start, limit, condition);
    }

    public void checkIsUserId(String userId) {
        if (StringUtils.isNotBlank(userId)) {
            List<Group> list = groupBO.queryGroupByUserIdList(userId);
            if (CollectionUtils.isEmpty(list)) {
                List<Group> groupList = groupBO.queryGroupList(null);
                List<Group> gList = groupList.subList(0, 3);
                for (Group group : gList) {
                    groupBO.saveGroup(group.getName(), userId);
                }
            }
        }
    }

    @Override
    public List<Group> queryGroupList(Group condition) {
        if (StringUtils.isNotBlank(condition.getUserId())) {
            String userId = condition.getUserId();
            this.checkIsUserId(userId);
        }
        return groupBO.queryGroupList(condition);
    }

    @Override
    public Group getGroup(String code) {
        return groupBO.getGroup(code);
    }
}
