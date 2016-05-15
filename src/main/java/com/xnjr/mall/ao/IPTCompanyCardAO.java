package com.xnjr.mall.ao;

import java.util.List;

import com.xnjr.mall.bo.base.Paginable;
import com.xnjr.mall.domain.PTCompanyCard;
import com.xnjr.mall.spring.ServiceModule;

/** 
 * @author: xieyj 
 * @since: 2016年3月5日 下午4:42:01 
 * @history:
 */
@ServiceModule
public interface IPTCompanyCardAO {
    String DEFAULT_ORDER_COLUMN = "code";

    /**
     * 新增公司账号
     * @param data
     * @return 
     * @create: 2016年3月5日 下午4:52:03 xieyj
     * @history:
     */
    String addPTCompanyCard(PTCompanyCard data);

    /**
     * 删除公司账号
     * @param code 
     * @create: 2016年3月5日 下午4:52:32 xieyj
     * @history:
     */
    int dropPTCompanyCard(String code);

    /**
     * 修改公司账号
     * @param data 
     * @create: 2016年3月5日 下午4:52:44 xieyj
     * @history:
     */
    int editPTCompanyCard(PTCompanyCard data);

    /**
     * 审批通过公司账号
     * @param data 
     * @create: 2016年3月5日 下午4:52:54 xieyj
     * @history:
     */
    int passPTCompanyCard(PTCompanyCard data);

    /**
     * 审批不通过公司账号
     * @param data 
     * @create: 2016年3月5日 下午4:52:54 xieyj
     * @history:
     */
    int unPassPTCompanyCard(PTCompanyCard data);

    /**
     * 设置受款
     * @param data 
     * @create: 2016年3月5日 下午4:53:06 xieyj
     * @history:
     */
    int editIsAcceptPTCompanyCard(PTCompanyCard data);

    /**
     * 编辑公司账号最后一次交易
     * @param data 
     * @create: 2016年3月5日 下午4:53:06 xieyj
     * @history:
     */
    int editJourDatePTCompanyCard(PTCompanyCard data);

    /**
     * 查询公司账号列表
     * @param condition
     * @return 
     * @create: 2016年3月5日 下午4:53:38 xieyj
     * @history:
     */
    List<PTCompanyCard> queryPTCompanyCardList(PTCompanyCard condition);

    /**
     * 分页查询公司账号记录
     * @param start
     * @param limit
     * @param condition
     * @return 
     * @create: 2015年11月13日 上午11:56:10 xieyj
     * @history:
     */
    public Paginable<PTCompanyCard> queryPTCompanyCardPage(int start,
            int limit, PTCompanyCard condition);

    /**
     * 查询公司账号列表
     * @param condition
     * @return 
     * @create: 2016年3月5日 下午4:53:38 xieyj
     * @history:
     */
    List<PTCompanyCard> queryDetailPTCompanyCardList(PTCompanyCard condition);

    /**
     * 分页查询公司账号记录
     * @param start
     * @param limit
     * @param condition
     * @return 
     * @create: 2015年11月13日 上午11:56:10 xieyj
     * @history:
     */
    public Paginable<PTCompanyCard> queryDetailPTCompanyCardPage(int start,
            int limit, PTCompanyCard condition);

    /**
     * 获取某个公司账号信息
     * @param code
     * @return 
     * @create: 2016年3月5日 下午4:53:59 xieyj
     * @history:
     */
    PTCompanyCard getPTCompanyCard(String code);
}
