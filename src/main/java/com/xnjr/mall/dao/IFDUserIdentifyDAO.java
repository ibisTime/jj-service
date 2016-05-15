package com.xnjr.mall.dao;

import com.xnjr.mall.dao.base.IBaseDAO;
import com.xnjr.mall.domain.FDUserIdentify;

/**
 * @author: luoqi 
 * @since: 2015年3月7日 下午6:26:49 
 * @history:
 */
public interface IFDUserIdentifyDAO extends IBaseDAO<FDUserIdentify> {
    String NAMESPACE = IFDUserIdentifyDAO.class.getName().concat(".");
}
