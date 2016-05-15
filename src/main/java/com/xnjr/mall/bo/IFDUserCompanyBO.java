package com.xnjr.mall.bo;

import java.util.List;

import com.xnjr.mall.bo.base.IPaginableBO;
import com.xnjr.mall.bo.base.Paginable;
import com.xnjr.mall.domain.FDCompany;
import com.xnjr.mall.domain.FDUser;
import com.xnjr.mall.domain.FDUserCompany;

/**
 * 用户企业关联表
 * @author: xieyj 
 * @since: 2016年4月21日 下午12:26:28 
 * @history:
 */
public interface IFDUserCompanyBO extends IPaginableBO<FDUserCompany> {

    /**
     * 判断用户企业关联关系是否存在
     */
    public boolean isUserCompanyExist(String userId, String companyCode);

    /**
     * 判断用户企业关联关系是否已绑定成功
     */
    public boolean isUserCompanyBind(String userId, String companyCode);

    /**
     * 建立用户企业关联关系
     */
    public void saveUserCompany(String userId, String companyCode,
            String status, String sqghPicture, String remark);

    /**
     * 删除用户企业关联关系
     */
    public int removeUserCompany(String userId, String companyCode);

    /**
     * 更新用户企业关联关系
     */
    public int refreshUserCompany(String userId, String companyCode,
            String sqghPicture, String remark);

    /**
     * 审核kyc,变更用户企业关联关系
     */
    public int refreshKycUserCompany(String userId, String companyCode,
            String kycUser, String kycResult, String kycNote);

    /**
     * 查询用户所关联的公司列表
     */
    public List<FDCompany> queryCompanyList(FDUserCompany condition);

    /**
     * 查询用户已确认的公司列表
     */
    public List<FDCompany> queryConfirmCompanyByUserId(String userId);

    public Paginable<FDCompany> getCompanyPage(int start, int pageSize,
            FDUserCompany condition);

    /**
     * 根据用户编号查询企业列表
     */
    public boolean isContainCompany(String userId, String companyCode);

    /**
     * 查询公司所关联的用户列表
     */
    public List<FDUser> queryUserList(FDUserCompany condition);

    /**
     * 查询用户所关联的公司详情
     */
    public FDUserCompany getUserCompany(Long id);

    /**
     * 查询用户所关联的公司详情
     */
    public FDUserCompany getUserCompany(String userId, String companyCode);

}
