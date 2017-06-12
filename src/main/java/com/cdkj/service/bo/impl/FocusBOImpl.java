package com.cdkj.service.bo.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cdkj.service.bo.IFocusBO;
import com.cdkj.service.bo.base.PaginableBOImpl;
import com.cdkj.service.core.EGeneratePrefix;
import com.cdkj.service.core.OrderNoGenerater;
import com.cdkj.service.dao.IFocusDAO;
import com.cdkj.service.domain.Focus;
import com.cdkj.service.exception.BizException;

@Component
public class FocusBOImpl extends PaginableBOImpl<Focus> implements IFocusBO {

    @Autowired
    private IFocusDAO focusDAO;

    @Override
    public boolean isFocusExist(String code) {
        Focus condition = new Focus();
        condition.setCode(code);
        if (focusDAO.selectTotalCount(condition) > 0) {
            return true;
        }
        return false;
    }

    @Override
    public String saveFocus(String companyCode, String groupCode, String userId) {
        Focus data = new Focus();
        String code = OrderNoGenerater.generateM(EGeneratePrefix.FOCUS
            .getCode());
        data.setCode(code);
        data.setCompanyCode(companyCode);
        data.setGroupCode(groupCode);
        data.setUserId(userId);
        focusDAO.insert(data);
        return code;
    }

    @Override
    public void removeFocus(String code) {
        Focus data = new Focus();
        data.setCode(code);
        focusDAO.delete(data);
    }

    @Override
    public void refreshFocus(Focus focus, String groupCode) {
        focus.setGroupCode(groupCode);
        focusDAO.update(focus);
    }

    @Override
    public List<Focus> queryFocusList(Focus condition) {
        return focusDAO.selectList(condition);
    }

    @Override
    public List<Focus> queryFocusList(String groupCode) {
        Focus condition = new Focus();
        condition.setGroupCode(groupCode);
        return focusDAO.selectList(condition);
    }

    @Override
    public Focus getFocus(String code) {
        Focus data = null;
        if (StringUtils.isNotBlank(code)) {
            Focus condition = new Focus();
            condition.setCode(code);
            data = focusDAO.select(condition);
            if (data == null) {
                throw new BizException("xn0000", "不存在该关注编号");
            }
        }
        return data;
    }

    @Override
    public List<Focus> queryFocusList(String code, String userId) {
        Focus condition = new Focus();
        condition.setCompanyCode(code);
        condition.setUserId(userId);
        return focusDAO.selectList(condition);
    }

}
