/**
 * @Title SubjectBOImpl.java 
 * @Package com.xnjr.moom.bo.impl 
 * @Description 
 * @author haiqingzheng  
 * @date 2016年1月17日 下午3:32:21 
 * @version V1.0   
 */
package com.xnjr.mall.bo.impl;

import java.util.Date;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.xnjr.mall.bo.ISubjectBO;
import com.xnjr.mall.bo.base.PaginableBOImpl;
import com.xnjr.mall.core.OrderNoGenerater;
import com.xnjr.mall.dao.ISubjectDAO;
import com.xnjr.mall.domain.Project;
import com.xnjr.mall.domain.Subject;
import com.xnjr.mall.enums.ESubjectStatus;

/** 
 * @author: haiqingzheng 
 * @since: 2016年1月17日 下午3:32:21 
 * @history:
 */
@Component
public class SubjectBOImpl extends PaginableBOImpl<Subject> implements
        ISubjectBO {
    @Autowired
    private ISubjectDAO subjectDAO;

    @Override
    public String saveSubject(Project project) {
        String code = null;
        if (project != null) {
            Subject data = new Subject();
            code = OrderNoGenerater.generateM("S");
            data.setCode(code);
            data.setStatus(ESubjectStatus.todoStart.getCode());
            data.setTotalAmount(project.getTotalAmount());
            data.setTotalPrincipal(0L);

            data.setTotalProfit(0L);
            data.setName(project.getName());
            data.setServe(project.getServe());
            data.setQuote(project.getQuote());
            data.setQuoteValue1(project.getQuoteValue1());

            data.setQuoteValue2(project.getQuoteValue2());
            data.setLevel(project.getLevel());
            data.setTrader(project.getTrader());
            data.setTraderName(project.getTraderName());
            data.setRemark(ESubjectStatus.todoStart.getValue());

            data.setProjectCode(project.getCode());
            subjectDAO.insert(data);
        }
        return code;
    }

    @Override
    public void startSubject(Subject subject, String remark) {
        subject.setStatus(ESubjectStatus.Started.getCode());
        subject.setRemark(remark);
        subject.setStartDatetime(new Date());
        subjectDAO.startSubject(subject);
    }

    @Override
    public void cancelSubject(Subject subject, String remark) {
        subject.setStatus(ESubjectStatus.Unstart.getCode());
        subject.setRemark(remark);
        subject.setEndDatetime(new Date());
        subjectDAO.cancelSubject(subject);
    }

    @Override
    public void stopSubject(Subject subject, String remark) {
        subject.setStatus(ESubjectStatus.END.getCode());
        subject.setRemark(remark);
        subject.setEndDatetime(new Date());
        subjectDAO.stopSubject(subject);
    }

    @Override
    public void refreshTotal(String subjectCode, long totalPrincipal,
            long totalProfit) {
        Subject data = new Subject();
        data.setCode(subjectCode);
        data.setTotalPrincipal(totalPrincipal);
        data.setTotalProfit(totalProfit);
        subjectDAO.updateTotal(data);
    }

    @Override
    public Subject getSubject(String subjectCode) {
        Subject data = null;
        if (!StringUtils.isBlank(subjectCode)) {
            Subject condition = new Subject();
            condition.setCode(subjectCode);
            data = subjectDAO.select(condition);
        }
        return data;
    }

    @Override
    public List<Subject> querySubjectList(Subject condition) {
        return subjectDAO.selectList(condition);
    }

    @Override
    public List<Subject> queryMySubjectList(Subject condition) {
        return subjectDAO.selectMySubjectList(condition);
    }

    @Override
    public Subject getSubjectByProjectCode(String projectCode) {
        Subject subject = null;
        if (StringUtils.isNotBlank(projectCode)) {
            Subject condition = new Subject();
            condition.setProjectCode(projectCode);
            List<Subject> list = subjectDAO.selectList(condition);
            if (CollectionUtils.isNotEmpty(list)) {
                subject = list.get(0);
            }
        }
        return subject;
    }
}
