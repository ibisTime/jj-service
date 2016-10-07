package com.cdkj.service.ao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdkj.service.ao.IDemandAO;
import com.cdkj.service.bo.IDemandBO;
import com.cdkj.service.bo.base.Paginable;
import com.cdkj.service.domain.Demand;
import com.cdkj.service.exception.BizException;

/**
 * @author: xieyj 
 * @since: 2016年10月7日 下午5:16:01 
 * @history:
 */
@Service
public class DemandAOImpl implements IDemandAO {

    @Autowired
    private IDemandBO demandBO;

    @Override
    public String addDemand(Demand data) {
        return demandBO.saveDemand(data);
    }

    @Override
    public int editDemand(Demand data) {
        if (!demandBO.isDemandExist(data.getCode())) {
            throw new BizException("xn0000", "需求编号不存在");
        }
        return demandBO.refreshDemand(data);
    }

    @Override
    public int dropDemand(String code) {
        if (!demandBO.isDemandExist(code)) {
            throw new BizException("xn0000", "需求编号不存在");
        }
        return demandBO.removeDemand(code);
    }

    @Override
    public Paginable<Demand> queryDemandPage(int start, int limit,
            Demand condition) {
        return demandBO.getPaginable(start, limit, condition);
    }

    @Override
    public List<Demand> queryDemandList(Demand condition) {
        return demandBO.queryDemandList(condition);
    }

    @Override
    public Demand getDemand(String code) {
        return demandBO.getDemand(code);
    }

    /** 
     * @see com.cdkj.service.ao.IDemandAO#violationDemand(java.lang.String, java.lang.String, java.lang.String)
     */
    @Override
    public int violationDemand(String code, String dealer, String dealNote) {
        if (!demandBO.isDemandExist(code)) {
            throw new BizException("xn0000", "需求编号不存在");
        }
        return demandBO.refreshDemandStatus(code, dealer, dealNote);
    }
}
