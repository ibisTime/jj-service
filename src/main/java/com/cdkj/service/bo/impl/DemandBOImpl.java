package com.cdkj.service.bo.impl;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cdkj.service.bo.IDemandBO;
import com.cdkj.service.bo.base.PaginableBOImpl;
import com.cdkj.service.dao.IDemandDAO;
import com.cdkj.service.domain.Demand;
import com.cdkj.service.enums.EBoolean;
import com.cdkj.service.exception.BizException;

/**
 * @author: xieyj 
 * @since: 2016年10月7日 下午5:08:02 
 * @history:
 */
@Component
public class DemandBOImpl extends PaginableBOImpl<Demand> implements IDemandBO {

    @Autowired
    private IDemandDAO demandDAO;

    @Override
    public boolean isDemandExist(String code) {
        Demand condition = new Demand();
        condition.setCode(code);
        if (demandDAO.selectTotalCount(condition) > 0) {
            return true;
        }
        return false;
    }

    @Override
    public void saveDemand(Demand data) {
        demandDAO.insert(data);
    }

    @Override
    public void removeDemand(String code) {
        if (StringUtils.isNotBlank(code)) {
            Demand data = new Demand();
            data.setCode(code);
            demandDAO.delete(data);
        }
    }

    @Override
    public void refreshDemand(Demand data) {
        demandDAO.update(data);
    }

    @Override
    public List<Demand> queryDemandList(Demand condition) {
        return demandDAO.selectList(condition);
    }

    @Override
    public Demand getDemand(String code) {
        Demand data = null;
        if (StringUtils.isNotBlank(code)) {
            Demand condition = new Demand();
            condition.setCode(code);
            data = demandDAO.select(condition);
            if (data == null) {
                throw new BizException("xn000000", "需求不存在");
            }
        }
        return data;
    }

    /** 
     * @see com.cdkj.service.bo.IDemandBO#refreshDemandStatus(java.lang.String, java.lang.String, java.lang.String)
     */
    @Override
    public void refreshDemandStatus(Demand demand, String dealer,
            String dealNote) {
        demand.setStatus(EBoolean.NO.getCode());
        demand.setDealer(dealer);
        demand.setDealNote(dealNote);
        demand.setDealDatetime(new Date());
        demandDAO.updateStatus(demand);
    }
}
