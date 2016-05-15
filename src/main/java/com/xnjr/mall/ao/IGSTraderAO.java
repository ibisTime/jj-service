/**
 * @Title IGSTraderAO.java 
 * @Package com.xnjr.moom.ao
 * @Description 
 * @author wuql
 * @date 2016年1月13日 下午1:27:17
 * @version V1.0   
 */
package com.xnjr.mall.ao;

import java.util.List;

import com.xnjr.mall.bo.base.Paginable;
import com.xnjr.mall.domain.GSTrader;
import com.xnjr.mall.spring.ServiceModule;

/** 
 * @author: wuql
 * @since: 2016年1月13日 下午1:27:17 
 * @history:
 */
@ServiceModule
public interface IGSTraderAO {
    String DEFAULT_ORDER_COLUMN = "update_datetime";

    /**
     * 操盘手-增加
     * @param 
     * @return 
     * @create: 2016年1月13日 下午1:27:17  Wuql
     * @history:
     */
    public String addGSTrader(GSTrader data);

    /**
     * 操盘手-修改
     * @param userId
     * @return 
     * @create: 2016年1月13日 下午1:27:17  Wuql
     * @history:
     */
    public boolean editGSTrader(GSTrader data);

    /**
     * 操盘手-分页查询
     * @param start
     * @param limit
     * @param condition
     * @return 
     * @create: 2016年1月13日 下午1:27:17  Wuql
     * @history:
     */
    public Paginable<GSTrader> queryGSTraderPage(int start, int limit,
            GSTrader condition);

    /**
     * 操盘手-列表查询
     * @param userId
     * @param companyId
     * @param mobile
     * @param realName
     * @param level
     * @param status
     * @return 
     * @create: 2016年1月13日 下午1:27:17  Wuql
     * @history:
     */
    public List<GSTrader> queryGSTraderList(GSTrader condition);

    /**
     * 获取操盘手
     * @param userId
     * @return 
     * @create: 2016年1月22日 下午2:20:04 myb858
     * @history:
     */

    public GSTrader getGSTrader(String userId);

    /**
     * 更换手机号
     * @param userId
     * @param newMobile
     * @param smsCaptcha
     * @param tradePwd
     * @return 
     * @create: 2016年1月13日 下午1:27:17  Wuql
     * @history:
     */
    public void doChangeMoblie(String userId, String newMobile,
            String smsCaptcha, String tradePwd);

    /** 
     * 重置交易密码
     * @param userId
     * @param oldTradePwd
     * @param newTradePwd
     * @return 
     * @create: 2015-5-17 上午11:00:13 miyb
     * @history: 
     */
    public void doResetTradePwd(String userId, String oldTradePwd,
            String newTradePwd, String newTradePwdStrength);

    /**
     * 找回交易密码
     * @param userId
     * @param newTradePwd
     * @param newTradePwdStrength
     * @param smsCaptcha
     * @param idKind
     * @param idNo
     * @return 
     * @create: 2015年9月16日 下午3:38:33 myb858
     * @history:
     */
    public boolean doFindTradePwd(String userId, String newTradePwd,
            String newTradePwdStrength, String smsCaptcha, String idKind,
            String idNo);

}
