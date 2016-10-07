/**
 * @Title MybatisWriteDAO.java 
 * @Package com.ibis.pz.base.support 
 * @Description 
 * @author miyb  
 * @date 2015-2-6 上午11:08:10 
 * @version V1.0   
 */
package com.cdkj.service.dao.base.support;

import java.io.Serializable;
import java.util.List;

import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.cdkj.service.dao.base.ABaseDO;

/** 
 * @author: miyb 
 * @since: 2015-2-6 上午11:08:10 
 * @history:
 */
@Repository
public final class MybatisWriteDAO {
    @Autowired
    @Qualifier("writeSqlSessionTemplate")
    private SqlSessionTemplate writeSqlSessionTemplate;

    /**
     * 保存
     * 
     * @param statement
     * @param data
     * @return
     */
    public int insert(String statement, ABaseDO data) {
        return writeSqlSessionTemplate.insert(statement, data);
    }

    /**
     * 批量保存
     * 
     * @param statement
     * @param list
     */
    public void insertBatch(String statement, List<Object> list) {
        SqlSession session = writeSqlSessionTemplate.getSqlSessionFactory()
            .openSession(ExecutorType.BATCH, false);
        try {
            session.insert(statement, list);
            session.commit();
            session.clearCache();
        } finally {
            session.close();
        }

    }

    /**
     * 更新
     * 
     * @param statement
     * @param data
     * @return
     */
    public int update(String statement, ABaseDO data) {
        return writeSqlSessionTemplate.update(statement, data);
    }

    /**
     * 批量更新
     * 
     * @param statement
     * @param list
     */
    public void updateBatch(String statement, List<Object> list) {
        SqlSession session = writeSqlSessionTemplate.getSqlSessionFactory()
            .openSession(ExecutorType.BATCH, false);
        try {
            session.update(statement, list);
            session.commit();
            session.clearCache();
        } finally {
            session.close();
        }

    }

    /**
     * 删除
     * 
     * @param statement
     * @param data
     */
    public int delete(String statement, ABaseDO data) {
        return writeSqlSessionTemplate.delete(statement, data);
    }

    /**
     * 删除
     * 
     * @param statement
     * @param id
     */
    public void delete(String statement, Serializable id) {
        writeSqlSessionTemplate.delete(statement, id);
    }

    /**
     * 批量删除
     * 
     * @param statement
     * @param list
     */
    public void deleteBatch(String statement, List<Object> list) {
        SqlSession session = writeSqlSessionTemplate.getSqlSessionFactory()
            .openSession(ExecutorType.BATCH, false);
        try {
            session.delete(statement, list);
            session.commit();
            session.clearCache();
        } finally {
            session.close();
        }
    }
}
