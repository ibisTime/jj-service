package com.cdkj.service.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.cdkj.service.dao.IServeTrainDAO;
import com.cdkj.service.dao.base.support.AMybatisTemplate;
import com.cdkj.service.domain.ServeTrain;



//CHECK ¼ì²é²¢¼Ó×¢ÊÍ 
@Repository("serveTrainDAOImpl")
public class ServeTrainDAOImpl extends AMybatisTemplate implements IServeTrainDAO {


	@Override
	public int insert(ServeTrain data) {
		return super.insert(NAMESPACE.concat("insert_serveTrain"), data);
	}


	@Override
	public int delete(ServeTrain data) {
		return super.delete(NAMESPACE.concat("delete_serveTrain"), data);
	}


	@Override
	public ServeTrain select(ServeTrain condition) {
		return super.select(NAMESPACE.concat("select_serveTrain"), condition,ServeTrain.class);
	}


	@Override
	public Long selectTotalCount(ServeTrain condition) {
		return super.selectTotalCount(NAMESPACE.concat("select_serveTrain_count"),condition);
	}


	@Override
	public List<ServeTrain> selectList(ServeTrain condition) {
		return super.selectList(NAMESPACE.concat("select_serveTrain"), condition,ServeTrain.class);
	}


	@Override
	public List<ServeTrain> selectList(ServeTrain condition, int start, int count) {
		return super.selectList(NAMESPACE.concat("select_serveTrain"), start, count,condition, ServeTrain.class);
	}


	@Override
	public int update(ServeTrain data) {
		return super.update(NAMESPACE.concat("update_serveTrain"), data);
	}
}