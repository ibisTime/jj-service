/**
 * @Title IBusinessBO.java 
 * @Package com.xnjr.moom.bo 
 * @Description 
 * @author xieyj  
 * @date 2016年1月17日 下午12:00:57 
 * @version V1.0   
 */
package com.xnjr.mall.bo;

import java.util.Date;
import java.util.List;

import com.xnjr.mall.bo.base.IPaginableBO;
import com.xnjr.mall.domain.Business;
import com.xnjr.mall.enums.EBusinessVisual;

/** 
 * 业务
 * @author: xieyj 
 * @since: 2016年1月17日 下午12:00:57 
 * @history:
 */
public interface IBusinessBO extends IPaginableBO<Business> {

    public void saveBusiness(String code, String name, Long principal,
            Long profit, String hsbUrl, String hspzUrl, String fjUrl,
            Date startDatetime, Date endDatetime, String applyUser,
            String remark, String subjectCode, EBusinessVisual visual);

    public void refreshBusiness(String code, String name, Long principal,
            Long profit, String hsbUrl, String hspzUrl, String fjUrl,
            Date startDatetime, Date endDatetime, String applyUser,
            String remark);

    public void unpassBusiness(String businessCode, String checkUser,
            String checkNote);

    public void passBusiness(String businessCode, String checkUser,
            String checkNote);

    public List<Business> queryBusinessList(Business condition);

    public List<Business> queryCheckedBusinessList(String subjectCode);

    public Business getBusiness(String businessCode);

    public int refreshContract(String businessCode, String contractCode);

}
