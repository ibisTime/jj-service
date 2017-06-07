package com.cdkj.service.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.cdkj.service.dao.ITrainDAO;
import com.cdkj.service.dao.base.support.AMybatisTemplate;
import com.cdkj.service.domain.Train;

@Repository("trainDAOImpl")
public class TrainDAOImpl extends AMybatisTemplate implements ITrainDAO {

    @Override
    public int insert(Train data) {
        return super.insert(NAMESPACE.concat("insert_train"), data);
    }

    @Override
    public int delete(Train data) {
        return super.delete(NAMESPACE.concat("delete_train"), data);
    }

    @Override
    public Train select(Train condition) {
        return super.select(NAMESPACE.concat("select_train"), condition,
            Train.class);
    }

    @Override
    public Long selectTotalCount(Train condition) {
        return super.selectTotalCount(NAMESPACE.concat("select_train_count"),
            condition);
    }

    @Override
    public List<Train> selectList(Train condition) {
        return super.selectList(NAMESPACE.concat("select_train"), condition,
            Train.class);
    }

    @Override
    public List<Train> selectList(Train condition, int start, int count) {
        return super.selectList(NAMESPACE.concat("select_train"), start, count,
            condition, Train.class);
    }

    @Override
    public int update(Train data) {
        return super.update(NAMESPACE.concat("update_train"), data);
    }

    @Override
    public int wgclTrain(Train train) {
        return super.update(NAMESPACE.concat("update_wgcl"), train);
    }

    @Override
    public int updateLocation(Train train) {
        return super.update(NAMESPACE.concat("update_location"), train);
    }

}
