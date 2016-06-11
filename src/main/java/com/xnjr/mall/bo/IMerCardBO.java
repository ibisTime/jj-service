/**
 * @Title IMerCardBO.java 
 * @Package com.xnjr.mall.bo 
 * @Description 
 * @author xieyj  
 * @date 2016年6月11日 下午5:38:58 
 * @version V1.0   
 */
package com.xnjr.mall.bo;

import java.util.List;

import com.xnjr.mall.bo.base.IPaginableBO;
import com.xnjr.mall.domain.MerCard;

/** 
 * @author: xieyj 
 * @since: 2016年6月11日 下午5:38:58 
 * @history:
 */
public interface IMerCardBO extends IPaginableBO<MerCard> {

    /**
     * 判断是否存在
     * @param code
     * @return 
     * @create: 2016年6月11日 下午5:45:02 xieyj
     * @history:
     */
    public boolean isMerCardExist(String code);

    /**
     * 保存受款账号
     * @param data
     * @return 
     * @create: 2015年8月21日 下午5:06:38 xieyj
     * @history:
     */
    public String saveMerCard(MerCard data);

    /**
     * 删除受款账号
     * @param code
     * @return 
     * @create: 2016年5月23日 下午9:09:04 xieyj
     * @history:
     */
    public int removeMerCard(String code);

    /**
     * 更新受款账号
     * @param data
     * @return 
     * @create: 2016年5月23日 下午9:08:49 xieyj
     * @history:
     */
    public int refreshMerCard(MerCard data);

    /**
     * 查询受款账号列表
     * @param data
     * @return 
     * @create: 2015年8月21日 下午5:07:41 xieyj
     * @history:
     */
    public List<MerCard> queryMerCardList(MerCard data);

    /**
     * 根据受款账号编号获取详细信息
     * @param code
     * @return 
     * @create: 2016年5月23日 下午9:08:14 xieyj
     * @history:
     */
    public MerCard getMerCard(String code);
}
