package com.cdkj.service.api.impl;

import org.apache.commons.lang3.StringUtils;

import com.cdkj.service.ao.IServeAO;
import com.cdkj.service.ao.ITrainAO;
import com.cdkj.service.api.AProcessor;
import com.cdkj.service.common.DateUtil;
import com.cdkj.service.common.JsonUtil;
import com.cdkj.service.core.StringValidater;
import com.cdkj.service.domain.Train;
import com.cdkj.service.dto.req.XN612096Req;
import com.cdkj.service.exception.BizException;
import com.cdkj.service.exception.ParaException;
import com.cdkj.service.spring.SpringContextHolder;

/**
 * 分页查询服务
 * @author: asus 
 * @since: 2017年6月7日 上午10:23:54 
 * @history:
 */
public class XN612096 extends AProcessor {

    private ITrainAO trainAO = SpringContextHolder.getBean(ITrainAO.class);

    private XN612096Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        Train condition = new Train();
        condition.setName(req.getName());
        condition.setCompanyCode(req.getCompanyCode());
        condition.setCompanyName(req.getCompanyName());
        condition.setStatus(req.getStatus());
        condition.setQualityCode(req.getQualityCode());
        condition.setPublisher(req.getPublisher());
        condition.setProvince(req.getProvince());
        condition.setCity(req.getCity());
        condition.setArea(req.getArea());
        condition.setPublishDatetimeStart(DateUtil.strToDate(
            req.getDateStart(), DateUtil.DATA_TIME_PATTERN_1));
        condition.setPublishDatetimeEnd(DateUtil.strToDate(req.getDateEnd(),
            DateUtil.DATA_TIME_PATTERN_1));
        condition.setDealer(req.getDealer());
        String orderColumn = req.getOrderColumn();
        if (StringUtils.isBlank(orderColumn)) {
            orderColumn = IServeAO.DEFAULT_ORDER_COLUMN;
        }
        condition.setOrder(orderColumn, req.getOrderDir());
        int start = StringValidater.toInteger(req.getStart());
        int limit = StringValidater.toInteger(req.getLimit());
        return trainAO.queryTrainPage(start, limit, condition);
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN612096Req.class);
        StringValidater.validateBlank(req.getStart(), req.getLimit());
    }
}
