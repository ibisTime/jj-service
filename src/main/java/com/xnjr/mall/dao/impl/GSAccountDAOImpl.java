package com.xnjr.mall.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.xnjr.mall.dao.IGSAccountDAO;
import com.xnjr.mall.dao.base.support.AMybatisTemplate;
import com.xnjr.mall.domain.GSAccount;

/**
 * 
 * @author: duanjiewen 
 * @since: 2016年4月19日 下午3:59:28 
 * @history:
 */
@Repository("gsAccountDAOImpl")
public class GSAccountDAOImpl extends AMybatisTemplate implements IGSAccountDAO {

    @Override
    public int insert(GSAccount data) {
        return super.insert(NAMESPACE.concat("insert_gsAccount"), data);
    }

    @Override
    public int delete(GSAccount data) {
        return 0;
    }

    @Override
    public GSAccount select(GSAccount condition) {
        return super.select(NAMESPACE.concat("select_gsAccount"), condition,
            GSAccount.class);
    }

    @Override
    public Long selectTotalCount(GSAccount condition) {
        return super.selectTotalCount(
            NAMESPACE.concat("select_gsAccount_count"), condition);
    }

    @Override
    public List<GSAccount> selectList(GSAccount condition) {
        return super.selectList(NAMESPACE.concat("select_gsAccount"),
            condition, GSAccount.class);
    }

    @Override
    public List<GSAccount> selectList(GSAccount condition, int start, int count) {
        return super.selectList(NAMESPACE.concat("select_gsAccount"), start,
            count, condition, GSAccount.class);
    }

    @Override
    public int updateAmount(GSAccount data) {
        return super.update(NAMESPACE.concat("update_gsAccountAmount"), data);
    }

    @Override
    public int updateFrozenAmount(GSAccount data) {
        return super.update(NAMESPACE.concat("update_gsAccountFrozenAmount"),
            data);
    }

    @Override
    public int updateStatus(GSAccount data) {
        return super.update(NAMESPACE.concat("update_gsAccountStatus"), data);
    }

}
