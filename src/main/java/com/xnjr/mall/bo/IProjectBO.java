package com.xnjr.mall.bo;

import java.util.List;

import com.xnjr.mall.bo.base.IPaginableBO;
import com.xnjr.mall.domain.GSTrader;
import com.xnjr.mall.domain.Project;
import com.xnjr.mall.dto.req.XNyw4000Req;
import com.xnjr.mall.dto.req.XNyw4001Req;
import com.xnjr.mall.enums.EProjectStatus;

public interface IProjectBO extends IPaginableBO<Project> {

    /**
     * 发起标的
     * @param req
     * @return 
     * @create: 2016年1月18日 下午9:23:12 xieyj
     * @history:
     */
    public String applyProject(XNyw4000Req req, GSTrader trader);

    /**
     * 重新发起标的
     * @param req 
     * @create: 2016年1月18日 下午9:23:32 xieyj
     * @history:
     */
    public void reapplyProject(XNyw4001Req req, GSTrader trader);

    /**
     * 审核通过
     * @param projectCode
     * @param checkUser
     * @param checkRemark
     * @return 
     * @create: 2016年1月18日 下午9:23:46 xieyj
     * @history:
     */
    public void checkPass(String projectCode, String checkUser,
            String checkNote, Long period, String inputRepayDatetime);

    /**
     * 审核不通过
     * @param projectCode
     * @param checkUser
     * @param checkRemark
     * @return 
     * @create: 2016年1月18日 下午9:23:59 xieyj
     * @history:
     */
    public void checkUnpass(String projectCode, String checkUser,
            String checkNote);

    /**
     * 强制结束
     * @param projectCode
     * @param checkUser
     * @param checkNote 
     * @create: 2016年1月19日 下午5:59:03 myb858
     * @history:
     */
    public void forbidProject(String projectCode, String checkUser,
            String checkNote);

    /**
     * 更新标的可投金额
     * @param project
     * @param investAmount 
     * @create: 2016年1月24日 上午9:59:24 myb858
     * @history:
     */
    public void refreshLoanedAmount(Project project, Long investAmount);

    /**
     * 标的状态变化
     * @param projectCode
     * @param projectStatus 
     * @create: 2015年11月26日 下午3:53:59 myb858
     * @history:
     */
    public void refreshStatus(Project project, EProjectStatus projectStatus);

    /**
     * 根据标的编号获取详情
     * @param projectCode
     * @return 
     * @create: 2016年1月18日 下午9:25:48 xieyj
     * @history:
     */
    public Project getProject(String projectCode);

    /**
     * 查询标的列表
     * @param condition
     * @return 
     * @create: 2016年1月18日 下午9:27:05 xieyj
     * @history:
     */
    public List<Project> queryProjectList(Project condition);

}
