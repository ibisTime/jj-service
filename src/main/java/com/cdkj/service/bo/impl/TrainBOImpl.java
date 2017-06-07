package com.cdkj.service.bo.impl;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cdkj.service.bo.ITrainBO;
import com.cdkj.service.bo.base.PaginableBOImpl;
import com.cdkj.service.dao.ITrainDAO;
import com.cdkj.service.domain.Train;
import com.cdkj.service.enums.EBoolean;
import com.cdkj.service.exception.BizException;

@Component
public class TrainBOImpl extends PaginableBOImpl<Train> implements ITrainBO {

    @Autowired
    private ITrainDAO trainDAO;

    @Override
    public boolean isTrainExist(String code) {
        Train condition = new Train();
        condition.setCode(code);
        if (trainDAO.selectTotalCount(condition) > 0) {
            return true;
        }
        return false;
    }

    @Override
    public void saveTrain(Train data) {
        trainDAO.insert(data);
    }

    @Override
    public void removeTrain(String code) {
        if (StringUtils.isNotBlank(code)) {
            Train data = new Train();
            data.setCode(code);
            trainDAO.delete(data);
        }
    }

    @Override
    public void refreshTrain(Train data) {
        trainDAO.update(data);
    }

    @Override
    public List<Train> queryTrainList(Train condition) {
        return trainDAO.selectList(condition);
    }

    @Override
    public Train getTrain(String code) {
        Train data = null;
        if (StringUtils.isNotBlank(code)) {
            Train condition = new Train();
            condition.setCode(code);
            data = trainDAO.select(condition);
            if (data == null) {
                throw new BizException("xn0000", "不存在该编号");
            }
        }
        return data;
    }

    @Override
    public void wgclTrain(Train train, String dealer, String dealNote) {
        train.setStatus(EBoolean.NO.getCode());
        train.setDealer(dealer);
        train.setDealDatetime(new Date());
        train.setDealNote(dealNote);
        trainDAO.wgclTrain(train);
    }

    @Override
    public List<Train> queryTrainList(String location, String orderNo) {
        Train condition = new Train();
        condition.setLocation(location);
        condition.setOrderNo(orderNo);
        return trainDAO.selectList(condition);
    }

    @Override
    public void refreshLocation(Train train, String location, String orderNo,
            String dealer) {
        train.setLocation(location);
        train.setOrderNo(orderNo);
        train.setDealer(dealer);
        train.setDealDatetime(new Date());
        trainDAO.updateLocation(train);
    }
}
