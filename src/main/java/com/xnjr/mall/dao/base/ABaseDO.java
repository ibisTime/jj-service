/**
 * @Title ABaseDO.java 
 * @Package com.ibis.pz.base 
 * @Description 
 * @author miyb  
 * @date 2015-2-6 上午10:32:54 
 * @version V1.0   
 */
package com.xnjr.mall.dao.base;

import java.io.Serializable;
import java.util.UUID;

import org.apache.commons.lang3.StringUtils;

/** 
 * @author: miyb 
 * @since: 2015-2-6 上午10:32:54 
 * @history:
 */
public abstract class ABaseDO implements Serializable {

    private String userDB;

    /** 
     * @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么) 
     */
    private static final long serialVersionUID = -1529928645166513824L;

    private String order = null;

    public void setOrder(String fieldName, boolean ascending) {
        Order orderInfo = ascending ? Order.asc(fieldName) : Order
            .desc(fieldName);
        this.order = orderInfo.toSqlString();
    }

    public void setOrder(String fieldName, String direction) {
        Order orderInfo = null;
        if (StringUtils.isBlank(direction)
                || "desc".equalsIgnoreCase(direction)) {
            orderInfo = Order.desc(fieldName);
        } else {
            orderInfo = Order.asc(fieldName);
        }
        this.order = orderInfo.toSqlString();
    }

    public String getOrder() {
        return this.order;
    }

    public String generateId() {
        return StringUtils.replace(UUID.randomUUID().toString(), "-".intern(),
            StringUtils.EMPTY);
    }

    public String getUserDB() {
        return userDB;
    }

    public void setUserDB(String userDB) {
        this.userDB = userDB;
    }

}
