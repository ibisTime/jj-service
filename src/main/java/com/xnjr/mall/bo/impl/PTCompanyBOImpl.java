/**
 * @Title PtCompanyBOImpl.java 
 * @Package com.xnjr.moom.bo.impl 
 * @Description 
 * @author haiqingzheng  
 * @date 2016年3月4日 下午9:08:27 
 * @version V1.0   
 */
package com.xnjr.mall.bo.impl;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.xnjr.mall.bo.IPTCompanyBO;
import com.xnjr.mall.bo.base.PaginableBOImpl;
import com.xnjr.mall.core.OrderNoGenerater;
import com.xnjr.mall.dao.IPTCompanyDAO;
import com.xnjr.mall.domain.PTCompany;
import com.xnjr.mall.exception.BizException;

/** 
 * @author: haiqingzheng 
 * @since: 2016年3月4日 下午9:08:27 
 * @history:
 */
@Component
public class PTCompanyBOImpl extends PaginableBOImpl<PTCompany> implements
        IPTCompanyBO {
    @Autowired
    private IPTCompanyDAO ptCompanyDAO;

    @Override
    public void checkPTCompanyExist(String code) {
        PTCompany condition = new PTCompany();
        condition.setCode(code);
        if (ptCompanyDAO.selectTotalCount(condition) < 1) {
            throw new BizException("XNbk2000", "公司不存在！");
        }
    }

    @Override
    public void checkPTCompanyExistByName(String zwName) {
        PTCompany condition = new PTCompany();
        condition.setZwName(zwName);
        if (ptCompanyDAO.selectTotalCount(condition) >= 1) {
            throw new BizException("XNbk2000", "公司已经存在！");
        }

    }

    @Override
    public String savePTCompany(PTCompany data) {
        String code = null;
        if (data != null) {
            code = OrderNoGenerater.generateM("PC");
            data.setCode(code);
            ptCompanyDAO.insert(data);
        }
        return code;
    }

    @Override
    public int refreshPTCompany(PTCompany data) {
        int count = 0;
        if (data != null) {
            count = ptCompanyDAO.updatePTCompany(data);
        }
        return count;
    }

    /** 
     * @see com.xnjr.mall.bo.IPTCompanyBO#removePlatCompany(java.lang.String)
     */
    @Override
    public int removePTCompany(String code) {
        int count = 0;
        if (StringUtils.isNotBlank(code)) {
            PTCompany condition = new PTCompany();
            condition.setCode(code);
            count = ptCompanyDAO.delete(condition);
        }
        return count;
    }

    /** 
     * @see com.xnjr.mall.bo.IPTCompanyBO#queryPlatCompanyList(com.xnjr.mall.domain.PTCompany)
     */
    @Override
    public List<PTCompany> queryPTCompanyList(PTCompany data) {
        return ptCompanyDAO.selectList(data);
    }

    /** 
     * @see com.xnjr.mall.bo.IPTCompanyBO#getPlatCompany(java.lang.String)
     */
    @Override
    public PTCompany getPTCompany(String code) {
        PTCompany ptCompany = null;
        if (StringUtils.isNotBlank(code)) {
            PTCompany condition = new PTCompany();
            condition.setCode(code);
            if (getTotalCount(condition) <= 0) {
                throw new BizException("XN803000", "不存在编号为" + code + "的公司");
            }
            ptCompany = ptCompanyDAO.select(condition);
        }
        return ptCompany;
    }

}
