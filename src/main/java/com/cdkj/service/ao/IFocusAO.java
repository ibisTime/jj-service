package com.cdkj.service.ao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.cdkj.service.bo.base.Paginable;
import com.cdkj.service.domain.Focus;

@Component
public interface IFocusAO {
    static final String DEFAULT_ORDER_COLUMN = "code";

    public String addFocus(String companyCode, String groupCode, String userId);

    public void dropFocus(String code);

    public void editFocus(String code, String groupCode);

    public Paginable<Focus> queryFocusPage(int start, int limit, Focus condition);

    public List<Focus> queryFocusList(Focus condition);

    public Focus getFocus(String code);

}
