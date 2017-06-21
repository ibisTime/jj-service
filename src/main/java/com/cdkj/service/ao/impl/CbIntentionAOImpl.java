package com.cdkj.service.ao.impl;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdkj.service.ao.ICbIntentionAO;
import com.cdkj.service.bo.ICbIntentionBO;
import com.cdkj.service.bo.ICompanyBO;
import com.cdkj.service.bo.IOperateBO;
import com.cdkj.service.bo.IPhotoBO;
import com.cdkj.service.bo.IPositionBO;
import com.cdkj.service.bo.IResumeBO;
import com.cdkj.service.bo.IServeBO;
import com.cdkj.service.bo.ISmsOutBO;
import com.cdkj.service.bo.ITrainBO;
import com.cdkj.service.bo.IUserBO;
import com.cdkj.service.bo.base.Paginable;
import com.cdkj.service.core.EGeneratePrefix;
import com.cdkj.service.core.OrderNoGenerater;
import com.cdkj.service.domain.CbIntention;
import com.cdkj.service.domain.Company;
import com.cdkj.service.domain.Operate;
import com.cdkj.service.domain.Photo;
import com.cdkj.service.domain.Position;
import com.cdkj.service.domain.Resume;
import com.cdkj.service.domain.Serve;
import com.cdkj.service.domain.Train;
import com.cdkj.service.domain.User;
import com.cdkj.service.dto.req.XN612170Req;
import com.cdkj.service.dto.res.XN612176Res;
import com.cdkj.service.enums.EBoolean;
import com.cdkj.service.enums.ECbIntentionStatus;
import com.cdkj.service.enums.ECbIntentionType;
import com.cdkj.service.exception.BizException;

@Service
public class CbIntentionAOImpl implements ICbIntentionAO {

    @Autowired
    private ICbIntentionBO cbIntentionBO;

    @Autowired
    private IPositionBO positionBO;

    @Autowired
    private IServeBO serveBO;

    @Autowired
    private IPhotoBO photoBO;

    @Autowired
    private IOperateBO operateBO;

    @Autowired
    private ITrainBO trainBO;

    @Autowired
    private IResumeBO resumeBO;

    @Autowired
    private ICompanyBO companyBO;

    @Autowired
    private IUserBO userBO;

    @Autowired
    private ISmsOutBO smsOutBO;

    @Override
    public String addCbIntention(XN612170Req req) {
        String companyCode = null;
        String serveCode = null;
        if (ECbIntentionType.POSITION.getCode().equals(req.getType())) {
            companyCode = positionBO.getPosition(req.getPositionCode())
                .getCompanyCode();
        } else if (ECbIntentionType.TALK.getCode().equals(req.getType())) {
            serveCode = req.getServiceCode();
            if (serveCode.startsWith(EGeneratePrefix.PHOTO.getCode())) {
                companyCode = photoBO.getPhoto(serveCode).getCompanyCode();
            } else if (serveCode.startsWith(EGeneratePrefix.TRAIN.getCode())) {
                companyCode = trainBO.getTrain(serveCode).getCompanyCode();
            } else if (serveCode.startsWith(EGeneratePrefix.OPERATE.getCode())) {
                companyCode = operateBO.getOperate(serveCode).getCompanyCode();
            } else {
                companyCode = serveBO.getServe(serveCode).getCompanyCode();
            }
        }
        CbIntention data = new CbIntention();
        String code = OrderNoGenerater
            .generateM(EGeneratePrefix.CBYX.getCode());
        data.setCode(code);
        data.setType(req.getType());
        data.setIntName(req.getIntName());
        data.setIntMobile(req.getIntMobile());
        data.setCompanyCode(companyCode);

        data.setServiceCode(serveCode);
        data.setPositionCode(req.getPositionCode());
        data.setResumeCode(req.getResumeCode());
        data.setHzContent(req.getHzContent());
        data.setStatus(ECbIntentionStatus.APPLY.getCode());
        data.setSubmitter(req.getSubmitter());
        data.setSubmitDatetime(new Date());
        cbIntentionBO.saveCbIntention(data);
        Company company = companyBO.getCompany(companyCode);
        User user = userBO.getRemoteUser(req.getSubmitter());
        String smsContent = "用户<" + user.getNickname() + ">提交了意向,请及时处理。";
        smsOutBO.sentContent(company.getUserId(), company.getUserId(),
            smsContent);
        return code;
    }

    @Override
    public void dealCbIntention(String code, String dealResult, String updater,
            String remark) {
        CbIntention cbIntention = cbIntentionBO.getCbIntention(code);
        if (ECbIntentionType.TALK.getCode().equals(cbIntention.getType())) {
            if (!ECbIntentionStatus.APPLY.getCode().equals(
                cbIntention.getStatus())) {
                throw new BizException("xn0000", "您已经处理过该意向");
            }
        }
        ECbIntentionStatus status = ECbIntentionStatus.PASS_YES;
        if (EBoolean.NO.getCode().equals(dealResult)) {
            status = ECbIntentionStatus.PASS_NO;
        }
        cbIntentionBO.refreshCbIntention(cbIntention, status, updater, remark);
    }

    @Override
    public Paginable<CbIntention> queryCbIntentionPage(int start, int limit,
            CbIntention condition) {
        Paginable<CbIntention> page = cbIntentionBO.getPaginable(start, limit,
            condition);
        List<CbIntention> cbIntentionList = page.getList();
        for (CbIntention cbIntention : cbIntentionList) {
            if (StringUtils.isNotBlank(cbIntention.getCompanyCode())) {
                Company company = companyBO.getCompany(cbIntention
                    .getCompanyCode());
                cbIntention.setCompany(company);
            }
        }
        return page;
    }

    @Override
    public XN612176Res getCbIntention(String code) {
        CbIntention cbIntention = cbIntentionBO.getCbIntention(code);
        XN612176Res res = new XN612176Res();
        res.setCbIntention(cbIntention);
        if (StringUtils.isNotBlank(cbIntention.getPositionCode())) {
            Position position = positionBO.getPosition(cbIntention
                .getPositionCode());
            res.setPosition(position);
        } else if (StringUtils.isNotBlank(cbIntention.getResumeCode())) {
            Resume resume = resumeBO.getResume(cbIntention.getResumeCode());
            res.setResume(resume);
        } else if (StringUtils.isNotBlank(cbIntention.getServiceCode())) {
            if (cbIntention.getServiceCode().startsWith(
                EGeneratePrefix.OPERATE.getCode())) {
                Operate operate = operateBO.getOperate(cbIntention
                    .getServiceCode());
                res.setOperate(operate);
            } else if (cbIntention.getServiceCode().startsWith(
                EGeneratePrefix.PHOTO.getCode())) {
                Photo photo = photoBO.getPhoto(cbIntention.getServiceCode());
                res.setPhoto(photo);
            } else if (cbIntention.getServiceCode().startsWith(
                EGeneratePrefix.TRAIN.getCode())) {
                Train train = trainBO.getTrain(cbIntention.getServiceCode());
                res.setTrain(train);
            } else {
                Serve serve = serveBO.getServe(cbIntention.getServiceCode());
                res.setServe(serve);
            }
        }
        return res;
    }
}
