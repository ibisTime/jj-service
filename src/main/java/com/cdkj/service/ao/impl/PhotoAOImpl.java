package com.cdkj.service.ao.impl;

import java.util.Date;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdkj.service.ao.IPhotoAO;
import com.cdkj.service.bo.IPhotoBO;
import com.cdkj.service.bo.base.Paginable;
import com.cdkj.service.core.EGeneratePrefix;
import com.cdkj.service.core.OrderNoGenerater;
import com.cdkj.service.core.StringValidater;
import com.cdkj.service.domain.Photo;
import com.cdkj.service.dto.req.XN612080Req;
import com.cdkj.service.dto.req.XN612082Req;
import com.cdkj.service.enums.EBoolean;
import com.cdkj.service.exception.BizException;

@Service
public class PhotoAOImpl implements IPhotoAO {

    @Autowired
    private IPhotoBO photoBO;

    @Override
    public String addPhoto(XN612080Req req) {
        Photo data = new Photo();
        String code = OrderNoGenerater.generateM(EGeneratePrefix.PHOTO
            .getCode());
        data.setCode(code);
        data.setName(req.getName());
        data.setPic(req.getPic());
        data.setAdvPic(req.getAdvPic());
        data.setCompanyCode(req.getCompanyCode());

        data.setQuoteMin(StringValidater.toLong(req.getQuoteMin()));
        data.setQuoteMax(StringValidater.toLong(req.getQuoteMax()));
        data.setQualityCode(req.getQualityCode());
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
        photoBO.savePhoto(data);
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
        return photoBO.getPaginable(start, limit, condition);
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
        photoBO.wgclPhoto(photo, dealer, dealNote);
    }

    @Override
    public void editLocation(String code, String location, String orderNo,
            String dealer) {
        Photo photo = photoBO.getPhoto(code);
        if (!EBoolean.NO.getCode().equals(orderNo)) {
            List<Photo> photoList = photoBO.queryPhotoList(location, orderNo);
            if (CollectionUtils.isNotEmpty(photoList)) {
                throw new BizException("xn0000", "顺序重复");
            }
        }
        photoBO.refreshLocation(photo, location, orderNo, dealer);
    }
}
