/**
 * @Title PTCompanyPersonBOImpl.java 
 * @Package com.xnjr.moom.bo.impl 
 * @Description 
 * @author xieyj  
 * @date 2016年3月4日 下午10:27:05 
 * @version V1.0   
 */
package com.xnjr.mall.bo.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.xnjr.mall.bo.IPTCompanyPersonsBO;
import com.xnjr.mall.bo.base.PaginableBOImpl;
import com.xnjr.mall.core.OrderNoGenerater;
import com.xnjr.mall.dao.IPTCompanyPersonDAO;
import com.xnjr.mall.domain.PTCompanyPerson;
import com.xnjr.mall.exception.BizException;

/** 
 * @author: xieyj 
 * @since: 2016年3月4日 下午10:27:05 
 * @history:
 */
@Component
public class PTCompanyPersonBOImpl extends PaginableBOImpl<PTCompanyPerson>
        implements IPTCompanyPersonsBO {

    @Autowired
    private IPTCompanyPersonDAO ptCompanyPersonDAO;

    @Override
    public void checkPTCompanyPersonExist(String userId) {
        PTCompanyPerson condition = new PTCompanyPerson();
        condition.setUserId(userId);
        if (ptCompanyPersonDAO.selectTotalCount(condition) < 1) {
            throw new BizException("XNbk2000", "公司人员不存在！");
        }

    }

    @Override
    public String savePTCompanyPerson(PTCompanyPerson data) {
        String userId = null;
        if (data != null) {
            userId = OrderNoGenerater.generateM("CP");
            data.setUserId(userId);
            ptCompanyPersonDAO.insert(data);
        }
        return userId;
    }

    @Override
    public int removePTCompanyPerson(String userId) {
        int count = 0;
        if (StringUtils.isNotBlank(userId)) {
            PTCompanyPerson condition = new PTCompanyPerson();
            condition.setUserId(userId);
            count = ptCompanyPersonDAO.delete(condition);
        }
        return count;
    }

    @Override
    public int refreshPTCompanyPerson(PTCompanyPerson data) {
        int count = 0;
        if (data != null) {
            count = ptCompanyPersonDAO.update(data);
        }
        return count;
    }

    /** 
     * @see com.xnjr.mall.bo.IPTCompanyPersonsBO#removeCompanyPersonsByCompany(java.lang.String)
     */
    @Override
    public int removePTCompanyPersonByCompany(String companyCode) {
        int count = 0;
        if (StringUtils.isNotBlank(companyCode)) {
            PTCompanyPerson condition = new PTCompanyPerson();
            condition.setCompanyCode(companyCode);
            count = ptCompanyPersonDAO
                .deletePTCompanyPersonByCompany(condition);
        }
        return count;
    }

    /** 
     * @see com.xnjr.mall.bo.IPTCompanyPersonsBO#queryCompanyPersonsList(java.lang.String)
     */
    @Override
    public List<PTCompanyPerson> queryPTCompanyPersonList(
            PTCompanyPerson condition) {
        return ptCompanyPersonDAO.selectList(condition);

    }

    /** 
     * @see com.xnjr.mall.bo.IPTCompanyPersonsBO#getCompanyPersons(java.lang.String)
     */
    @Override
    public PTCompanyPerson getPTCompanyPerson(String userId) {
        PTCompanyPerson ptCompanyPerson = null;
        if (StringUtils.isNotBlank(userId)) {
            PTCompanyPerson condition = new PTCompanyPerson();
            condition.setUserId(userId);
            ptCompanyPerson = ptCompanyPersonDAO.select(condition);
        }
        return ptCompanyPerson;
    }

}
