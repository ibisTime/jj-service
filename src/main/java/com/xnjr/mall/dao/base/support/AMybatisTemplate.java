/**
 * @Title AMybatisTemplate.java 
 * @Package com.ibis.pz.base.support 
 * @Description 
 * @author miyb  
 * @date 2015-2-6 上午11:05:03 
 * @version V1.0   
 */
package com.xnjr.mall.dao.base.support;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.xnjr.mall.dao.base.ABaseDO;

/** 
 * @author: miyb 
 * @since: 2015-2-6 上午11:05:03 
 * @history:
 */
public abstract class AMybatisTemplate {
    @Autowired
    private MybatisReadDAO readDao;

    @Autowired
    private MybatisWriteDAO writeDao;

    /**
     * 按Id查询数据
     * 
     * @param statement
     * @param id
     * @return
     */
    @SuppressWarnings("unchecked")
    protected <T> T select(String statement, Serializable id, Class<T> clazz) {
        return (T) readDao.select(statement, id);
    }

    /**
     * 按给定条件查询数据
     * 
     * @param statement
     * @param data
     * @return
     */
    @SuppressWarnings("unchecked")
    protected <T> T select(String statement, ABaseDO data, Class<T> clazz) {
        return (T) readDao.select(statement, data);
    }

    /**
     * 按给定条件查询数据列表
     * 
     * @param statement
     * @param data
     * @return
     */
    protected <E> List<E> selectList(String statement, ABaseDO data,
            Class<E> clazz) {
        return readDao.selectList(statement, data);
    }

    /**
     * 分页查询
     * 
     * @param statement
     * @param start
     * @param count
     * @param data
     * @return
     */
    protected <E> List<E> selectList(String statement, int start, int count,
            ABaseDO data, Class<E> clazz) {
        return readDao.selectList(statement, start, count, data);
    }

    /**
     * 按给定条件查询数据总数
     * 
     * @param statement
     * @param data
     * @return
     */
    protected Long selectTotalCount(String statement, ABaseDO data) {
        return readDao.selectTotalCount(statement, data);
    }

    /**
     * 查询所有数据
     * 
     * @param statement
     * @return
     */
    protected <E> List<E> selectAll(String statement, Class<E> clazz) {
        return readDao.selectAll(statement);
    }

    /**
     * 保存数据
     * 
     * @param statement
     * @param data
     * @return
     */
    protected int insert(String statement, ABaseDO data) {
        return writeDao.insert(statement, data);
    }

    /**
     * 批量保存
     * 
     * @param statement
     * @param list
     */
    protected void insertBatch(String statement, List<Object> list) {
        writeDao.insertBatch(statement, list);
    }

    /**
     * 更新数据
     * 
     * @param statement
     * @param data
     * @return
     */
    protected int update(String statement, ABaseDO data) {
        return writeDao.update(statement, data);
    }

    /**
     * 批量更新
     * 
     * @param statement
     * @param list
     */
    protected void updateBatch(String statement, List<Object> list) {
        writeDao.updateBatch(statement, list);
    }

    /**
     * 删除数据
     * 
     * @param statement
     * @param data
     */
    protected int delete(String statement, ABaseDO data) {
        return writeDao.delete(statement, data);
    }

    /**
     * 按Id删除数据
     * 
     * @param statement
     * @param id
     */
    protected void delete(String statement, Serializable id) {
        writeDao.delete(statement, id);
    }

    /**
     * 批量删除
     * 
     * @param statement
     * @param list
     */
    protected void deleteBatch(String statement, List<Object> list) {
        writeDao.deleteBatch(statement, list);
    }

}
