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
    public String saveFocus(Focus data) {
        String code = null;
        if (data != null) {
            code = OrderNoGenerater.generateM(EGeneratePrefix.FOCUS.getCode());
            data.setCode(code);
            focusDAO.insert(data);
        }
        return code;
    }

    @Override
    public int removeFocus(String code) {
        int count = 0;
        if (StringUtils.isNotBlank(code)) {
            Focus data = new Focus();
            data.setCode(code);
            count = focusDAO.delete(data);
        }
        return count;
    }

    @Override
    public int refreshFocus(Focus data) {
        int count = 0;
        if (StringUtils.isNotBlank(data.getCode())) {
            count = focusDAO.update(data);
        }
        return count;
    }

    @Override
    public List<Focus> queryFocusList(Focus condition) {
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
                throw new BizException("xn0000", "�� ��Ų�����");
            }
        }
        return data;
    }
}
