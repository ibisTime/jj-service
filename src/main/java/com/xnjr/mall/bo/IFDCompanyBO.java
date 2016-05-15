/**
 * @Title ICompanyBO.java 
 * @Package com.std.account.bo
 * @Description 
 * @author wuql  
 * @date 2016年1月14日 下午2:38:13  
 * @version V1.0   
 */
package com.xnjr.mall.bo;

import java.util.List;

import com.xnjr.mall.bo.base.IPaginableBO;
import com.xnjr.mall.domain.FDCompany;

/** 
 * @author: wuql
 * @since: 2016年1月14日 下午2:38:13 
 * @history:
 */
public interface IFDCompanyBO extends IPaginableBO<FDCompany> {

    public String saveCompany(String code, String name, String gsyyzzNo,
            String idKind, String idNo, String realName, String currency,
            Long capital, String province, String city, String address);

    public int refreshPicture(String code, String gsyyzzPicture,
            String zzjgdmzPicture, String swdjzPicture, String dzzPicture,
            String frPicture, String otherPicture);

    public int refreshCompany(String code, String name, String gsyyzzNo,
            String idKind, String idNo, String realName, String currency,
            Long capital, String province, String city, String address,
            String status);

    /**
     * 企业KYC审核
     * @param code
     * @param kycUser
     * @param kycResult
     * @param kycNote
     * @param serveList
     * @param quoteList
     * @param level
     * @return 
     * @create: 2016年4月22日 上午3:14:51 xieyj
     * @history:
     */
    public int doKYC(String code, String kycUser, String kycResult,
            String kycNote, String serveList, String quoteList, Integer level);

    public boolean isCompanyExist(String code);

    /**
     * 判断公司名称或者营业执照是否存在
     * @param name
     * @param gsyyzzNo
     * @return 
     * @create: 2016年4月21日 下午7:29:15 xieyj
     * @history:
     */
    public void isCompanyExist(String name, String gsyyzzNo);

    public FDCompany getCompany(String code);

    public List<FDCompany> queryCompanyList(FDCompany condition);
}
