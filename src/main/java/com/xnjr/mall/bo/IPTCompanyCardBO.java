package com.xnjr.mall.bo;

import java.util.List;

import com.xnjr.mall.bo.base.IPaginableBO;
import com.xnjr.mall.bo.base.Paginable;
import com.xnjr.mall.domain.PTCompanyCard;

/** 
 * @author: xieyj 
 * @since: 2016年3月5日 下午4:26:22 
 * @history:
 */
public interface IPTCompanyCardBO extends IPaginableBO<PTCompanyCard> {

    /**
     * 保存公司账号
     * @param data
     * @return 
     * @create: 2016年3月5日 下午4:26:45 xieyj
     * @history:
     */
    String savePTCompanyCard(PTCompanyCard data);

    /**
     * 删除公司账号
     * @param code
     * @return 
     * @create: 2016年3月5日 下午4:30:14 xieyj
     * @history:
     */
    int removePTCompanyCard(String code);

    /**
     * 修改公司账号
     * @param data
     * @return 
     * @create: 2016年3月5日 下午4:30:32 xieyj
     * @history:
     */
    int refreshPTCompanyCard(PTCompanyCard data);

    /**
     * 审核公司账号
     * @param data
     * @return 
     * @create: 2016年3月5日 下午4:30:32 xieyj
     * @history:
     */
    int refreshPassPTCompanyCard(PTCompanyCard data);

    /**
     * 审核公司账号
     * @param data
     * @return 
     * @create: 2016年3月5日 下午4:30:32 xieyj
     * @history:
     */
    int refreshUnPassPTCompanyCard(PTCompanyCard data);

    /**
     * 设置受款标志
     * @param data
     * @return 
     * @create: 2016年3月5日 下午4:30:32 xieyj
     * @history:
     */
    int refreshIsAcceptPTCompanyCard(PTCompanyCard data);

    /**
     * 更新最后一次公司账号
     * @param data
     * @return 
     * @create: 2016年3月5日 下午4:30:32 xieyj
     * @history:
     */
    int refreshJourDatePTCompanyCard(PTCompanyCard data);

    /**
     * 查询公司账号列表
     * @param code
     * @return 
     * @create: 2016年3月5日 下午4:30:48 xieyj
     * @history:
     */
    List<PTCompanyCard> queryPTCompanyCardList(PTCompanyCard condition);

    /**
     * 获取某个公司账号信息
     * @param code
     * @return 
     * @create: 2016年3月5日 下午4:31:12 xieyj
     * @history:
     */
    PTCompanyCard getPTCompanyCard(String code);

    Paginable<PTCompanyCard> queryPTCompanyCardDetailPaginable(int start,
            int pageSize, PTCompanyCard condition);

    List<PTCompanyCard> queryPTCompanyCardDetailList(PTCompanyCard condition);

}
