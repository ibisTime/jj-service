package com.cdkj.service.ao.impl;

import java.util.Date;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdkj.service.ao.IPositionAO;
import com.cdkj.service.bo.ICompanyBO;
import com.cdkj.service.bo.IPositionBO;
import com.cdkj.service.bo.ISmsOutBO;
import com.cdkj.service.bo.base.Paginable;
import com.cdkj.service.core.EGeneratePrefix;
import com.cdkj.service.core.OrderNoGenerater;
import com.cdkj.service.core.StringValidater;
import com.cdkj.service.domain.Position;
import com.cdkj.service.dto.req.XN612150Req;
import com.cdkj.service.dto.req.XN612152Req;
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
    public String addPosition(XN612150Req req) {
        Position data = new Position();
        String code = OrderNoGenerater.generateM(EGeneratePrefix.ZW.getCode());
        data.setCode(code);
        data.setName(req.getName());
        data.setKind(req.getKind());
        data.setProvince(req.getProvince());
        data.setCity(req.getCity());

        data.setArea(req.getArea());
        data.setExperience(req.getExperience());
        data.setEducation(req.getEducation());
        data.setType(req.getType());
        data.setJobNum(StringValidater.toInteger(req.getJobNum()));

        data.setMsalary(req.getMsalary());
        data.setDescription(req.getDescription());
        data.setCompanyCode(req.getCompanyCode());
        data.setPublisher(req.getPublisher());
        // 状态默认设置为 正常
        data.setStatus(EBoolean.YES.getCode());

        // 是否热门默认设置为 否
        data.setLocation(EBoolean.NO.getCode());
        // 次序默认设置为 0
        data.setOrderNo(0);
        data.setPublishDatetime(new Date());
        positionBO.savePosition(data);
        return code;
    }

    @Override
    public void editPosition(XN612152Req req) {
        Position data = positionBO.getPosition(req.getCode());
        data.setName(req.getName());
        data.setKind(req.getKind());
        data.setProvince(req.getProvince());
        data.setCity(req.getCity());
        data.setExperience(req.getExperience());
        data.setEducation(req.getEducation());
        data.setType(req.getType());
        data.setJobNum(StringValidater.toInteger(req.getJobNum()));
        data.setMsalary(req.getMsalary());
        data.setDescription(req.getDescription());
        data.setCompanyCode(req.getCompanyCode());
        data.setPublisher(req.getPublisher());
        data.setPublishDatetime(new Date());
        positionBO.refreshPosition(data);
    }

    @Override
    public void dropPosition(String code) {
        if (!positionBO.isPositionExist(code)) {
            throw new BizException("xn0000", "职位不存在");
        }
        positionBO.removePosition(code);
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
    public void editPositionStatus(String code, String dealer, String dealNote) {
        Position position = positionBO.getPosition(code);
        String publisher = position.getPublisher();
        smsOutBO.sentContent(publisher, publisher,
            "尊敬的企业，您所发布的职位[" + position.getName() + "]已做违规处理，违规原因[" + dealNote
                    + "]。");
        positionBO.refreshPositionStatus(code, dealer, dealNote);
    }

    @Override
    public void editPositionHot(String code, String isHot, String orderNo,
            String dealer) {
        if (!positionBO.isPositionExist(code)) {
            throw new BizException("xn0000", "职位不存在");
        }
        positionBO.refreshPositionHot(code, isHot, orderNo, dealer);
    }

    @Override
    public void editPositionHotLocation(String code, String action) {
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
        positionBO.refreshPositionHot(data.getCode(), null,
            String.valueOf(location), data.getDealer());
    }
}
