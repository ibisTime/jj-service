package com.xnjr.mall.bo.impl;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.xnjr.mall.bo.IGSTraderBO;
import com.xnjr.mall.bo.base.PaginableBOImpl;
import com.xnjr.mall.common.PhoneUtil;
import com.xnjr.mall.dao.IGSTraderDAO;
import com.xnjr.mall.domain.GSTrader;
import com.xnjr.mall.exception.BizException;

/** 
 * 操盘手
 * @author: wuql
 * @since: 2016年1月13日 上午11:10:12 
 * @history:
 */
@Component
public class GSTraderBOImpl extends PaginableBOImpl<GSTrader> implements
        IGSTraderBO {
    @Autowired
    private IGSTraderDAO gsTraderDAO;

    @Override
    public void checkTradePwd(String userId, String tradePwd) {
        if (StringUtils.isNotBlank(userId) && StringUtils.isNotBlank(tradePwd)) {
            GSTrader condition = new GSTrader();
            condition.setUserId(userId);
            // condition.setTradePwd(MD5Util.md5(tradePwd));
            long count = gsTraderDAO.selectTotalCount(condition);
            if (count != 1) {
                throw new BizException("jd00001", "交易密码错误");
            }
        } else {
            throw new BizException("jd00001", "交易密码错误");
        }
    }

    @Override
    public boolean isGSTraderExist(String userId) {
        GSTrader trader = new GSTrader();
        trader.setUserId(userId);
        if (gsTraderDAO.selectTotalCount(trader) == 1) {
            return true;
        }
        return false;
    }

    /** 
     * @see com.xnjr.moom.IGSTraderBO.ITraderBO#saveTrader(com.xnjr.mall.domain.GSTrader)
     */
    @Override
    public String saveGSTrader(GSTrader data) {
        String userId = null;
        if (data != null) {
            data.setUpdateDatetime(new Date());
            data.setTotalVolume(0L);
            data.setTotalCount(0L);
            data.setTotalProfit(0L);
            gsTraderDAO.insert(data);
            userId = data.getUserId();
        }
        return userId;
    }

    /** 
     * @see com.xnjr.moom.IGSTraderBO.ITraderBO#removeTrader(java.lang.String)
     */
    @Override
    public int removeTrader(String userId) {
        int count = 0;
        if (userId != null) {
            GSTrader data = new GSTrader();
            data.setUserId(userId);
            count = gsTraderDAO.delete(data);
        }
        return count;
    }

    /** 
     * @see com.xnjr.moom.IGSTraderBO.ITraderBO#refreshTrader(com.xnjr.mall.domain.GSTrader)
     */
    @Override
    public int refreshGSTrader(GSTrader data) {
        int count = 0;
        if (data != null) {
            data.setUpdateDatetime(new Date());
            count = gsTraderDAO.update(data);
        }
        return count;
    }

    @Override
    public GSTrader getGSTrader(String userId) {
        GSTrader gsTraderDO = null;
        if (StringUtils.isNotBlank(userId)) {
            GSTrader condition = new GSTrader();
            condition.setUserId(userId);
            gsTraderDO = gsTraderDAO.select(condition);
        }
        if (gsTraderDO == null) {
            throw new BizException("li01003", "操盘手" + userId + "不存在");
        }
        return gsTraderDO;
    }

    @Override
    public List<GSTrader> queryGSTraderList(GSTrader condition) {
        return gsTraderDAO.selectList(condition);
    }

    @Override
    public List<GSTrader> queryGSTraderListByUserId(String userId) {
        List<GSTrader> list = null;
        if (StringUtils.isNotBlank(userId)) {
            GSTrader condition = new GSTrader();
            condition.setUserId(userId);
            list = gsTraderDAO.selectList(condition);
        }
        return list;
    }

    /*
     * @Override public List<GSTrader> queryTraderListByCompanyId(String
     * companyId) { List<GSTrader> list = null; if
     * (StringUtils.isNotBlank(companyId)) { GSTrader condition = new
     * GSTrader(); condition.setCompanyId(companyId); list =
     * gsTraderDAO.selectList(condition); } return list; }
     */

    @Override
    public void isMobileExist(String mobile) {
        // 判断格式
        PhoneUtil.checkMobile(mobile);
        GSTrader condition = new GSTrader();
        condition.setMobile(mobile);
        long count = getTotalCount(condition);
        if (count > 0) {
            throw new BizException("li01003", "手机号已经存在");
        }
    }

    @Override
    public void refreshMobile(String userId, String mobile) {
        // 手机号校验
        isMobileExist(mobile);
        if (StringUtils.isNotBlank(userId)) {
            GSTrader data = new GSTrader();
            data.setUserId(userId);
            data.setMobile(mobile);
            gsTraderDAO.updateMobile(data);
        }
    }

    @Override
    public void refreshTradePwd(String userId, String tradePwd,
            String newTradePwdStrength) {
        if (StringUtils.isNotBlank(userId) && StringUtils.isNotBlank(tradePwd)
                && StringUtils.isNotBlank(newTradePwdStrength)) {
            GSTrader data = new GSTrader();
            data.setUserId(userId);
            // data.setTradePwd(MD5Util.md5(tradePwd));
            // data.setTradePwdStrength(PwdUtil.calculateSecurityLevel(tradePwd));
            gsTraderDAO.updateTradePwd(data);
        }
    }

    @Override
    public void refreshTotal(String traderId, Long principal, Long profit) {
        GSTrader data = this.getGSTrader(traderId);
        data.setTotalVolume(data.getTotalVolume() + principal);
        data.setTotalCount(data.getTotalCount() + 1);
        data.setTotalProfit(data.getTotalProfit() + profit);
        gsTraderDAO.updateTotal(data);
    }

    @Override
    public void refreshTradePwd(String userId, String tradePwd) {
        if (StringUtils.isNotBlank(userId) && StringUtils.isNotBlank(tradePwd)) {
            GSTrader data = new GSTrader();
            data.setUserId(userId);
            // data.setTradePwd(MD5Util.md5(tradePwd));
            // data.setTradePwdStrength(PwdUtil.calculateSecurityLevel(tradePwd));
            gsTraderDAO.updateTradePwd(data);
        }
    }
}
