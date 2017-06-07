package com.cdkj.service.bo.impl;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cdkj.service.bo.IOperateBO;
import com.cdkj.service.bo.base.PaginableBOImpl;
import com.cdkj.service.dao.IOperateDAO;
import com.cdkj.service.domain.Operate;
import com.cdkj.service.enums.EBoolean;
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
    public void saveOperate(Operate data) {
        operateDAO.insert(data);
    }

    @Override
    public void removeOperate(String code) {
        if (StringUtils.isNotBlank(code)) {
            Operate data = new Operate();
            data.setCode(code);
            operateDAO.delete(data);
        }
    }

    @Override
    public void refreshOperate(Operate data) {
        operateDAO.update(data);
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
                throw new BizException("xn0000", "不存在该运营编号");
            }
        }
        return data;
    }

    @Override
    public void wgclOperate(Operate operate, String dealer, String dealNote) {
        operate.setStatus(EBoolean.NO.getCode());
        operate.setDealer(dealer);
        operate.setDealDatetime(new Date());
        operate.setDealNote(dealNote);
        operateDAO.wgclOperate(operate);
    }

    @Override
    public List<Operate> queryOperateList(String location, String orderNo) {
        Operate condition = new Operate();
        condition.setLocation(location);
        condition.setOrderNo(orderNo);
        return operateDAO.selectList(condition);
    }

    @Override
    public void refreshLocation(Operate operate, String location,
            String orderNo, String dealer) {
        operate.setLocation(location);
        operate.setOrderNo(orderNo);
        operate.setDealer(dealer);
        operate.setDealDatetime(new Date());
        operateDAO.updateLocation(operate);
    }
}
