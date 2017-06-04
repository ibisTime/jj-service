package com.cdkj.service.ao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.cdkj.service.bo.base.Paginable;
import com.cdkj.service.domain.Group;

@Component
public interface IGroupAO {
    static final String DEFAULT_ORDER_COLUMN = "code";

    public String addGroup(Group data);

    public int dropGroup(String code);

    public int editGroup(Group data);

    public Paginable<Group> queryGroupPage(int start, int limit, Group condition);

    public List<Group> queryGroupList(Group condition);

    public Group getGroup(String code);

}
