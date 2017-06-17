package com.cdkj.service.ao.impl;

import java.util.Date;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdkj.service.ao.IPhotoAO;
import com.cdkj.service.bo.ICompanyBO;
import com.cdkj.service.bo.IGsQualifyBO;
import com.cdkj.service.bo.IPhotoBO;
import com.cdkj.service.bo.IQualifyBO;
import com.cdkj.service.bo.ISmsOutBO;
import com.cdkj.service.bo.IUserBO;
import com.cdkj.service.bo.base.Paginable;
import com.cdkj.service.core.EGeneratePrefix;
import com.cdkj.service.core.OrderNoGenerater;
import com.cdkj.service.core.StringValidater;
import com.cdkj.service.domain.Company;
import com.cdkj.service.domain.GsQualify;
import com.cdkj.service.domain.Photo;
import com.cdkj.service.domain.Qualify;
import com.cdkj.service.domain.User;
import com.cdkj.service.dto.req.XN612080Req;
import com.cdkj.service.dto.req.XN612082Req;
import com.cdkj.service.enums.EBoolean;
import com.cdkj.service.enums.ECompanyStatus;
import com.cdkj.service.exception.BizException;

@Service
public class PhotoAOImpl implements IPhotoAO {

    @Autowired
    private IPhotoBO photoBO;

    @Autowired
    private ISmsOutBO smsOutBO;

    @Autowired
    private IGsQualifyBO gsQualifyBO;

    @Autowired
    private ICompanyBO companyBO;

    @Autowired
    private IUserBO userBO;

    @Autowired
    private IQualifyBO qualifyBO;

    @Override
    public String addPhoto(XN612080Req req) {
        String code = null;
        GsQualify gsQualify = gsQualifyBO.queryGsQualifyList(req
            .getCompanyCode());
        if (null != gsQualify
                && ECompanyStatus.PASS_YES.getCode().equals(
                    gsQualify.getStatus())) {
            Photo data = new Photo();
            code = OrderNoGenerater.generateM(EGeneratePrefix.PHOTO.getCode());
            data.setCode(code);
            data.setName(req.getName());
            data.setPic(req.getPic());
            data.setAdvPic(req.getAdvPic());
            data.setCompanyCode(req.getCompanyCode());

            data.setQuoteMin(StringValidater.toLong(req.getQuoteMin()));
            data.setQuoteMax(StringValidater.toLong(req.getQuoteMax()));
            data.setPyNum(StringValidater.toInteger(req.getPyNum()));
            data.setSysNum(StringValidater.toInteger(req.getSysNum()));
            data.setIsDz(req.getIsDz());

            data.setLocation(EBoolean.NO.getCode());
            data.setOrderNo(EBoolean.NO.getCode());
            data.setScpslm(req.getScpslm());
            data.setWorks(req.getWorks());
            data.setDescription(req.getDescription());

            data.setStatus(EBoolean.YES.getCode());
            data.setPublisher(req.getPublisher());
            data.setPublishDatetime(new Date());
            data.setQualifyCode(gsQualify.getQualifyCode());
            photoBO.savePhoto(data);
        } else {
            throw new BizException("xn0000", "公司还未获得该资质");
        }
        return code;
    }

    @Override
    public void editPhoto(XN612082Req req) {
        Photo data = photoBO.getPhoto(req.getCode());
        data.setCode(req.getCode());
        data.setName(req.getName());
        data.setPic(req.getPic());
        data.setAdvPic(req.getAdvPic());
        data.setQuoteMin(StringValidater.toLong(req.getQuoteMin()));

        data.setQuoteMax(StringValidater.toLong(req.getQuoteMax()));
        data.setPyNum(StringValidater.toInteger(req.getPyNum()));
        data.setSysNum(StringValidater.toInteger(req.getSysNum()));
        data.setIsDz(req.getIsDz());
        data.setLocation(EBoolean.NO.getCode());

        data.setOrderNo(EBoolean.NO.getCode());
        data.setScpslm(req.getScpslm());
        data.setWorks(req.getWorks());
        data.setDescription(req.getDescription());
        data.setPublisher(req.getPublisher());

        data.setPublishDatetime(new Date());
        photoBO.refreshPhoto(data);
    }

    @Override
    public void dropPhoto(String code) {
        if (!photoBO.isPhotoExist(code)) {
            throw new BizException("xn0000", "记录编号不存在");
        }
        photoBO.removePhoto(code);
    }

    @Override
    public Paginable<Photo> queryPhotoPage(int start, int limit, Photo condition) {
        Paginable<Photo> page = photoBO.getPaginable(start, limit, condition);
        List<Photo> list = page.getList();
        if (CollectionUtils.isNotEmpty(list)) {
            for (Photo photo : list) {
                Company company = companyBO.getCompany(photo.getCompanyCode());
                User user = userBO.getRemoteUser(company.getUserId());
                company.setRealName(user.getNickname());
                Qualify qualify = qualifyBO.getQualify(photo.getQualifyCode());
                photo.setQualityName(qualify.getName());
                photo.setCompany(company);
            }
        }
        return page;
    }

    @Override
    public List<Photo> queryPhotoList(Photo condition) {
        return photoBO.queryPhotoList(condition);
    }

    @Override
    public Photo getPhoto(String code) {
        return photoBO.getPhoto(code);
    }

    @Override
    public void wgclPhoto(String code, String dealer, String dealNote) {
        Photo photo = photoBO.getPhoto(code);
        if (EBoolean.NO.getCode().equals(photo.getStatus())) {
            throw new BizException("xn0000", "该服务已做违规处理");
        }
        String publisher = photo.getPublisher();
        smsOutBO.sentContent(publisher, publisher,
            "尊敬的企业，您所发布的拍摄服务[" + photo.getName() + "]已做违规处理，违规原因[" + dealNote
                    + "]。");
        photoBO.wgclPhoto(photo, dealer, dealNote);
    }

    @Override
    public void editLocation(String code, String location, String orderNo,
            String dealer) {
        Photo photo = photoBO.getPhoto(code);
        if (EBoolean.NO.getCode().equals(photo.getStatus())) {
            throw new BizException("xn0000", "服务已违规,不可设置为热门");
        }
        if (!EBoolean.NO.getCode().equals(orderNo)) {
            List<Photo> photoList = photoBO.queryPhotoList(
                EBoolean.YES.getCode(), location, orderNo);
            if (CollectionUtils.isNotEmpty(photoList)) {
                throw new BizException("xn0000", "顺序重复");
            }
        }
        photoBO.refreshLocation(photo, location, orderNo, dealer);
    }
}
