/**
 * @Title MybatisReadDAO.java 
 * @Package com.ibis.pz.base.support 
 * @Description 
 * @author miyb  
 * @date 2015-2-6 上午11:06:34 
 * @version V1.0   
 */
package com.cdkj.service.dao.base.support;

import java.io.Serializable;
import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.cdkj.service.dao.base.ABaseDO;

/** 
 * @author: miyb 
 * @since: 2015-2-6 上午11:06:34 
 * @history:
 */
@Repository
public final class MybatisReadDAO {
    @Autowired
    @Qualifier("readSqlSessionTemplate")
    private SqlSessionTemplate readSqlSessionTemplate;

    /**
     * 查询
     * 
     * @param statement
     * @param id
     * @return
     */
    public <T> T select(String statement, Serializable id) {
        return readSqlSessionTemplate.<T> selectOne(statement, id);
    }

    /**
     * 查询
     * 
     * @param statement
     * @param data
     * @return
     */
    public <T> T select(String statement, ABaseDO data) {
        return readSqlSessionTemplate.<T> selectOne(statement, data);
    }

    /**
     * 查询
     * 
     * @param statement
     * @param data
     * @return
     */
    public <E> List<E> selectList(String statement, ABaseDO data) {
        return readSqlSessionTemplate.<E> selectList(statement, data);
    }

    /**
     * 查询
     * 
     * @param statement
     * @param data
     * @return
     */
    public <E> List<E> selectList(String statement, int start, int count,
            ABaseDO data) {
        RowBounds rb = new RowBounds(start, count);
        return readSqlSessionTemplate.<E> selectList(statement, data, rb);
    }

    /**
     * 查询总数
     * 
     * @param statement
     * @param data
     * @return
     */
    public Long selectTotalCount(String statement, ABaseDO data) {
        return readSqlSessionTemplate.<Long> selectOne(statement, data);
    }

    /**
     * 获取所有数据
     * 
     * @param statement
     * @return
     */
    public <E> List<E> selectAll(String statement) {
        return readSqlSessionTemplate.<E> selectList(statement);
    }
}
