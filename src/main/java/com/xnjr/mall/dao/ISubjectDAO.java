/**
 * @Title ISubjectDAO.java 
 * @Package com.xnjr.moom.dao 
 * @Description 
 * @author haiqingzheng  
 * @date 2016年1月16日 下午8:50:17 
 * @version V1.0   
 */
package com.xnjr.mall.dao;

import java.util.List;

import com.xnjr.mall.dao.base.IBaseDAO;
import com.xnjr.mall.domain.Subject;

/** 
 * @author: haiqingzheng 
 * @since: 2016年1月16日 下午8:50:17 
 * @history:
 */
public interface ISubjectDAO extends IBaseDAO<Subject> {
    String NAMESPACE = ISubjectDAO.class.getName().concat(".");

    int startSubject(Subject data);

    int cancelSubject(Subject data);

    int stopSubject(Subject data);

    int updateTotal(Subject data);

    public List<Subject> selectMySubjectList(Subject condition);

}
