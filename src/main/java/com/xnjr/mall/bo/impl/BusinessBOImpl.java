/**
 * @Title BusinessBOImpl.java 
 * @Package com.xnjr.moom.bo.impl 
 * @Description 
 * @author xieyj  
 * @date 2016年1月17日 下午12:09:26 
 * @version V1.0   
 */
package com.xnjr.mall.bo.impl;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.xnjr.mall.bo.IBusinessBO;
import com.xnjr.mall.bo.base.PaginableBOImpl;
import com.xnjr.mall.dao.IBusinessDAO;
import com.xnjr.mall.domain.Business;
import com.xnjr.mall.enums.EBusinessStatus;
import com.xnjr.mall.enums.EBusinessVisual;

/** 
 * 业务
 * @author: xieyj 
 * @since: 2016年1月17日 下午12:09:26 
 * @history:
 */
@Component
public class BusinessBOImpl extends PaginableBOImpl<Business> implements
        IBusinessBO {

    @Autowired
    private IBusinessDAO businessDAO;

    @Override
    public void saveBusiness(String code, String name, Long principal,
            Long profit, String hsbUrl, String hspzUrl, String fjUrl,
            Date startDatetime, Date endDatetime, String applyUser,
            String remark, String subjectCode, EBusinessVisual visual) {
        Business business = new Business();
        business.setCode(code);
        business.setName(name);
        business.setStatus(EBusinessStatus.todoCheck.getCode());
        business.setPrincipal(principal);
        business.setProfit(profit);

        business.setHsbUrl(hsbUrl);
        business.setHspzUrl(hspzUrl);
        business.setFjUrl(fjUrl);
        business.setStartDatetime(startDatetime);
        business.setEndDatetime(endDatetime);

        business.setApplyUser(applyUser);
        business.setApplyDatetime(new Date());
        business.setRemark(remark);
        business.setSubjectCode(subjectCode);
        business.setIsVisual(visual.getCode());
        businessDAO.insert(business);
    }

    @Override
    public void refreshBusiness(String code, String name, Long principal,
            Long profit, String hsbUrl, String hspzUrl, String fjUrl,
            Date startDatetime, Date endDatetime, String applyUser,
            String remark) {
        Business business = new Business();
        business.setCode(code);
        business.setName(name);
        business.setStatus(EBusinessStatus.todoCheck.getCode());
        business.setPrincipal(principal);
        business.setProfit(profit);

        business.setHsbUrl(hsbUrl);
        business.setHspzUrl(hspzUrl);
        business.setFjUrl(fjUrl);
        business.setStartDatetime(startDatetime);
        business.setEndDatetime(endDatetime);

        business.setApplyUser(applyUser);
        business.setApplyDatetime(new Date());
        business.setRemark(remark);
        businessDAO.updateBusiness(business);
    }

    @Override
    public void unpassBusiness(String businessCode, String checkUser,
            String checkNote) {
        Business business = new Business();
        business.setCode(businessCode);
        business.setCheckUser(checkUser);
        business.setCheckDatetime(new Date());
        business.setRemark(checkNote);
        business.setStatus(EBusinessStatus.CHECK_NO.getCode());
        businessDAO.unpassBusiness(business);
    }

    @Override
    public void passBusiness(String businessCode, String checkUser,
            String checkNote) {
        Business business = new Business();
        business.setCode(businessCode);
        business.setCheckUser(checkUser);
        business.setCheckDatetime(new Date());
        business.setRemark(checkNote);
        business.setStatus(EBusinessStatus.CHECK_YES.getCode());
        businessDAO.passBusiness(business);
    }

    @Override
    public List<Business> queryBusinessList(Business condition) {
        return businessDAO.selectList(condition);
    }

    @Override
    public List<Business> queryCheckedBusinessList(String subjectCode) {
        Business condition = new Business();
        condition.setSubjectCode(subjectCode);
        condition.setStatus(EBusinessStatus.CHECK_YES.getCode());
        return queryBusinessList(condition);
    }

    @Override
    public Business getBusiness(String businessCode) {
        Business business = new Business();
        if (!StringUtils.isBlank(businessCode)) {
            business.setCode(businessCode);
        }
        return businessDAO.select(business);
    }

    @Override
    public int refreshContract(String businessCode, String contractCode) {
        Business business = new Business();
        business.setCode(businessCode);
        business.setContractCode(contractCode);
        return businessDAO.updateContract(business);
    }

}
