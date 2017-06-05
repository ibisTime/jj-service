package com.cdkj.service.ao.impl;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdkj.service.ao.IPositionAO;
import com.cdkj.service.bo.ICompanyBO;
import com.cdkj.service.bo.IPositionBO;
import com.cdkj.service.bo.ISmsOutBO;
import com.cdkj.service.bo.base.Paginable;
import com.cdkj.service.domain.Position;
import com.cdkj.service.enums.EBoolean;
import com.cdkj.service.exception.BizException;

@Service
public class PositionAOImpl implements IPositionAO {

    @Autowired
    private IPositionBO positionBO;

    @Autowired
    private ICompanyBO companyBO;

    @Autowired
    private ISmsOutBO smsOutBO;

    @Override
    public String addPosition(Position data) {
        return positionBO.savePosition(data);
    }

    @Override
    public int editPosition(Position data) {
        if (!positionBO.isPositionExist(data.getCode())) {
            throw new BizException("xn0000", "职位不存在");
        }
        return positionBO.refreshPosition(data);
    }

    @Override
    public int dropPosition(String code) {
        if (!positionBO.isPositionExist(code)) {
            throw new BizException("xn0000", "职位不存在");
        }
        return positionBO.removePosition(code);
    }

    @Override
    public Paginable<Position> queryPositionPage(int start, int limit,
            Position condition) {
        Paginable<Position> page = positionBO.getPaginable(start, limit,
            condition);
        List<Position> list = page.getList();
        if (CollectionUtils.isNotEmpty(list)) {
            for (Position position : list) {
            }
        }
        return page;
    }

    @Override
    public List<Position> queryPositionList(Position condition) {
        List<Position> list = positionBO.queryPositionList(condition);
        if (CollectionUtils.isNotEmpty(list)) {

        }
        return list;
    }

    @Override
    public Position getPosition(String code) {
        Position position = positionBO.getPosition(code);
        return position;
    }

    @Override
    public int editPositionStatus(String code, String dealer, String dealNote) {
        Position position = positionBO.getPosition(code);
        String publisher = position.getPublisher();
        smsOutBO.sentContent(publisher, publisher,
            "尊敬的企业，您所发布的职位[" + position.getName() + "]已做违规处理，违规原因[" + dealNote
                    + "]。");
        return positionBO.refreshPositionStatus(code, dealer, dealNote);
    }

    @Override
    public int editPositionHot(String code, String isHot, String orderNo,
            String dealer) {
        if (!positionBO.isPositionExist(code)) {
            throw new BizException("xn0000", "职位不存在");
        }
        return positionBO.refreshPositionHot(code, isHot, orderNo, dealer);
    }

    @Override
    public int editPositionHotLocation(String code, String action) {
        Position data = positionBO.getPosition(code);
        Integer location = data.getOrderNo();
        if (null == location) {
            location = 2;
        }
        if (EBoolean.YES.getCode().equalsIgnoreCase(action)) {
            if (location > 0) {
                location--;
            } else {
                throw new BizException("xn0000", "次序不可小于零");
            }
        } else {
            location++;
        }
        return positionBO.refreshPositionHot(data.getCode(), data.getIsHot(),
            String.valueOf(location), data.getDealer());
    }
}
