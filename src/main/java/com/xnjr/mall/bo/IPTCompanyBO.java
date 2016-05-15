/**
 * @Title IPTCompanyBO.java 
 * @Package com.xnjr.moom.bo 
 * @Description 
 * @author haiqingzheng  
 * @date 2016年3月4日 下午9:01:30 
 * @version V1.0   
 */
package com.xnjr.mall.bo;

import java.util.List;

import com.xnjr.mall.bo.base.IPaginableBO;
import com.xnjr.mall.domain.PTCompany;

/** 
 * @author: haiqingzheng 
 * @since: 2016年3月4日 下午9:01:30 
 * @history:
 */
public interface IPTCompanyBO extends IPaginableBO<PTCompany> {
    public void checkPTCompanyExist(String code);

    public void checkPTCompanyExistByName(String name);

    public String savePTCompany(PTCompany data);

    public int refreshPTCompany(PTCompany data);

    public int removePTCompany(String code);

    public List<PTCompany> queryPTCompanyList(PTCompany data);

    public PTCompany getPTCompany(String code);
}
