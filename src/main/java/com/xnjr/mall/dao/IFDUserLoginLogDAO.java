package com.xnjr.mall.dao;

import com.xnjr.mall.dao.base.IBaseDAO;
import com.xnjr.mall.domain.FDUserLoginLog;

/**
 * 
 * @author: luoqi 
 * @since: 2015年3月7日 下午1:56:37 
 * @history:
 */
public interface IFDUserLoginLogDAO extends IBaseDAO<FDUserLoginLog> {
    String NAMESPACE = IFDUserLoginLogDAO.class.getName().concat(".");

    public FDUserLoginLog selectLatestUserLoginLog(FDUserLoginLog condition);
}
