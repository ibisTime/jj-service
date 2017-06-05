package com.cdkj.service.bo.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cdkj.service.bo.IOperateBO;
import com.cdkj.service.bo.base.PaginableBOImpl;
import com.cdkj.service.core.EGeneratePrefix;
import com.cdkj.service.core.OrderNoGenerater;
import com.cdkj.service.dao.IOperateDAO;
import com.cdkj.service.domain.Operate;
import com.cdkj.service.exception.BizException;

@Component
public class OperateBOImpl extends PaginableBOImpl<Operate> implements
        IOperateBO {

    @Autowired
    private IOperateDAO operateDAO;

    @Override
    public boolean isOperateExist(String code) {
        Operate condition = new Operate();
        condition.setCode(code);
        if (operateDAO.selectTotalCount(condition) > 0) {
            return true;
        }
        return false;
    }

    @Override
    public String saveOperate(Operate data) {
        String code = null;
        if (data != null) {
            code = OrderNoGenerater
                .generateM(EGeneratePrefix.OPERATE.getCode());
            data.setCode(code);
            operateDAO.insert(data);
        }
        return code;
    }

    @Override
    public int removeOperate(String code) {
        int count = 0;
        if (StringUtils.isNotBlank(code)) {
            Operate data = new Operate();
            data.setCode(code);
            count = operateDAO.delete(data);
        }
        return count;
    }

    @Override
    public int refreshOperate(Operate data) {
        int count = 0;
        if (StringUtils.isNotBlank(data.getCode())) {
            count = operateDAO.update(data);
        }
        return count;
    }

    @Override
    public List<Operate> queryOperateList(Operate condition) {
        return operateDAO.selectList(condition);
    }

    @Override
    public Operate getOperate(String code) {
        Operate data = null;
        if (StringUtils.isNotBlank(code)) {
            Operate condition = new Operate();
            condition.setCode(code);
            data = operateDAO.select(condition);
            if (data == null) {
                throw new BizException("xn0000", "�� ��Ų�����");
            }
        }
        return data;
    }
}
