package com.xnjr.mall.bo.base;

import com.xnjr.mall.dao.base.ABaseDO;

/**
 * 分页查询接口
 * 
 * @author joe.chen
 * 
 * @param <T>
 */
public interface IPaginableBO<T extends ABaseDO> {

    public long getTotalCount(T condition);

    /**
     * 
     * 
     * @param start
     * @param condition
     * @return
     */
    public Paginable<T> getPaginable(int start, T condition);

    /**
     * 获取分页结果
     * 
     * @param start
     * @param pageSize
     * @param condition
     * @return
     */
    public Paginable<T> getPaginable(int start, int pageSize, T condition);

}
