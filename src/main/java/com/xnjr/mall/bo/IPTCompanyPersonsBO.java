package com.xnjr.mall.bo;

import java.util.List;

import com.xnjr.mall.bo.base.IPaginableBO;
import com.xnjr.mall.domain.PTCompanyPerson;

/**
 * 公司人员
 * @author: xieyj 
 * @since: 2016年3月4日 下午10:16:53 
 * @history:
 */
public interface IPTCompanyPersonsBO extends IPaginableBO<PTCompanyPerson> {
    public void checkPTCompanyPersonExist(String userId);

    public String savePTCompanyPerson(PTCompanyPerson data);

    public int removePTCompanyPerson(String userId);

    public int refreshPTCompanyPerson(PTCompanyPerson data);

    public List<PTCompanyPerson> queryPTCompanyPersonList(
            PTCompanyPerson condition);

    public PTCompanyPerson getPTCompanyPerson(String userId);

    public int removePTCompanyPersonByCompany(String companyCode);
}
