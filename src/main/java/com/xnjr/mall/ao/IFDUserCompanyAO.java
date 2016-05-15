package com.xnjr.mall.ao;

import java.util.List;

import com.xnjr.mall.bo.base.Paginable;
import com.xnjr.mall.domain.FDCompany;
import com.xnjr.mall.domain.FDUser;
import com.xnjr.mall.domain.FDUserCompany;
import com.xnjr.mall.spring.ServiceModule;

/**
 * 资金方-用户企业关联表
 * @author: xieyj 
 * @since: 2016年4月21日 下午10:02:10 
 * @history:
 */
@ServiceModule
public interface IFDUserCompanyAO {
    String DEFAULT_ORDER_COLUMN = "id";

    /**
     * 根据用户名查询企业列表
     * @param userId
     * @return 
     * @create: 2016年4月21日 下午10:02:53 xieyj
     * @history:
     */
    public List<FDCompany> queryCompanyListByUserId(String userId);

    /**
     * 根据用户名查询企业列表
     * @param userId
     * @return 
     * @create: 2016年4月21日 下午10:02:53 xieyj
     * @history:
     */
    public List<FDCompany> queryCompanyList(FDUserCompany condition);

    /**
     * 根据用户编号分页查询企业列表
     * @param userId
     * @return 
     * @create: 2016年4月21日 下午10:02:53 xieyj
     * @history:
     */
    public Paginable<FDCompany> queryCompanyPageByUserId(int start,
            int pageSize, FDUserCompany condition);

    /**
     * 企业关联用户查询用户列表
     * @param condition
     * @return 
     * @create: 2016年4月24日 下午9:28:17 xieyj
     * @history:
     */
    public List<FDUser> queryUserList(FDUserCompany condition);

    /**
     * 分页查询KYC申请书
     * @param start
     * @param limit
     * @param condition
     * @return 
     * @create: 2016年4月22日 上午8:49:02 xieyj
     * @history:
     */
    public Paginable<FDUserCompany> queryUserCompanyPage(int start, int limit,
            FDUserCompany condition);

    /**
     * 绑定用户和企业关系
     * @param userId
     * @param companyCode
     * @param sqghPicture
     * @param remark 
     * @create: 2016年4月22日 上午8:12:11 xieyj
     * @history:
     */
    public void doBindUserCompany(String userId, String companyCode,
            String sqghPicture, String remark);

    /**
     * 管理端-绑定用户和企业关系
     * @param userId
     * @param companyCode
     * @param sqghPicture
     * @param remark 
     * @param updater
     * @create: 2016年4月22日 上午8:12:11 xieyj
     * @history:
     */
    public void doBindUserCompany(String userId, String companyCode,
            String sqghPicture, String remark, String updater);

    /**
     * 管理端-解绑用户和企业关系
     * @param userId
     * @param companyCode 
     * @create: 2016年4月22日 上午8:12:33 xieyj
     * @history:
     */
    public void doUnBindUserCompany(String userId, String companyCode,
            String updater);

    /**
     * 变更用户和企业关系
     * @param fromUserId
     * @param toUserId
     * @param companyCode
     * @param sqghPicture
     * @param remark
     * @param updater 
     * @create: 2016年4月24日 下午2:31:16 xieyj
     * @history:
     */
    public void doChangeUserCompany(String fromUserId, String toUserId,
            String companyCode, String sqghPicture, String remark,
            String updater);

    /**
     * 隶属关系KYC
     * @param userId
     * @param companyCode 
     * @create: 2016年4月22日 上午8:12:33 xieyj
     * @history:
     */
    public void doKYC(Long id, String kycUser, String kycResult, String kycNote);

    /**
     * 获取公司详情
     * @param userId
     * @param companyCode
     * @return 
     * @create: 2016年5月4日 下午2:23:05 xieyj
     * @history:
     */
    public FDUserCompany getUserCompany(String userId, String companyCode);
}
