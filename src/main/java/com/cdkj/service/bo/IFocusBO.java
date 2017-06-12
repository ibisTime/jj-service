package com.cdkj.service.bo;

import java.util.List;

import com.cdkj.service.bo.base.IPaginableBO;
import com.cdkj.service.domain.Focus;

public interface IFocusBO extends IPaginableBO<Focus> {

    public boolean isFocusExist(String code);

    public String saveFocus(String companyCode, String groupCode, String userId);

    public void removeFocus(String code);

    public void refreshFocus(Focus focus, String groupCode);

    public List<Focus> queryFocusList(Focus condition);

    public List<Focus> queryFocusList(String groupCode);

    public Focus getFocus(String code);

    public List<Focus> queryFocusList(String code, String userId);

}
