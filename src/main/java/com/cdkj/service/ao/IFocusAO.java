package com.cdkj.service.ao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.cdkj.service.bo.base.Paginable;
import com.cdkj.service.domain.Focus;

@Component
public interface IFocusAO {
    static final String DEFAULT_ORDER_COLUMN = "code";

    public String addFocus(Focus data);

    public int dropFocus(String code);

    public int editFocus(Focus data);

    public Paginable<Focus> queryFocusPage(int start, int limit, Focus condition);

    public List<Focus> queryFocusList(Focus condition);

    public Focus getFocus(String code);

}
