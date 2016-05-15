package com.xnjr.mall.dao;

import java.util.List;

import com.xnjr.mall.dao.base.IBaseDAO;
import com.xnjr.mall.domain.PTCompanyCard;

/** 
 * 公司账号
 * @author: xieyj 
 * @since: 2016年3月5日 下午3:56:33 
 * @history:
 */
public interface IPTCompanyCardDAO extends IBaseDAO<PTCompanyCard> {
    String NAMESPACE = IPTCompanyCardDAO.class.getName().concat(".");

    /**
     * 修改公司账号
     * @param data
     * @return 
     * @create: 2016年1月20日 下午7:47:29 wuql
     * @history:
     */
    public int update(PTCompanyCard data);

    /**
     * 审核通过公司账号
     * @param data
     * @return 
     * @create: 2016年3月5日 下午3:58:11 xieyj
     * @history:
     */
    public int updatePassPTCompanyCard(PTCompanyCard data);

    /**
     * 审核不通过公司账号
     * @param data
     * @return 
     * @create: 2016年3月5日 下午3:58:11 xieyj
     * @history:
     */
    public int updateUnPassPTCompanyCard(PTCompanyCard data);

    /**
     * 设置受款标志
     * @param data
     * @return 
     * @create: 2016年3月5日 下午4:01:21 xieyj
     * @history:
     */
    public int updateIsAcceptPTCompanyCard(PTCompanyCard data);

    /**
     * 更新最后一次流水
     * @param data
     * @return 
     * @create: 2016年3月5日 下午4:01:21 xieyj
     * @history:
     */
    public int updateJourDatePTCompanyCard(PTCompanyCard data);

    public List<PTCompanyCard> selectDetailList(PTCompanyCard condition);

    public Long selectDetailTotalCount(PTCompanyCard condition);

    public List<PTCompanyCard> selectDetailList(PTCompanyCard condition,
            int start, int count);
}
