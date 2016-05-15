/**
 * @Title PTCompanyAOImpl.java 
 * @Package com.xnjr.moom.ao.impl 
 * @Description 
 * @author haiqingzheng  
 * @date 2016年3月4日 下午9:37:38 
 * @version V1.0   
 */
package com.xnjr.mall.ao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xnjr.mall.ao.IPTCompanyAO;
import com.xnjr.mall.bo.IPTCompanyBO;
import com.xnjr.mall.bo.base.Paginable;
import com.xnjr.mall.domain.PTCompany;

/** 
 * @author: haiqingzheng 
 * @since: 2016年3月4日 下午9:37:38 
 * @history:
 */
@Service
public class PTCompanyAOImpl implements IPTCompanyAO {
    @Autowired
    IPTCompanyBO ptCompanyBO;

    @Override
    public String addPTCompany(PTCompany data) {
        ptCompanyBO.checkPTCompanyExistByName(data.getZwName());
        return ptCompanyBO.savePTCompany(data);
    }

    @Override
    public int dropPTCompany(String code) {
        ptCompanyBO.checkPTCompanyExist(code);
        return ptCompanyBO.removePTCompany(code);
    }

    @Override
    public int editPTCompany(PTCompany data) {
        ptCompanyBO.checkPTCompanyExist(data.getCode());
        return ptCompanyBO.refreshPTCompany(data);
    }

    /** 
     * @see com.xnjr.mall.ao.IPTCompanyAO#queryPlatCompanyList(com.xnjr.mall.domain.PTCompany)
     */
    @Override
    public List<PTCompany> queryPTCompanyList(PTCompany data) {
        return ptCompanyBO.queryPTCompanyList(data);
    }

    /** 
     * @see com.xnjr.mall.ao.IPTCompanyAO#getPlatCompany(java.lang.String)
     */
    @Override
    public PTCompany getPTCompany(String code) {
        return ptCompanyBO.getPTCompany(code);
    }

    @Override
    public Paginable<PTCompany> queryPTCompanyPage(int start, int limit,
            PTCompany data) {
        return ptCompanyBO.getPaginable(start, limit, data);
    }

}
