package com.cdkj.service.bo.impl;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cdkj.service.bo.IGroupBO;
import com.cdkj.service.bo.base.PaginableBOImpl;
import com.cdkj.service.core.EGeneratePrefix;
import com.cdkj.service.core.OrderNoGenerater;
import com.cdkj.service.core.StringValidater;
import com.cdkj.service.dao.IGroupDAO;
import com.cdkj.service.domain.Group;
import com.cdkj.service.enums.EBoolean;
import com.cdkj.service.exception.BizException;

@Component
public class GroupBOImpl extends PaginableBOImpl<Group> implements IGroupBO {

    @Autowired
    private IGroupDAO groupDAO;

    @Override
    public boolean isGroupExist(String code) {
        Group condition = new Group();
        condition.setCode(code);
        if (groupDAO.selectTotalCount(condition) > 0) {
            return true;
        }
        return false;
    }

    @Override
    public String saveGroup(String name, String userId) {
        Group data = new Group();
        String code = OrderNoGenerater.generateM(EGeneratePrefix.GROUP
            .getCode());
        data.setCode(code);
        data.setName(name);
        data.setFocusNum(StringValidater.toInteger(EBoolean.NO.getCode()));
        data.setCreateDatetime(new Date());
        data.setUserId(userId);
        groupDAO.insert(data);
        return code;
    }

    @Override
    public void removeGroup(String code) {
        if (StringUtils.isNotBlank(code)) {
            Group data = new Group();
            data.setCode(code);
            groupDAO.delete(data);
        }
    }

    @Override
    public void refreshGroup(String code, String name) {
        Group data = new Group();
        data.setCode(code);
        data.setName(name);
        groupDAO.update(data);
    }

    @Override
    public void refreshFocusNum(String code, Integer focusNum) {
        Group data = new Group();
        data.setCode(code);
        data.setFocusNum(focusNum);
        groupDAO.updateFocusNum(data);
    }

    @Override
    public List<Group> queryGroupList(Group condition) {
        return groupDAO.selectList(condition);
    }

    @Override
    public Group getGroup(String code) {
        Group data = null;
        if (StringUtils.isNotBlank(code)) {
            Group condition = new Group();
            condition.setCode(code);
            data = groupDAO.select(condition);
            if (data == null) {
                throw new BizException("xn0000", "�� ��Ų�����");
            }
        }
        return data;
    }

}
