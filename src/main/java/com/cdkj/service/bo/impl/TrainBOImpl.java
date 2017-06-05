package com.cdkj.service.bo.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cdkj.service.bo.ITrainBO;
import com.cdkj.service.bo.base.PaginableBOImpl;
import com.cdkj.service.core.EGeneratePrefix;
import com.cdkj.service.core.OrderNoGenerater;
import com.cdkj.service.dao.ITrainDAO;
import com.cdkj.service.domain.Train;
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
    public String saveTrain(Train data) {
        String code = null;
        if (data != null) {
            code = OrderNoGenerater.generateM(EGeneratePrefix.TRAIN.getCode());
            data.setCode(code);
            trainDAO.insert(data);
        }
        return code;
    }

    @Override
    public int removeTrain(String code) {
        int count = 0;
        if (StringUtils.isNotBlank(code)) {
            Train data = new Train();
            data.setCode(code);
            count = trainDAO.delete(data);
        }
        return count;
    }

    @Override
    public int refreshTrain(Train data) {
        int count = 0;
        if (StringUtils.isNotBlank(data.getCode())) {
            count = trainDAO.update(data);
        }
        return count;
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
                throw new BizException("xn0000", "�� ��Ų�����");
            }
        }
        return data;
    }
}
