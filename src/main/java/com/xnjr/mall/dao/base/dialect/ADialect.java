package com.xnjr.mall.dao.base.dialect;

/**
 * 用于Mybatis分页sql处理
 * 
 * @author joe.chen
 * 
 */
public abstract class ADialect {

    public abstract boolean supportsLimitOffset();

    public abstract boolean supportsLimit();

    public abstract String getLimitString(String sql, int offset, int limit);
}
