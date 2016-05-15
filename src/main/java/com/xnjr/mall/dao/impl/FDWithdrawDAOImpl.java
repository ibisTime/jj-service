package com.xnjr.mall.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.xnjr.mall.dao.IFDWithdrawDAO;
import com.xnjr.mall.dao.base.support.AMybatisTemplate;
import com.xnjr.mall.domain.FDWithdraw;

/**
 * 
 * @author: duanjiewen 
 * @since: 2016年4月19日 下午2:46:32 
 * @history:
 */
@Repository("fdWithdrawDAOImpl")
public class FDWithdrawDAOImpl extends AMybatisTemplate implements
        IFDWithdrawDAO {

    @Override
    public int insert(FDWithdraw data) {
        return super.insert(NAMESPACE.concat("insert_fdWithdraw"), data);
    }

    @Override
    public int delete(FDWithdraw data) {
        return 0;
    }

    @Override
    public FDWithdraw select(FDWithdraw condition) {
        return super.select(NAMESPACE.concat("select_fdWithdraw"), condition,
            FDWithdraw.class);
    }

    @Override
    public Long selectTotalCount(FDWithdraw condition) {
        return super.selectTotalCount(
            NAMESPACE.concat("select_fdWithdraw_count"), condition);
    }

    @Override
    public List<FDWithdraw> selectList(FDWithdraw condition) {
        return super.selectList(NAMESPACE.concat("select_fdWithdraw"),
            condition, FDWithdraw.class);
    }

    @Override
    public List<FDWithdraw> selectList(FDWithdraw condition, int start,
            int count) {
        return super.selectList(NAMESPACE.concat("select_fdWithdraw"), start,
            count, condition, FDWithdraw.class);
    }

    @Override
    public int updateApproveOrder(FDWithdraw data) {
        return super.update(NAMESPACE.concat("update_approve_order"), data);
    }

    @Override
    public int updatePayOrder(FDWithdraw data) {
        return super.update(NAMESPACE.concat("update_pay_order"), data);
    }

    @Override
    public int updateCheckOrder(FDWithdraw data) {
        return super.update(NAMESPACE.concat("update_check_order"), data);
    }

}
