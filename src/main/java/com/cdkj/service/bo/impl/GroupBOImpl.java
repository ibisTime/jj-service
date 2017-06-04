package com.cdkj.service.bo.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cdkj.service.bo.IGroupBO;
import com.cdkj.service.bo.base.PaginableBOImpl;
import com.cdkj.service.core.EGeneratePrefix;
import com.cdkj.service.core.OrderNoGenerater;
import com.cdkj.service.dao.IGroupDAO;
import com.cdkj.service.domain.Group;
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
    public String saveGroup(Group data) {
        String code = null;
        if (data != null) {
            code = OrderNoGenerater.generateM(EGeneratePrefix.GROUP.getCode());
            data.setCode(code);
            groupDAO.insert(data);
        }
        return code;
    }

    @Override
    public int removeGroup(String code) {
        int count = 0;
        if (StringUtils.isNotBlank(code)) {
            Group data = new Group();
            data.setCode(code);
            count = groupDAO.delete(data);
        }
        return count;
    }

    @Override
    public int refreshGroup(Group data) {
        int count = 0;
        if (StringUtils.isNotBlank(data.getCode())) {
            count = groupDAO.update(data);
        }
        return count;
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
