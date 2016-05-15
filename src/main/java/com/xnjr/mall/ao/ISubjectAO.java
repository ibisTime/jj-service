package com.xnjr.mall.ao;

import java.util.List;

import com.xnjr.mall.bo.base.Paginable;
import com.xnjr.mall.domain.Subject;
import com.xnjr.mall.spring.ServiceModule;

/** 
 * @author: wuql
 * @since: 2016年1月19日 上午11:34:10 
 * @history:
 */
@ServiceModule
public interface ISubjectAO {
    String DEFAULT_ORDER_COLUMN = "code";

    /**
     * 开始项目
     * @param subjectCode
     * @param tradePwd
     * @param remark 
     * @create: 2016年1月19日 下午9:32:48 myb858
     * @history:
     */
    public void startSubject(String subjectCode, String tradePwd, String remark);

    /**
     * 流项目
     * @param subjectCode
     * @param tradePwd
     * @param remark 
     * @create: 2016年1月19日 下午9:56:15 myb858
     * @history:
     */
    public void cancelSubject(String subjectCode, String tradePwd, String remark);

    /**
     * 结束项目
     * @param subjectCode
     * @param tradePwd
     * @param remark 
     * @create: 2016年1月19日 下午10:06:04 myb858
     * @history:
     */
    public void stopSubject(String subjectCode, String tradePwd, String remark);

    /**
     * 分页查询项目列表
     * @param start
     * @param limit
     * @param condition
     * @return 
     * @create: 2016年1月19日 下午1:18:56 wuql
     * @history:
     */
    public Paginable<Subject> querySubjectPage(int start, int limit,
            Subject condition);

    /**
     * 查询项目列表
     * @param condition
     * @return 
     * @create: 2016年1月19日 下午1:19:39 wuql
     * @history:
     */
    public List<Subject> querySubjectList(Subject condition);

    /**
     * 项目详情
     * @param investCode
     * @return 
     * @create: 2016年1月19日 下午1:19:57 wuql
     * @history:
     */
    public Subject getSubject(String subjectCode);

    public Subject getSubject(String subjectCode, String userId);

}
