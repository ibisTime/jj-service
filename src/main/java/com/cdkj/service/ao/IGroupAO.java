package com.cdkj.service.ao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.cdkj.service.bo.base.Paginable;
import com.cdkj.service.domain.Group;

@Component
public interface IGroupAO {
    static final String DEFAULT_ORDER_COLUMN = "code";

    public String addGroup(String name, String userId);

    public void dropGroup(String code);

    public void editGroup(String code, String name);

    public Paginable<Group> queryGroupPage(int start, int limit, Group condition);

    public List<Group> queryGroupList(Group condition);

    public Group getGroup(String code);

}
