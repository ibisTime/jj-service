package com.cdkj.service.ao.impl;

import java.util.Date;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdkj.service.ao.IOperateAO;
import com.cdkj.service.bo.ICompanyBO;
import com.cdkj.service.bo.IGsQualifyBO;
import com.cdkj.service.bo.IOperateBO;
import com.cdkj.service.bo.IQualifyBO;
import com.cdkj.service.bo.ISmsOutBO;
import com.cdkj.service.bo.IUserBO;
import com.cdkj.service.bo.base.Paginable;
import com.cdkj.service.core.EGeneratePrefix;
import com.cdkj.service.core.OrderNoGenerater;
import com.cdkj.service.core.StringValidater;
import com.cdkj.service.domain.Company;
import com.cdkj.service.domain.GsQualify;
import com.cdkj.service.domain.Operate;
import com.cdkj.service.domain.Qualify;
import com.cdkj.service.domain.User;
import com.cdkj.service.dto.req.XN612110Req;
import com.cdkj.service.dto.req.XN612112Req;
import com.cdkj.service.enums.EBoolean;
import com.cdkj.service.enums.ECompanyStatus;
import com.cdkj.service.exception.BizException;

@Service
public class OperateAOImpl implements IOperateAO {

    @Autowired
    private IOperateBO operateBO;

    @Autowired
    private ISmsOutBO smsOutBO;

    @Autowired
    private ICompanyBO companyBO;

    @Autowired
    private IUserBO userBO;

    @Autowired
    private IQualifyBO qualifyBO;

    @Autowired
    private IGsQualifyBO gsQualifyBO;

    @Override
    public String addOperate(XN612110Req req) {
        String code = null;
        GsQualify gsQualify = gsQualifyBO.queryGsQualifyList(req
            .getCompanyCode());
        if (null != gsQualify
                && ECompanyStatus.PASS_YES.getCode().equals(
                    gsQualify.getStatus())) {
            Operate data = new Operate();
            code = OrderNoGenerater
                .generateM(EGeneratePrefix.OPERATE.getCode());
            data.setCode(code);
            data.setName(req.getName());
            data.setPic(req.getPic());
            data.setAdvPic(req.getAdvPic());
            data.setCompanyCode(req.getCompanyCode());

            data.setQuoteMin(StringValidater.toLong(req.getQuoteMin()));
            data.setQuoteMax(StringValidater.toLong(req.getQuoteMax()));
            data.setTgfw(req.getTgfw());
            data.setFeeMode(req.getFeeMode());
            data.setPayCycle(req.getPayCycle());

            data.setScyylm(req.getScyylm());
            data.setSucCase(req.getSucCase());
            data.setLocation(EBoolean.NO.getCode());
            data.setOrderNo(EBoolean.NO.getCode());
            data.setDescription(req.getDescription());

            data.setStatus(EBoolean.YES.getCode());
            data.setPublisher(req.getPublisher());
            data.setPublishDatetime(new Date());
            data.setQualifyCode(gsQualify.getQualifyCode());
            operateBO.saveOperate(data);
        } else {
            throw new BizException("xn0000", "公司还未获得该资质");
        }
        return code;
    }

    @Override
    public void editOperate(XN612112Req req) {
        Operate data = operateBO.getOperate(req.getCode());
        data.setName(req.getName());
        data.setPic(req.getPic());
        data.setAdvPic(req.getAdvPic());
        data.setQuoteMin(StringValidater.toLong(req.getQuoteMin()));
        data.setQuoteMax(StringValidater.toLong(req.getQuoteMax()));

        data.setTgfw(req.getTgfw());
        data.setFeeMode(req.getFeeMode());
        data.setPayCycle(req.getPayCycle());
        data.setScyylm(req.getScyylm());
        data.setSucCase(req.getSucCase());

        data.setDescription(req.getDescription());
        data.setPublisher(req.getPublisher());
        data.setPublishDatetime(new Date());
        operateBO.refreshOperate(data);
    }

    @Override
    public void dropOperate(String code) {
        if (!operateBO.isOperateExist(code)) {
            throw new BizException("xn0000", "记录编号不存在");
        }
        operateBO.removeOperate(code);
    }

    @Override
    public Paginable<Operate> queryOperatePage(int start, int limit,
            Operate condition) {
        Paginable<Operate> page = operateBO.getPaginable(start, limit,
            condition);
        List<Operate> list = page.getList();
        if (CollectionUtils.isNotEmpty(list)) {
            for (Operate operate : list) {
                Company company = companyBO
                    .getCompany(operate.getCompanyCode());
                User user = userBO.getRemoteUser(company.getUserId());
                company.setRealName(user.getNickname());
                Qualify qualify = qualifyBO
                    .getQualify(operate.getQualifyCode());
                operate.setQualityName(qualify.getName());
                operate.setCompany(company);
            }
        }
        return page;
    }

    @Override
    public List<Operate> queryOperateList(Operate condition) {
        return operateBO.queryOperateList(condition);
    }

    @Override
    public Operate getOperate(String code) {
        return operateBO.getOperate(code);
    }

    @Override
    public void wgclOperate(String code, String dealer, String dealNote) {
        Operate operate = operateBO.getOperate(code);
        if (EBoolean.NO.getCode().equals(operate.getStatus())) {
            throw new BizException("xn0000", "该服务已做违规处理");
        }
        String publisher = operate.getPublisher();
        smsOutBO.sentContent(publisher, "尊敬的企业，您所发布的培训服务[" + operate.getName()
                + "]已做违规处理，违规原因[" + dealNote + "]。");
        operateBO.wgclOperate(operate, dealer, dealNote);
    }

    @Override
    public void editLocation(String code, String location, String orderNo,
            String dealer) {
        Operate operate = operateBO.getOperate(code);
        if (EBoolean.NO.getCode().equals(operate.getStatus())) {
            throw new BizException("xn0000", "服务已违规,不可设置为热门");
        }
        if (!EBoolean.NO.getCode().equals(orderNo)) {
            List<Operate> operateList = operateBO.queryOperateList(
                EBoolean.YES.getCode(), location, orderNo);
            if (CollectionUtils.isNotEmpty(operateList)) {
                throw new BizException("xn0000", "顺序重复");
            }
        }
        operateBO.refreshLocation(operate, location, orderNo, dealer);
    }
}
