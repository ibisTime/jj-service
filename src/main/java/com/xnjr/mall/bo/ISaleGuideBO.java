/**
 * @Title ISaleGuideBO.java 
 * @Package com.xnjr.mall.bo 
 * @Description 
 * @author haiqingzheng  
 * @date 2016年7月25日 下午3:58:23 
 * @version V1.0   
 */
package com.xnjr.mall.bo;

import java.util.List;

import com.xnjr.mall.bo.base.IPaginableBO;
import com.xnjr.mall.domain.SaleGuide;
import com.xnjr.mall.enums.EUserLevel;

/** 
 * @author: haiqingzheng 
 * @since: 2016年7月25日 下午3:58:23 
 * @history:
 */
public interface ISaleGuideBO extends IPaginableBO<SaleGuide> {

    /** 
     * 新增分销引导表
     * @param data
     * @return 
     * @create: 2016年7月27日 下午9:50:42 zuixian
     * @history: 
     */
    public String saveSaleGuide(SaleGuide data);

    /** 
     * 修改分销引导表
     * @param data
     * @return 
     * @create: 2016年7月27日 下午9:50:42 zuixian
     * @history: 
     */
    public int refreshSaleGuide(SaleGuide data);

    /**
     * 列表查询
     * @param data
     * @return 
     * @create: 2016年7月25日 下午3:59:30 haiqingzheng
     * @history:
     */
    public List<SaleGuide> querySaleGuideList(SaleGuide data);

    /** 
     * 详情查询
     * @param modelCode
     * @param toLevel
     * @param quantity
     * @return 
     * @create: 2016年7月26日 下午4:58:21 zuixian
     * @history: 
     */
    public SaleGuide getSaleGuide(String code);

    /** 
     * 查询不同型号价格
     * @param modelCode
     * @param toLevel
     * @param quantity
     * @return 
     * @create: 2016年7月26日 下午4:58:21 zuixian
     * @history: 
     */
    public SaleGuide getSaleGuide(String modelCode, EUserLevel toLevel,
            Long quantity);
}
