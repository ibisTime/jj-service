/**
 * @Title IBKSubbranchDAO.java 
 * @Package com.xnjr.moom.dao 
 * @Description 
 * @author haiqingzheng  
 * @date 2016年3月5日 上午10:11:15 
 * @version V1.0   
 */
package com.xnjr.mall.dao;

import com.xnjr.mall.dao.base.IBaseDAO;
import com.xnjr.mall.domain.BKSubbranch;

/** 
 * @author: haiqingzheng 
 * @since: 2016年3月5日 上午10:11:15 
 * @history:
 */
public interface IBKSubbranchDAO extends IBaseDAO<BKSubbranch> {
    String NAMESPACE = IBKSubbranchDAO.class.getName().concat(".");

    /**
     * 更新支行信息（修改支行信息和修改人）：重提支行
     * @param data
     * @return 
     * @create: 2016年3月5日 下午3:09:39 haiqingzheng
     * @history:
     */
    public int updateBKSubbranch(BKSubbranch data);

    /**
     * 审核开户支行
     * @param data
     * @return 
     * @create: 2016年3月10日 下午2:30:01 xieyj
     * @history:
     */
    public int checkBKSubbranch(BKSubbranch data);
}
