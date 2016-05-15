/**
 * @Title IPTCompanyAO.java 
 * @Package com.xnjr.moom.ao 
 * @Description 
 * @author haiqingzheng  
 * @date 2016年3月4日 下午9:32:15 
 * @version V1.0   
 */
package com.xnjr.mall.ao;

import java.util.List;

import com.xnjr.mall.bo.base.Paginable;
import com.xnjr.mall.domain.PTCompany;

/** 
 * @author: haiqingzheng 
 * @since: 2016年3月4日 下午9:32:15 
 * @history:
 */
public interface IPTCompanyAO {
    String DEFAULT_ORDER_COLUMN = "code";

    public String addPTCompany(PTCompany data);

    public int editPTCompany(PTCompany data);

    public int dropPTCompany(String code);

    public List<PTCompany> queryPTCompanyList(PTCompany data);

    public Paginable<PTCompany> queryPTCompanyPage(int start, int limit,
            PTCompany data);

    public PTCompany getPTCompany(String code);
}
