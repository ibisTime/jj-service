/**
 * @Title ISubjectBO.java 
 * @Package com.xnjr.moom.bo 
 * @Description 
 * @author haiqingzheng  
 * @date 2016年1月17日 下午3:28:53 
 * @version V1.0   
 */
package com.xnjr.mall.bo;

import java.util.List;

import com.xnjr.mall.bo.base.IPaginableBO;
import com.xnjr.mall.domain.Project;
import com.xnjr.mall.domain.Subject;

/** 
 * @author: haiqingzheng 
 * @since: 2016年1月17日 下午3:28:53 
 * @history:
 */
public interface ISubjectBO extends IPaginableBO<Subject> {
    public String saveSubject(Project project);

    public void startSubject(Subject subject, String remark);

    public void cancelSubject(Subject subject, String remark);

    public void stopSubject(Subject subject, String remark);

    public Subject getSubject(String subjectCode);

    public List<Subject> querySubjectList(Subject condition);

    public List<Subject> queryMySubjectList(Subject condition);

    public Subject getSubjectByProjectCode(String projectCode);

    public void refreshTotal(String subjectCode, long totalPrincipal,
            long totalProfit);

}
