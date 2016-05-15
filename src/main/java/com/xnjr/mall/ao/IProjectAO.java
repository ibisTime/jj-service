package com.xnjr.mall.ao;

import java.util.Date;
import java.util.List;

import com.xnjr.mall.bo.base.Paginable;
import com.xnjr.mall.domain.Project;
import com.xnjr.mall.dto.req.XNyw4000Req;
import com.xnjr.mall.dto.req.XNyw4001Req;
import com.xnjr.mall.spring.ServiceModule;

@ServiceModule
public interface IProjectAO {
    String DEFAULT_ORDER_COLUMN = "code";

    /**
    * 发起项目
    * @param req
    * @return
    * @create: 2015年11月14日 上午2:29:12 myb858
    * @history:
    */
    public String applyProject(XNyw4000Req req);

    /**
    * 再次发起项目
    * @param req
    * @return
    * @create: 2015年11月14日 下午4:02:34 myb858
    * @history:
    */
    public void reapplyProject(XNyw4001Req req);

    /**
     * 初审项目
     * @param projectCode
     * @param checkUser
     * @param checkResult
     * @param checkNote
     * @param tradePwd
     * @param period
     * @param repayDatetime 
     * @create: 2016年1月22日 下午9:40:20 myb858
     * @history:
     */
    public void checkProject(String projectCode, String checkUser,
            String checkResult, String checkNote, String tradePwd, Long period,
            String repayDatetime);

    /**
     *  复审项目（强制结束标的）
     * @param projectCode
     * @param recheckUser
     * @param recheckNote
     * @param tradePwd 
     * @create: 2016年1月20日 下午3:55:10 myb858
     * @history:
     */
    public void forbidProject(String projectCode, String checkUser,
            String checkNote, String tradePwd);

    /**
     * 项目列表分页查询（可按条件查询）
     * @param type
     * @param status
     * @param period
     * @param interestRate
     * @param siteLocation
     * @param companyId
     * @param userId
     * @param applyUser
     * @param checkUser
     * @param recheckUser
     * @return 
     * @create: 2015年11月14日 下午12:13:42 haiqingzheng
     * @history:
     */
    public Paginable<Project> queryProjectPage(int start, int limit,
            Project condition);

    /**
     * 按条件查询项目列表
     * @param condition
     * @return 
     * @create: 2015年12月12日 下午3:39:20 haiqingzheng
     * @history:
     */
    public List<Project> queryProjectList(Project condition);

    /**
     * 按条件查询项目列表:需要过滤，供前端用户用
     * @param condition
     * @return 
     * @create: 2015年12月12日 下午3:39:20 haiqingzheng
     * @history:
     */
    public List<Project> queryProjectList(Project condition, String userId);

    /**
     * 按条件查询项目列表:需要过滤，供前端用户用
     * @param condition
     * @return 
     * @create: 2015年12月12日 下午3:39:20 haiqingzheng
     * @history:
     */
    public Paginable<Project> queryProjectPage(int start, int limit,
            Project condition, String userId);

    /**
     * 获取项目详情
     * @param projectCode
     * @return 
     * @create: 2015年11月14日 下午12:55:56 haiqingzheng
     * @history:
     */
    public Project getProject(String projectCode);

    /**
     * 获取项目详情:需要过滤，供前端用
     * @param projectCode
     * @param userId
     * @return 
     * @create: 2016年1月22日 下午1:28:55 myb858
     * @history:
     */
    public Project getProject(String projectCode, String userId);

    /**
     * 预算收益
     * @param projectCode
     * @param investAmount
     * @param investDate
     * @return 
     * @create: 2015年11月16日 下午1:01:55 myb858
     * @history:
     */
    public Long previewInterest(String projectCode, Long investAmount,
            Date investDatetime);

    /**
     * 每日定时任务:必须每天12点启动
     * 1，募集结束日到了，却还没有满标的项目====>自动满标
     * @create: 2015年11月17日 下午2:58:26 myb858
     * @history:
     */
    public void changeDaily();

}
