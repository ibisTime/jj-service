package com.cdkj.service.ao.impl;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cdkj.service.ao.IServeAO;
import com.cdkj.service.bo.ICbIntentionBO;
import com.cdkj.service.bo.ICompanyBO;
import com.cdkj.service.bo.IGsQualifyBO;
import com.cdkj.service.bo.IQualifyBO;
import com.cdkj.service.bo.IServeArtBO;
import com.cdkj.service.bo.IServeBO;
import com.cdkj.service.bo.IServeCpBO;
import com.cdkj.service.bo.IServeCyyBO;
import com.cdkj.service.bo.IServeKfwbBO;
import com.cdkj.service.bo.ISmsOutBO;
import com.cdkj.service.bo.IUserBO;
import com.cdkj.service.bo.base.Paginable;
import com.cdkj.service.core.StringValidater;
import com.cdkj.service.domain.CbIntention;
import com.cdkj.service.domain.Company;
import com.cdkj.service.domain.GsQualify;
import com.cdkj.service.domain.Qualify;
import com.cdkj.service.domain.Serve;
import com.cdkj.service.domain.ServeArt;
import com.cdkj.service.domain.ServeCp;
import com.cdkj.service.domain.ServeCyy;
import com.cdkj.service.domain.ServeKfwb;
import com.cdkj.service.domain.User;
import com.cdkj.service.dto.req.XN612126Req;
import com.cdkj.service.dto.req.XN612127Req;
import com.cdkj.service.enums.EBoolean;
import com.cdkj.service.enums.ECompanyStatus;
import com.cdkj.service.exception.BizException;

@Service
public class ServeAOImpl implements IServeAO {

    @Autowired
    private IServeBO serveBO;

    @Autowired
    private IGsQualifyBO gsQualifyBO;

    @Autowired
    private IQualifyBO qualifyBO;

    @Autowired
    private IServeArtBO serveArtBO;

    @Autowired
    private IServeCpBO serveCpBO;

    @Autowired
    private IServeCyyBO serveCyyBO;

    @Autowired
    private IServeKfwbBO serveKfwbBO;

    @Autowired
    private ICompanyBO companyBO;

    @Autowired
    private IUserBO userBO;

    @Autowired
    private ICbIntentionBO cbIntentionBO;

    @Autowired
    private ISmsOutBO smsOutBO;

    @Override
    public String addServe(XN612126Req req) {
        String code = null;
        GsQualify gsQualify = gsQualifyBO.getGsQualify(req.getQualityCode());
        Qualify qualify = qualifyBO.getQualify(gsQualify.getQualifyCode());
        if (gsQualify.getCompanyCode().equals(req.getCompanyCode())
                && ECompanyStatus.PASS_YES.getCode().equals(
                    gsQualify.getStatus())) {
            code = serveBO.saveServe(req.getName(), req.getPic(),
                req.getAdvPic(), req.getCompanyCode(),
                StringValidater.toLong(req.getQuoteMin()),
                StringValidater.toLong(req.getQuoteMax()),
                req.getQualityCode(), req.getDescription(), req.getPublisher(),
                qualify.getCode());
        }
        return code;
    }

    @Override
    public void editServe(XN612127Req req) {
        Serve serve = serveBO.getServe(req.getCode());
        serveBO.refreshServe(serve, req.getName(), req.getPic(),
            req.getAdvPic(), StringValidater.toLong(req.getQuoteMin()),
            StringValidater.toLong(req.getQuoteMax()), req.getDescription(),
            req.getPublisher());
    }

    @Transactional
    @Override
    public void dropServe(String code) {
        if (!serveBO.isServeExist(code)) {
            throw new BizException("xn0000", "服务不存在");
        }
        serveBO.removeServe(code);
        // 扫描各子表，若存在该服务则删除
        if (serveArtBO.isServeArtExist(code)) {
            serveArtBO.removeServeArt(code);
        } else if (serveCpBO.isServeCpExist(code)) {
            serveCpBO.removeServeCp(code);
        } else if (serveCyyBO.isServeCyyExist(code)) {
            serveCyyBO.removeServeCyy(code);
        } else if (serveKfwbBO.isServeKfwbExist(code)) {
            serveKfwbBO.removeServeKfwb(code);
        }
        List<CbIntention> list = cbIntentionBO.queryCbIntentionList(null, null,
            code);
        for (CbIntention cbIntention : list) {
            cbIntentionBO.dropCbIntention(cbIntention.getCode());
        }
    }

    @Override
    public Paginable<Serve> queryServePage(int start, int limit, Serve condition) {
        Paginable<Serve> page = serveBO.getPaginable(start, limit, condition);
        List<Serve> list = page.getList();
        if (CollectionUtils.isNotEmpty(list)) {
            for (Serve serve : list) {
                this.addServeExt(serve);
                Company company = companyBO.getCompany(serve.getCompanyCode());
                User user = userBO.getRemoteUser(company.getUserId());
                company.setRealName(user.getLoginName());
                Qualify qualify = qualifyBO.getQualify(serve.getQualifyCode());
                serve.setQualityName(qualify.getName());
                serve.setCompany(company);
            }
        }
        return page;
    }

    // 添加服务详情信息
    private void addServeExt(Serve data) {
        GsQualify gsQualify = gsQualifyBO.getGsQualify(data.getQualityCode());
        Qualify qualify = qualifyBO.getQualify(gsQualify.getQualifyCode());
        switch (qualify.getType()) {
            case "3":
                ServeArt serveArt = serveArtBO.getServeArt(data.getCode());
                data.setServeArt(serveArt);
                break;
            case "5":
                ServeKfwb serveKfwb = serveKfwbBO.getServeKfwb(data.getCode());
                data.setServeKfwb(serveKfwb);
                break;
            case "6":
                ServeCp serveCp = serveCpBO.getServeCp(data.getCode());
                data.setServeCp(serveCp);
                break;
            case "7":
                break;
            case "8":
                ServeCyy serveCyy = serveCyyBO.getServeCyy(data.getCode());
                data.setServeCyy(serveCyy);
                break;
            default:
                throw new BizException("xn0000", "服务类型填写错误");
        }
    }

    @Override
    public List<Serve> queryServeList(Serve condition) {
        return serveBO.queryServeList(condition);
    }

    @Override
    public Serve getServe(String code) {
        Serve serve = serveBO.getServe(code);
        this.addServeExt(serve);
        Company company = companyBO.getCompany(serve.getCompanyCode());
        User user = userBO.getRemoteUser(company.getUserId());
        company.setRealName(user.getLoginName());
        serve.setCompany(company);
        return serve;
    }

    @Override
    public void editServeStatus(String code, String dealer, String dealNote) {
        Serve serve = serveBO.getServe(code);
        if (EBoolean.NO.getCode().equals(serve.getStatus())) {
            throw new BizException("xn0000", "该服务已做违规处理");
        }
        String publisher = serve.getPublisher();
        smsOutBO.sentContent(publisher, "尊敬的企业，您所发布的服务[" + serve.getName()
                + "]已做违规处理，违规原因[" + dealNote + "]。");
        serveBO.refreshServeStatus(serve, dealer, dealNote);
    }

    @Override
    public void editLocation(String code, String location, String orderNo,
            String dealer) {
        Serve serve = serveBO.getServe(code);
        if (EBoolean.NO.getCode().equals(serve.getStatus())) {
            throw new BizException("xn0000", "服务已违规,不可设置为热门");
        }
        if (!EBoolean.NO.getCode().equals(orderNo)) {
            List<Serve> serveList = serveBO.queryServeList(
                EBoolean.YES.getCode(), location, orderNo);
            if (CollectionUtils.isNotEmpty(serveList)) {
                throw new BizException("xn0000", "顺序重复");
            }
        }
        serveBO.refreshLocation(serve, location, orderNo, dealer);
    }
}
