package com.xnjr.mall.ao;

import java.util.List;

import com.xnjr.mall.bo.base.Paginable;
import com.xnjr.mall.domain.FDCompany;
import com.xnjr.mall.spring.ServiceModule;

/**
 * 资金方-公司AO
 * @author: xieyj 
 * @since: 2016年4月21日 下午12:19:57 
 * @history:
 */
@ServiceModule
public interface IFDCompanyAO {
    String DEFAULT_ORDER_COLUMN = "code";

    /**
     * 新增企业信息
     * @param name
     * @param gsyyzzNo
     * @param idKind
     * @param idNo
     * @param realName
     * @param currency
     * @param capital
     * @param province
     * @param city
     * @param address
     * @param applyUser
     * @return 
     * @create: 2016年4月21日 下午12:22:06 xieyj
     * @history:
     */
    public String addCompany(String name, String gsyyzzNo, String idKind,
            String idNo, String realName, String currency, Long capital,
            String province, String city, String address, String applyUser);

    /**
     * 新增企业和企业账户
     * @param name
     * @param gsyyzzNo
     * @param idKind
     * @param idNo
     * @param realName
     * @param currency
     * @param capital
     * @param province
     * @param city
     * @param address
     * @param applyUser
     * @param bankCode
     * @param subbranch
     * @param cardNo
     * @return 
     * @create: 2016年5月3日 上午10:21:00 xieyj
     * @history:
     */
    public String addCompanyAndCard(String name, String gsyyzzNo,
            String idKind, String idNo, String realName, String currency,
            Long capital, String province, String city, String address,
            String applyUser, String bankCode, String subbranch, String cardNo);

    /**
     * 企业资料补充
     * @param code
     * @param gsyyzzPicture
     * @param zzjgdmzPicture
     * @param swdjzPicture
     * @param dzzPicture
     * @param frPicture
     * @param otherPicture
     * @param applyUser 
     * @create: 2016年4月21日 下午12:22:21 xieyj
     * @history:
     */
    public void editPicture(String code, String gsyyzzPicture,
            String zzjgdmzPicture, String swdjzPicture, String dzzPicture,
            String frPicture, String otherPicture);

    /**
     * 更新企业信息
     * @param code
     * @param name
     * @param gsyyzzNo
     * @param idKind
     * @param idNo
     * @param realName
     * @param currency
     * @param capital
     * @param province
     * @param city
     * @param address
     * @create: 2016年4月21日 下午12:22:42 xieyj
     * @history:
     */
    public void editCompany(String code, String name, String gsyyzzNo,
            String idKind, String idNo, String realName, String currency,
            Long capital, String province, String city, String address);

    /**
     * 企业KYC认证
     * @param code
     * @param kycUser
     * @param kycResult
     * @param kycNote
     * @param serveList
     * @param quoteList
     * @param level 
     * @create: 2016年4月22日 上午2:59:59 xieyj
     * @history:
     */
    public void doKYC(String code, String kycUser, String kycResult,
            String kycNote, String serveList, String quoteList, Integer level);

    /**
     * 分页查询企业列表
     * @param start
     * @param limit
     * @param condition
     * @return 
     * @create: 2016年4月21日 下午12:21:26 xieyj
     * @history:
     */
    public Paginable<FDCompany> queryCompanyPage(int start, int limit,
            FDCompany condition);

    /**
     * 查询企业列表
     * @param condition
     * @return 
     * @create: 2016年4月21日 下午12:21:35 xieyj
     * @history:
     */
    public List<FDCompany> queryCompanyList(FDCompany condition);

    /**
     * 查询企业详情
     * @param code
     * @return 
     * @create: 2016年4月21日 下午12:21:47 xieyj
     * @history:
     */
    public FDCompany doGetCompany(String code);

    /**
     * 判断企业是否存在
     * @param code
     * @return 
     * @create: 2016年4月21日 下午12:21:47 xieyj
     * @history:
     */
    public String getCompanyCodeByCondition(String name, String gsyyzzNo);
}
