package com.cdkj.service.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.cdkj.service.dao.IServeShopDAO;
import com.cdkj.service.dao.base.support.AMybatisTemplate;
import com.cdkj.service.domain.ServeShop;

@Repository("serveShopDAOImpl")
public class ServeShopDAOImpl extends AMybatisTemplate implements IServeShopDAO {

    @Override
    public int insert(ServeShop data) {
        return super.insert(NAMESPACE.concat("insert_serveShop"), data);
    }

    @Override
    public int delete(ServeShop data) {
        return super.delete(NAMESPACE.concat("delete_serveShop"), data);
    }

    @Override
    public ServeShop select(ServeShop condition) {
        return super.select(NAMESPACE.concat("select_serveShop"), condition,
            ServeShop.class);
    }

    @Override
    public Long selectTotalCount(ServeShop condition) {
        return super.selectTotalCount(
            NAMESPACE.concat("select_serveShop_count"), condition);
    }

    @Override
    public List<ServeShop> selectList(ServeShop condition) {
        return super.selectList(NAMESPACE.concat("select_serveShop"),
            condition, ServeShop.class);
    }

    @Override
    public List<ServeShop> selectList(ServeShop condition, int start, int count) {
        return super.selectList(NAMESPACE.concat("select_serveShop"), start,
            count, condition, ServeShop.class);
    }

    @Override
    public int update(ServeShop data) {
        return super.update(NAMESPACE.concat("update_serveShop"), data);
    }
}
