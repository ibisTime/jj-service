package com.cdkj.service.api.impl;

import org.apache.commons.lang3.StringUtils;

import com.cdkj.service.ao.IPhotoAO;
import com.cdkj.service.ao.IServeAO;
import com.cdkj.service.api.AProcessor;
import com.cdkj.service.common.DateUtil;
import com.cdkj.service.common.JsonUtil;
import com.cdkj.service.core.StringValidater;
import com.cdkj.service.domain.Photo;
import com.cdkj.service.dto.req.XN612086Req;
import com.cdkj.service.exception.BizException;
import com.cdkj.service.exception.ParaException;
import com.cdkj.service.spring.SpringContextHolder;

/**
 * 分页查询服务
 * @author: asus 
 * @since: 2017年6月7日 上午10:23:54 
 * @history:
 */
public class XN612086 extends AProcessor {

    private IPhotoAO photoAO = SpringContextHolder.getBean(IPhotoAO.class);

    private XN612086Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        Photo condition = new Photo();
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
        return photoAO.queryPhotoPage(start, limit, condition);
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN612086Req.class);
        StringValidater.validateBlank(req.getStart(), req.getLimit());
    }
}
