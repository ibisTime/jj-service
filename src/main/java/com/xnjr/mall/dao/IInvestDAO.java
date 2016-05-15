package com.xnjr.mall.dao;

import java.util.List;

import com.xnjr.mall.dao.base.IBaseDAO;
import com.xnjr.mall.domain.Invest;
import com.xnjr.mall.domain.Subject;

/**
 * 投资记录DAO
 * @author: xieyj 
 * @since: 2015年11月13日 上午10:31:38 
 * @history:
 */
public interface IInvestDAO extends IBaseDAO<Invest> {
    String NAMESPACE = IInvestDAO.class.getName().concat(".");

    /**
     * 获取某个项目投资总额
     * @param condition
     * @return 
     * @create: 2015年11月14日 下午8:37:35 haiqingzheng
     * @history:
     */
    public Long selectTotalAmount(Invest condition);

    public int confirmInvest(Invest data);

    public int cancelInvest(Invest data);

    public List<Subject> selectMySubjectList(Invest condition);
}
