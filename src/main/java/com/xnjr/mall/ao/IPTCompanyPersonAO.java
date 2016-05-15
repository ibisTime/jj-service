/**
 * @Title IPTCompanyPersonAO.java 
 * @Package com.xnjr.moom.ao 
 * @Description 
 * @author xieyj  
 * @date 2016年3月4日 下午10:53:27 
 * @version V1.0   
 */
package com.xnjr.mall.ao;

import java.util.List;

import com.xnjr.mall.bo.base.Paginable;
import com.xnjr.mall.domain.PTCompanyPerson;
import com.xnjr.mall.spring.ServiceModule;

/** 
 * @author: xieyj 
 * @since: 2016年3月4日 下午10:53:27 
 * @history:
 */
@ServiceModule
public interface IPTCompanyPersonAO {
    String DEFAULT_ORDER_COLUMN = "user_id";

    public String addPTCompanyPerson(PTCompanyPerson data);

    public int dropPTCompanyPerson(String userId);

    public int editPTCompanyPerson(PTCompanyPerson data);

    public List<PTCompanyPerson> queryPTCompanyPersonList(PTCompanyPerson data);

    public Paginable<PTCompanyPerson> queryPTCompanyPersonPage(int start,
            int limit, PTCompanyPerson data);

    public PTCompanyPerson getPTCompanyPerson(String userId);

}
