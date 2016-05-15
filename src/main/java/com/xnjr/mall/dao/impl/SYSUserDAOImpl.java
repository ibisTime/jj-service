package com.xnjr.mall.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.xnjr.mall.dao.ISYSUserDAO;
import com.xnjr.mall.dao.base.support.AMybatisTemplate;
import com.xnjr.mall.domain.SYSUser;

@Repository("sysUserDAOImpl")
public class SYSUserDAOImpl extends AMybatisTemplate implements ISYSUserDAO {

    @Override
    public int insert(SYSUser data) {
        return super.insert(NAMESPACE.concat("insert_sysUser"), data);
    }

    @Override
    public int delete(SYSUser data) {
        return super.delete(NAMESPACE.concat("delete_sysUser"), data);
    }

    @Override
    public SYSUser select(SYSUser condition) {
        return super.select(NAMESPACE.concat("select_sysUser"), condition,
            SYSUser.class);
    }

    @Override
    public Long selectTotalCount(SYSUser condition) {
        return super.selectTotalCount(NAMESPACE.concat("select_sysUser_count"),
            condition);
    }

    @Override
    public List<SYSUser> selectList(SYSUser condition) {
        return super.selectList(NAMESPACE.concat("select_sysUser"), condition,
            SYSUser.class);
    }

    @Override
    public List<SYSUser> selectList(SYSUser condition, int start, int count) {
        return super.selectList(NAMESPACE.concat("select_sysUser"), start,
            count, condition, SYSUser.class);
    }

    @Override
    public int updateSYSUser(SYSUser data) {
        return super.update(NAMESPACE.concat("update_sysUser"), data);
    }

    @Override
    public int updateSYSUserRealInfo(SYSUser data) {
        return super.update(NAMESPACE.concat("update_sysUserRealInfo"), data);
    }

    @Override
    public int updateSYSUserLoginPwd(SYSUser data) {
        return super.update(NAMESPACE.concat("update_sysUserLoginPwd"), data);
    }

    @Override
    public int updateSYSUserTradePwd(SYSUser data) {
        return super.update(NAMESPACE.concat("update_sysUserTradePwd"), data);
    }

    @Override
    public int updateSYSUserContact(SYSUser data) {
        return super.update(NAMESPACE.concat("update_sysUserContact"), data);
    }

    @Override
    public int updateSYSUserRoleCode(SYSUser data) {
        return super.update(NAMESPACE.concat("update_sysUserRoleCode"), data);
    }

}
