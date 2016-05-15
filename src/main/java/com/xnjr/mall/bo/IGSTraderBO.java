/**
 * @Title ITraderBO.java 
 * @Package com.xnjr.moom.bo
 * @Description 
 * @author wuql 
 * @date 2015年12月21日 下午5:39:36 
 * @version V1.0   
 */
package com.xnjr.mall.bo;

import java.util.List;

import com.xnjr.mall.bo.base.IPaginableBO;
import com.xnjr.mall.domain.GSTrader;

/** 
 * @author: wuql
 * @since: 2016年1月13日 上午10:49:33 
 * @history:
 */
public interface IGSTraderBO extends IPaginableBO<GSTrader> {
    /**
     * 验证交易密码:拿tradePwd进行MD5后与数据库中userId得数据库交易密码比对
     * @param userId
     * @param tradePwd 
     * @create: 2015年11月1日 下午4:47:48 myb858
     * @history:
     */
    public void checkTradePwd(String userId, String tradePwd);

    public boolean isGSTraderExist(String userId);

    // 判断手机号是否存在
    public void isMobileExist(String mobile);

    public String saveGSTrader(GSTrader data);

    public int removeTrader(String userId);

    public int refreshGSTrader(GSTrader data);

    public GSTrader getGSTrader(String userId);

    public List<GSTrader> queryGSTraderListByUserId(String userId);

    public List<GSTrader> queryGSTraderList(GSTrader condition);

    public void refreshMobile(String userId, String mobile);

    public void refreshTradePwd(String userId, String tradePwd);

    public void refreshTradePwd(String userId, String tradePwd,
            String newTradePwdStrength);

    public void refreshTotal(String trader, Long principal, Long profit);

}
