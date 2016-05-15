/**
 * @Title FDUserBOImpl.java 
 * @Package com.ibis.pz.impl 
 * @Description 
 * @author miyb  
 * @date 2015-3-7 上午9:21:25 
 * @version V1.0   
 */
package com.xnjr.mall.bo.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.xnjr.mall.bo.IFDUserBO;
import com.xnjr.mall.bo.base.PaginableBOImpl;
import com.xnjr.mall.common.MD5Util;
import com.xnjr.mall.common.PhoneUtil;
import com.xnjr.mall.common.PwdUtil;
import com.xnjr.mall.core.OrderNoGenerater;
import com.xnjr.mall.dao.IFDIndividualDAO;
import com.xnjr.mall.dao.IFDUserCompanyDAO;
import com.xnjr.mall.dao.IFDUserDAO;
import com.xnjr.mall.domain.FDCompany;
import com.xnjr.mall.domain.FDIndividual;
import com.xnjr.mall.domain.FDUser;
import com.xnjr.mall.domain.FDUserCompany;
import com.xnjr.mall.enums.EAccountStatus;
import com.xnjr.mall.enums.EFDUserKind;
import com.xnjr.mall.enums.EKYCStatus;
import com.xnjr.mall.enums.EServe;
import com.xnjr.mall.enums.EUserKind;
import com.xnjr.mall.exception.BizException;

/** 
 * @author: miyb 
 * @since: 2015-3-7 上午9:21:25 
 * @history:
 */
@Component
public class FDUserBOImpl extends PaginableBOImpl<FDUser> implements IFDUserBO {
    @Autowired
    private IFDUserDAO fdUserDAO;

    @Autowired
    private IFDUserCompanyDAO fdUserCompanyDAO;

    @Autowired
    private IFDIndividualDAO fdIndividualDAO;

    /** 
     * @see com.ibis.pz.user.IUserBO#removeUser(java.lang.String)
     */
    @Override
    public int removeUser(String userId) {
        int count = 0;
        if (StringUtils.isNotBlank(userId)) {
            FDUser data = new FDUser();
            data.setUserId(userId);
            count = fdUserDAO.delete(data);
        }
        return count;
    }

    /**
     * @see com.ibis.pz.user.IUserBO#refreshIdentity(java.lang.String, java.lang.String, java.lang.String, java.lang.String)
     */
    @Override
    public int refreshIdentity(String userId, String realName, String idKind,
            String idNo) {
        FDUser data = new FDUser();
        data.setUserId(userId);
        data.setRealName(realName);
        data.setIdKind(idKind);
        data.setIdNo(idNo);
        int count = 0;
        if (data != null && StringUtils.isNotBlank(data.getUserId())) {
            count = fdUserDAO.updateIdentity(data);
        }
        return count;
    }

    /**
     * @see com.ibis.pz.user.IUserBO#refreshTradePwd(java.lang.String, java.lang.String)
     */
    @Override
    public int refreshTradePwd(String userId, String tradePwd,
            String tradePwdStrength) {
        int count = 0;
        if (StringUtils.isNotBlank(userId)) {
            FDUser data = new FDUser();
            data.setUserId(userId);
            data.setTradePwd(MD5Util.md5(tradePwd));
            data.setTradePwdStrength(tradePwdStrength);
            count = fdUserDAO.updateTradePwd(data);
        }
        return count;
    }

    /** 
     * @see com.ibis.pz.user.IUserBO#getUser(java.lang.String)
     */
    @Override
    public FDUser getUser(String userId) {
        FDUser data = null;
        if (StringUtils.isNotBlank(userId)) {
            FDUser condition = new FDUser();
            condition.setUserId(userId);
            data = fdUserDAO.select(condition);
        }
        return data;
    }

    /** 
     * @see com.ibis.pz.user.IUserBO#getUserByMobile(java.lang.String)
     */
    @Override
    public FDUser getUserByMobile(String mobile) {
        FDUser data = null;
        if (StringUtils.isNotBlank(mobile)) {
            FDUser condition = new FDUser();
            condition.setMobile(mobile);
            List<FDUser> list = fdUserDAO.selectList(condition);
            if (list != null && list.size() > 1) {
                throw new BizException("li01006", "手机号重复");
            }
            if (CollectionUtils.isNotEmpty(list)) {
                data = list.get(0);
            }
        }
        return data;
    }

    /** 
     * @see com.ibis.pz.user.IUserBO#queryUserList(com.User.pz.domain.FDUser)
     */
    @Override
    public List<FDUser> queryUserList(FDUser data) {
        return fdUserDAO.selectList(data);
    }

    /**
     * 
     * @see com.ibis.pz.user.IUserBO#refreshLoginPwd(java.lang.String, java.lang.String, java.lang.String)
     */
    @Override
    public int refreshLoginPwd(String userId, String loginPwd,
            String loginPwdStrength) {
        int count = 0;
        if (StringUtils.isNotBlank(userId)) {
            FDUser data = new FDUser();
            data.setUserId(userId);
            data.setLoginPwd(loginPwd);
            data.setLoginPwdStrength(loginPwdStrength);
            count = fdUserDAO.updateLoginPwd(data);
        }
        return count;
    }

    /**
     * @see com.ibis.pz.user.IUserBO#refreshMobile(java.lang.String, java.lang.String)
     */
    @Override
    public int refreshMobile(String userId, String mobile) {
        // 手机号校验
        isMobileExist(mobile);
        FDUser data = new FDUser();
        data.setUserId(userId);
        data.setMobile(mobile);
        int count = 0;
        if (data != null && StringUtils.isNotBlank(data.getUserId())) {
            count = fdUserDAO.updateMobile(data);
        }
        return count;
    }

    /** 
     * @see com.ibis.pz.user.IUserBO#isMobileExist(java.lang.String)
     */
    @Override
    public void isMobileExist(String mobile) {
        // 判断格式
        PhoneUtil.checkMobile(mobile);
        FDUser condition = new FDUser();
        condition.setMobile(mobile);
        long count = getTotalCount(condition);
        if (count > 0) {
            throw new BizException("li01003", "手机号已经存在");
        }
    }

    /** 
     * @see com.std.account.bo.IUserBO#checkUserReferee(java.lang.String)
     */
    @Override
    public void checkUserReferee(String userReferee) {
        if (StringUtils.isNotBlank(userReferee)) {
            // 判断格式
            PhoneUtil.checkMobile(userReferee, "推荐人");
            FDUser condition = new FDUser();
            condition.setMobile(userReferee);
            long count = getTotalCount(condition);
            if (count <= 0) {
                throw new BizException("li01003", "推荐人不存在");
            }
        }
    }

    /** 
     * @see com.ibis.pz.user.IUserBO#doRegister(java.lang.String, java.lang.String, java.lang.String, java.lang.String)
     */
    @Override
    public String doRegister(String mobile, String loginPwd, String registerIp,
            String userReferee) {
        String userId = null;
        if (StringUtils.isNotBlank(mobile) && StringUtils.isNotBlank(loginPwd)
                && StringUtils.isNotBlank(registerIp)) {
            Date now = new Date();
            FDUser data = new FDUser();
            userId = OrderNoGenerater.generateM("FU");
            data.setUserId(userId);
            data.setMobile(mobile);
            data.setLoginPwd(MD5Util.md5(loginPwd));
            data.setLoginPwdStrength(PwdUtil.calculateSecurityLevel(loginPwd));
            data.setUserKind(EFDUserKind.Admin.getCode());
            data.setUserReferee(userReferee);
            data.setCreateDatetime(now);
            data.setStatus(EAccountStatus.NORMAL.getCode());// 0正常;1程序锁定;2人工锁定
            fdUserDAO.insert(data);
        }
        return userId;
    }

    @Override
    public void checkTradePwd(String userId, String tradePwd) {
        if (StringUtils.isNotBlank(userId) && StringUtils.isNotBlank(tradePwd)) {
            FDUser condition = new FDUser();
            condition.setUserId(userId);
            condition.setTradePwd(MD5Util.md5(tradePwd));
            long count = this.getTotalCount(condition);
            if (count != 1) {
                throw new BizException("jd00001", "交易密码错误");
            }
        } else {
            throw new BizException("jd00001", "交易密码错误");
        }
    }

    @Override
    public void checkLoginPwd(String userId, String loginPwd) {
        if (StringUtils.isNotBlank(userId) && StringUtils.isNotBlank(loginPwd)) {
            FDUser condition = new FDUser();
            condition.setUserId(userId);
            condition.setLoginPwd(MD5Util.md5(loginPwd));
            long count = this.getTotalCount(condition);
            if (count != 1) {
                throw new BizException("jd00001", "原登录密码错误");
            }
        } else {
            throw new BizException("jd00001", "原登录密码错误");
        }

    }

    @Override
    public String doAddUser(String mobile, String loginPsd, String userReferee,
            String realName, String idKind, String idNo, String tradePsd) {
        String userId = null;
        if (StringUtils.isNotBlank(mobile)) {
            FDUser user = new FDUser();
            userId = OrderNoGenerater.generateM("FU");
            user.setUserId(userId);
            user.setMobile(mobile);
            user.setLoginPwd(MD5Util.md5(loginPsd));
            user.setLoginPwdStrength(PwdUtil.calculateSecurityLevel(loginPsd));
            user.setUserKind(EUserKind.Admin.getCode());
            user.setUserReferee(userReferee);
            user.setIdKind(idKind);
            user.setIdNo(idNo);
            user.setRealName(realName);
            user.setTradePwd(MD5Util.md5(tradePsd));
            user.setTradePwdStrength(PwdUtil.calculateSecurityLevel(tradePsd));
            user.setCreateDatetime(new Date());
            user.setRemark(EUserKind.Admin.getValue());
            user.setStatus(EAccountStatus.NORMAL.getCode());
            fdUserDAO.quickInsertFDUser(user);
        }
        return userId;
    }

    @Override
    public int doKYC(FDUser admin, String serveList, String quoteList,
            Integer level) {
        int count = 0;
        if (admin != null) {
            FDUser fdUser = doUnionKYC(admin.getUserId(), serveList, quoteList,
                level);
            admin.setServeList(fdUser.getServeList());
            admin.setQuoteList(fdUser.getQuoteList());
            admin.setLevel(fdUser.getLevel());
            count = fdUserDAO.doKYC(admin);
        }
        return count;
    }

    @Override
    public int doKYCIndividual(FDUser admin, String serveList,
            String quoteList, Integer level) {
        int count = 0;
        if (admin != null) {
            FDUser fdUser = doUnionKYC(admin.getUserId(), serveList, quoteList,
                level);
            admin.setServeList(fdUser.getServeList());
            admin.setQuoteList(fdUser.getQuoteList());
            admin.setLevel(fdUser.getLevel());
            count = fdUserDAO.doKYCIndividual(admin);
        }
        return count;
    }

    private FDUser doUnionKYC(String userId, String theServeList,
            String theQuoteList, Integer theLevel) {
        FDUser admin = this.getUser(userId);
        FDUser resultUser = new FDUser();
        FDUserCompany condition = new FDUserCompany();
        condition.setUserId(userId);
        condition.setStatus(EKYCStatus.KYC_YES.getCode());
        List<FDCompany> companyList = fdUserCompanyDAO
            .selectCompanyList(condition);
        // 合并拥有公司的权限
        if (CollectionUtils.isNotEmpty(companyList)) {
            for (FDCompany fdCompany2 : companyList) {
                theServeList = unionServeList(fdCompany2.getServeList(),
                    theServeList);
                theQuoteList = unionQuoteList(fdCompany2.getQuoteList(),
                    theQuoteList);
                theLevel = unionLevel(fdCompany2.getLevel(), theLevel);
            }
        }

        // 合并拥有的个体户权限
        if (StringUtils.isNotBlank(admin.getIndividualCode())) {
            FDIndividual indCondition = new FDIndividual();
            indCondition.setCode(admin.getIndividualCode());
            FDIndividual fdIndividual = fdIndividualDAO.select(indCondition);
            if (fdIndividual != null) {
                theServeList = unionServeList(fdIndividual.getServeList(),
                    theServeList);
                theQuoteList = unionQuoteList(fdIndividual.getQuoteList(),
                    theQuoteList);
                theLevel = unionLevel(fdIndividual.getLevel(), theLevel);
            }
        }
        // 合并结果
        resultUser.setServeList(theServeList);
        resultUser.setQuoteList(theQuoteList);
        resultUser.setLevel(theLevel);
        return resultUser;
    }

    private String unionServeList(String serveList, String serveList2) {
        if (StringUtils.isBlank(serveList2)) {
            return serveList;
        }
        serveList2 = cleanString(serveList2);
        if (StringUtils.isNotBlank(serveList)) {
            Set<String> list = getSet(serveList);
            for (String ele : list) {
                if (!serveList2.contains(ele)) {
                    serveList2 = serveList2 + ele;
                }
            }
        }

        // 排序ABCD12ab
        serveList2 = sortServe(serveList2);
        return serveList2;
    }

    private String unionQuoteList(String quoteList, String quoteList2) {
        if (StringUtils.isBlank(quoteList2)) {
            return quoteList;
        }
        quoteList2 = cleanString(quoteList2);
        if (StringUtils.isBlank(quoteList)) {
            return quoteList2;
        }
        Set<String> list = getSet(quoteList);
        for (String ele : list) {
            if (!quoteList2.contains(ele)) {
                quoteList2 = quoteList2 + ele;
            }
        }
        return quoteList2;
    }

    private Integer unionLevel(Integer level, Integer level2) {
        if (level == null) {
            return level2;
        }
        if (level2 == null) {
            return level;
        }
        return level > level2 ? level : level2;
    }

    /**
     * 根据枚举类已有的顺序依次遍历是否存在
     * @param serveResult
     * @return 
     * @create: 2016年3月7日 上午8:39:51 xieyj
     * @history:
     */
    private String sortServe(String serveResult) {
        StringBuffer serveBuffer = new StringBuffer();
        if (StringUtils.isNotBlank(serveResult)) {
            // 获取枚举类顺序
            List<String> serveList = new ArrayList<String>();
            for (EServe serve : EServe.values()) {
                serveList.add(serve.getCode());
            }
            for (String serve : serveList) {
                if (serveResult.contains(serve)) {
                    serveBuffer.append(serve);
                }
            }
        }
        return serveBuffer.toString();
    }

    private String cleanString(String str) {
        Set<String> set = getSet(str);
        StringBuffer returnStr = new StringBuffer();
        for (String ele : set) {
            returnStr.append(ele);
        }
        return returnStr.toString();
    }

    private Set<String> getSet(String string) {
        Set<String> resultSet = new HashSet<String>();
        if (StringUtils.isNotBlank(string)) {
            for (int i = 0; i < string.length(); i++) {
                String serve = string.substring(i, i + 1);
                resultSet.add(serve);
            }
        }
        return resultSet;
    }
}
