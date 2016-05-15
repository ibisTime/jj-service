package com.xnjr.mall.dao;

import java.util.List;

import com.xnjr.mall.dao.base.IBaseDAO;
import com.xnjr.mall.domain.InvestTable;

/**
 * 业务
 * @author: xieyj 
 * @since: 2016年1月17日 上午10:44:37 
 * @history:
 */
public interface IInvestTableDAO extends IBaseDAO<InvestTable> {
    String NAMESPACE = IInvestTableDAO.class.getName().concat(".");

    /**
     * 修改认购打款记录
     * @param data
     * @return 
     * @create: 2016年1月20日 下午7:47:29 wuql
     * @history:
     */
    public int update(InvestTable data);

    public Long selectSumAmount(InvestTable condition);

    /**
     * 根据项目编号获取打款记录列表
     * @param condition
     * @return 
     * @create: 2016年5月3日 上午8:23:44 xieyj
     * @history:
     */
    public List<InvestTable> selectSubjectInvestTable(InvestTable condition);
}
