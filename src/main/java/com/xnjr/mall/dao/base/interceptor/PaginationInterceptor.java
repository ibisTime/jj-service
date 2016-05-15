package com.xnjr.mall.dao.base.interceptor;

import java.sql.Connection;
import java.util.Properties;

import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.SqlSource;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Plugin;
import org.apache.ibatis.plugin.Signature;
import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.reflection.factory.DefaultObjectFactory;
import org.apache.ibatis.reflection.wrapper.DefaultObjectWrapperFactory;
import org.apache.ibatis.session.RowBounds;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.xnjr.mall.dao.base.dialect.ADialect;

/**
 * 分页插件
 * 
 * @author joe.chen
 * 
 */
@Intercepts({ @Signature(type = StatementHandler.class, method = "prepare", args = { Connection.class }) })
public final class PaginationInterceptor implements Interceptor {

    private final static Logger log = LoggerFactory
        .getLogger(PaginationInterceptor.class);

    private ADialect dialect;

    public void setDialect(ADialect dialect) {
        this.dialect = dialect;
    }

    @Override
    public Object intercept(Invocation invocation) throws Throwable {

        StatementHandler statementHandler = (StatementHandler) invocation
            .getTarget();

        BoundSql boundSql = statementHandler.getBoundSql();

        MetaObject metaStatementHandler = MetaObject.forObject(
            statementHandler, new DefaultObjectFactory(),
            new DefaultObjectWrapperFactory());

        RowBounds rowBounds = (RowBounds) metaStatementHandler
            .getValue("delegate.rowBounds".intern());

        if (rowBounds == null || rowBounds == RowBounds.DEFAULT) {

            return invocation.proceed();

        }

        String originalSql = (String) metaStatementHandler
            .getValue("delegate.boundSql.sql".intern());

        metaStatementHandler.setValue("delegate.boundSql.sql".intern(), dialect
            .getLimitString(originalSql, rowBounds.getOffset(),
                rowBounds.getLimit()));

        metaStatementHandler.setValue("delegate.rowBounds.offset".intern(),
            RowBounds.NO_ROW_OFFSET);

        metaStatementHandler.setValue("delegate.rowBounds.limit".intern(),
            RowBounds.NO_ROW_LIMIT);

        log.debug("page sql : " + boundSql.getSql());

        return invocation.proceed();

    }

    public static class BoundSqlSqlSource implements SqlSource {
        BoundSql boundSql;

        public BoundSqlSqlSource(BoundSql boundSql) {
            this.boundSql = boundSql;
        }

        public BoundSql getBoundSql(Object parameterObject) {
            return boundSql;
        }
    }

    @Override
    public Object plugin(Object target) {

        return Plugin.wrap(target, this);

    }

    @Override
    public void setProperties(Properties properties) {

    }

}
