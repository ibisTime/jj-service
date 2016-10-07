/**
 * @Title IBaseDAO.java 
 * @Package com.ibis.pz 
 * @Description 
 * @author miyb  
 * @date 2015-2-6 上午10:24:50 
 * @version V1.0   
 */
package com.cdkj.service.dao.base;

import java.util.List;

/** 
 * @author: miyb 
 * @since: 2015-2-6 上午10:24:50 
 * @history:
 */
public interface IBaseDAO<T> {
    public int insert(T data);

    public int delete(T data);

    public T select(T condition);

    public Long selectTotalCount(T condition);

    public List<T> selectList(T condition);

    public List<T> selectList(T condition, int start, int count);

}
