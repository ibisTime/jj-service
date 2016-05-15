package com.xnjr.mall.api.impl;

import com.xnjr.mall.ao.IPTCompanyCardAO;
import com.xnjr.mall.api.AProcessor;
import com.xnjr.mall.common.DateUtil;
import com.xnjr.mall.common.JsonUtil;
import com.xnjr.mall.core.StringValidater;
import com.xnjr.mall.domain.PTCompanyCard;
import com.xnjr.mall.dto.req.XNpt4001Req;
import com.xnjr.mall.dto.res.XNpt4001Res;
import com.xnjr.mall.exception.BizException;
import com.xnjr.mall.exception.ParaException;
import com.xnjr.mall.spring.SpringContextHolder;

/** 
 * 修改公司账号
 * @author: xieyj 
 * @since: 2016年3月6日 上午9:20:26 
 * @history:
 */
public class XNpt4001 extends AProcessor {

    private IPTCompanyCardAO platAccountAO = SpringContextHolder
        .getBean(IPTCompanyCardAO.class);

    private XNpt4001Req req = null;

    /** 
     * @see com.xnjr.mall.api.IProcessor#doBusiness()
     */
    @Override
    public Object doBusiness() throws BizException {
        PTCompanyCard data = new PTCompanyCard();
        data.setCode(req.getCode());
        data.setCompanyCode(req.getCompanyCode());
        data.setSubbranchCode(req.getSubbranchCode());
        data.setKind(req.getKind());
        data.setCurrency(req.getCurrency());

        data.setCardNo(req.getCardNo());
        data.setLimitDescription(req.getLimitDescription());
        data.setIsEbank(req.getIsEbank());
        data.setIsEticket(req.getIsEticket());
        data.setHdWay(req.getHdWay());

        data.setHdAddress(req.getHdAddress());
        data.setHdCardPwd(req.getHdCardPwd());
        data.setHdAccountPwd(req.getHdAccountPwd());
        data.setYedzdWay(req.getYedzdWay());
        data.setYedzdAddress(req.getYedzdAddress());

        data.setYedzdAccountPwd(req.getYedzdAccountPwd());
        data.setLsdzdWay(req.getLsdzdWay());
        data.setLsdzdAddress(req.getLsdzdAddress());
        data.setLsdzdAccountPwd(req.getLsdzdAccountPwd());
        data.setGtPerson(req.getGtPerson());

        data.setGtContact(req.getGtContact());
        data.setKhPerson(req.getKhPerson());
        data.setKhDatetime(DateUtil.strToDate(req.getKhDatetime(),
            DateUtil.DATA_TIME_PATTERN_1));
        data.setPdf(req.getPdf());

        data.setUpdater(req.getUpdater());
        data.setRemark(req.getRemark());
        return new XNpt4001Res(platAccountAO.editPTCompanyCard(data));
    }

    /** 
     * @see com.xnjr.mall.api.IProcessor#doCheck(java.lang.String)
     */
    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XNpt4001Req.class);
        StringValidater.validateBlank(req.getCode(), req.getCompanyCode(),
            req.getSubbranchCode(), req.getKind(), req.getCardNo(),
            req.getLimitDescription(), req.getIsEbank(), req.getIsEticket(),
            req.getHdWay(), req.getYedzdWay(), req.getLsdzdWay(),
            req.getGtPerson(), req.getGtContact(), req.getKhPerson(),
            req.getKhDatetime(), req.getPdf(), req.getUpdater());
    }
}
