/**
 * @Title IFDUserIdentifyBO.java 
 * @Package com.ibis.pz.user 
 * @Description 
 * @author luoqi  
 * @date 2015年3月8日 上午11:30:08 
 * @version V1.0   
 */
package com.xnjr.mall.bo;

import java.util.List;

import com.xnjr.mall.bo.base.IPaginableBO;
import com.xnjr.mall.domain.FDUserIdentify;

/** 
 * @author: luoqi 
 * @since: 2015年3月8日 上午11:30:08 
 * @history:
 */
public interface IFDUserIdentifyBO extends IPaginableBO<FDUserIdentify> {
    /**
     * 一个身份证只能被认证一次
     * @param realName
     * @param idKind
     * @param idNo 
     * @create: 2015年12月6日 下午2:53:02 myb858
     * @history:
     */
    public void isChecked(String realName, String idKind, String idNo);

    public int saveUserIdentify(String userId, String realName, String idKind,
            String idcard, String errorCode, String errorInfo);

    public List<FDUserIdentify> queryUserIdentifyList(String userId);

    public List<FDUserIdentify> queryTodayIdentifyList(String userId);

    public FDUserIdentify getSuccessOne(String realName, String idKind,
            String idNo);

    public List<FDUserIdentify> queryUserIdentifyList(FDUserIdentify data);

}
