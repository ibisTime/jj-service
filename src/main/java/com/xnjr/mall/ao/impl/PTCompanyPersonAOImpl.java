/**
 * @Title PTCompanyPersonAOImpl.java 
 * @Package com.xnjr.moom.ao.impl 
 * @Description 
 * @author xieyj  
 * @date 2016年3月5日 上午10:07:24 
 * @version V1.0   
 */
package com.xnjr.mall.ao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xnjr.mall.ao.IPTCompanyPersonAO;
import com.xnjr.mall.bo.IPTCompanyBO;
import com.xnjr.mall.bo.IPTCompanyPersonsBO;
import com.xnjr.mall.bo.base.Paginable;
import com.xnjr.mall.domain.PTCompanyPerson;

/** 
 * @author: xieyj 
 * @since: 2016年3月5日 上午10:07:24 
 * @history:
 */
@Service
public class PTCompanyPersonAOImpl implements IPTCompanyPersonAO {

    @Autowired
    IPTCompanyPersonsBO ptCompanyPersonBO;

    @Autowired
    IPTCompanyBO ptCompanyBO;

    @Override
    public String addPTCompanyPerson(PTCompanyPerson data) {
        ptCompanyBO.checkPTCompanyExist(data.getCompanyCode());
        return ptCompanyPersonBO.savePTCompanyPerson(data);
    }

    @Override
    public int dropPTCompanyPerson(String userId) {
        ptCompanyPersonBO.checkPTCompanyPersonExist(userId);
        return ptCompanyPersonBO.removePTCompanyPerson(userId);
    }

    @Override
    public int editPTCompanyPerson(PTCompanyPerson data) {
        ptCompanyPersonBO.checkPTCompanyPersonExist(data.getUserId());
        ptCompanyBO.checkPTCompanyExist(data.getCompanyCode());
        return ptCompanyPersonBO.refreshPTCompanyPerson(data);
    }

    @Override
    public List<PTCompanyPerson> queryPTCompanyPersonList(PTCompanyPerson data) {
        return ptCompanyPersonBO.queryPTCompanyPersonList(data);
    }

    /** 
     * @see com.xnjr.mall.ao.IPTCompanyPersonAO#queryCompanyPersonsPage(int, int, com.xnjr.mall.domain.PTCompanyPerson)
     */
    @Override
    public Paginable<PTCompanyPerson> queryPTCompanyPersonPage(int start,
            int limit, PTCompanyPerson data) {
        return ptCompanyPersonBO.getPaginable(start, limit, data);
    }

    /** 
     * @see com.xnjr.mall.ao.IPTCompanyPersonAO#getCompanyPersons(java.lang.String)
     */
    @Override
    public PTCompanyPerson getPTCompanyPerson(String userId) {
        return ptCompanyPersonBO.getPTCompanyPerson(userId);
    }

}
