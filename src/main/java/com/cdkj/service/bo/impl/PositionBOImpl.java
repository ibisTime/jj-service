package com.cdkj.service.bo.impl;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cdkj.service.bo.IPositionBO;
import com.cdkj.service.bo.base.PaginableBOImpl;
import com.cdkj.service.core.EGeneratePrefix;
import com.cdkj.service.core.OrderNoGenerater;
import com.cdkj.service.core.StringValidater;
import com.cdkj.service.dao.IPositionDAO;
import com.cdkj.service.domain.Position;
import com.cdkj.service.enums.EBoolean;
import com.cdkj.service.exception.BizException;

@Component
public class PositionBOImpl extends PaginableBOImpl<Position> implements
        IPositionBO {

    @Autowired
    private IPositionDAO positionDAO;

    @Override
    public boolean isPositionExist(String code) {
        Position condition = new Position();
        condition.setCode(code);
        if (positionDAO.selectTotalCount(condition) > 0) {
            return true;
        }
        return false;
    }

    @Override
    public String savePosition(Position data) {
        String code = null;
        if (data != null) {
            code = OrderNoGenerater.generateM(EGeneratePrefix.ZW.getCode());
            data.setCode(code);
            // 状态默认设置为 正常
            data.setStatus(EBoolean.YES.getCode());
            // 是否热门默认设置为 否
            data.setIsHot(EBoolean.NO.getCode());
            // 次序默认设置为 0
            data.setOrderNo(0);
            data.setPublishDatetime(new Date());
            positionDAO.insert(data);
        }
        return code;
    }

    @Override
    public int removePosition(String code) {
        int count = 0;
        if (StringUtils.isNotBlank(code)) {
            Position data = new Position();
            data.setCode(code);
            count = positionDAO.delete(data);
        }
        return count;
    }

    @Override
    public int refreshPosition(Position data) {
        int count = 0;
        if (StringUtils.isNotBlank(data.getCode())) {
            data.setPublishDatetime(new Date());
            count = positionDAO.update(data);
        }
        return count;
    }

    @Override
    public List<Position> queryPositionList(Position condition) {
        return positionDAO.selectList(condition);
    }

    @Override
    public Position getPosition(String code) {
        Position data = null;
        if (StringUtils.isNotBlank(code)) {
            Position condition = new Position();
            condition.setCode(code);
            data = positionDAO.select(condition);
            if (data == null) {
                throw new BizException("xn0000", "该职位不存在");
            }
        }
        return data;
    }

    @Override
    public int refreshPositionStatus(String code, String dealer, String dealNote) {
        Position data = new Position();
        data.setCode(code);
        data.setStatus(EBoolean.NO.getCode());
        data.setDealer(dealer);
        data.setDealNote(dealNote);
        data.setDealDatetime(new Date());
        return positionDAO.updateStatus(data);
    }

    @Override
    public int refreshPositionHot(String code, String isHot, String orderNo,
            String dealer) {
        Position data = new Position();
        data.setCode(code);
        data.setIsHot(isHot);
        data.setOrderNo(StringValidater.toInteger(orderNo));
        data.setDealer(dealer);
        data.setDealDatetime(new Date());
        return positionDAO.updateHot(data);
    }
}
