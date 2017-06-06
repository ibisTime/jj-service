package com.cdkj.service.api.converter;

import com.cdkj.service.common.DateUtil;
import com.cdkj.service.core.StringValidater;
import com.cdkj.service.domain.Serve;
import com.cdkj.service.domain.ServeArt;
import com.cdkj.service.domain.ServeCp;
import com.cdkj.service.domain.ServeCyy;
import com.cdkj.service.domain.ServeKfwb;
import com.cdkj.service.domain.ServePhoto;
import com.cdkj.service.domain.ServeShop;
import com.cdkj.service.domain.ServeTrain;
import com.cdkj.service.dto.req.XN612080Req;
import com.cdkj.service.dto.req.XN612082Req;
import com.cdkj.service.dto.req.XN612090Req;
import com.cdkj.service.dto.req.XN612092Req;
import com.cdkj.service.dto.req.XN612110Req;
import com.cdkj.service.dto.req.XN612112Req;
import com.cdkj.service.dto.req.XN612120Req;
import com.cdkj.service.dto.req.XN612121Req;
import com.cdkj.service.dto.req.XN612122Req;
import com.cdkj.service.dto.req.XN612123Req;
import com.cdkj.service.dto.req.XN612124Req;
import com.cdkj.service.dto.req.XN612125Req;
import com.cdkj.service.dto.req.XN612126Req;
import com.cdkj.service.dto.req.XN612127Req;
import com.cdkj.service.dto.req.XN612128Req;
import com.cdkj.service.dto.req.XN612129Req;
import com.cdkj.service.dto.req.XN612140Req;

public class ServeConverter {

    // 新增摄影/拍摄服务
    public static ServePhoto converter(XN612080Req req) {
        ServePhoto result = new ServePhoto();
        Serve serve = new Serve();
        serve.setName(req.getName());
        serve.setCompanyCode(req.getCompanyCode());
        serve.setQuoteMin(StringValidater.toLong(req.getQuoteMin()));
        serve.setQuoteMax(StringValidater.toLong(req.getQuoteMax()));
        serve.setQualityCode(req.getQualityCode());
        result.setPyNum(StringValidater.toInteger(req.getPyNum()));
        result.setSysNum(StringValidater.toInteger(req.getSysNum()));
        result.setIsDz(req.getIsDz());
        result.setScpslm(req.getScpslm());
        result.setWorks(req.getWorks());
        serve.setDescription(req.getDescription());
        serve.setPublisher(req.getPublisher());
        result.setServe(serve);
        return result;
    }

    // 修改摄影/拍摄服务
    public static ServePhoto converter(XN612082Req req) {
        ServePhoto result = new ServePhoto();
        Serve serve = new Serve();
        serve.setCode(req.getCode());
        serve.setName(req.getName());
        serve.setQuoteMin(StringValidater.toLong(req.getQuoteMin()));
        serve.setQuoteMax(StringValidater.toLong(req.getQuoteMax()));
        result.setServeCode(req.getCode());
        result.setPyNum(StringValidater.toInteger(req.getPyNum()));
        result.setSysNum(StringValidater.toInteger(req.getSysNum()));
        result.setIsDz(req.getIsDz());
        result.setScpslm(req.getScpslm());
        result.setWorks(req.getWorks());
        serve.setDescription(req.getDescription());
        serve.setPublisher(req.getPublisher());
        result.setServe(serve);
        return result;
    }

    // 新增培训
    public static ServeTrain converter(XN612090Req req) {
        ServeTrain result = new ServeTrain();
        Serve serve = new Serve();
        serve.setName(req.getName());
        serve.setCompanyCode(req.getCompanyCode());
        serve.setQuoteMin(StringValidater.toLong(req.getQuoteMin()));
        serve.setQuoteMax(StringValidater.toLong(req.getQuoteMax()));
        serve.setQualityCode(req.getQualityCode());
        result.setLectorNum(StringValidater.toInteger(req.getLectorNum()));
        result.setMtrainTimes(StringValidater.toInteger(req.getMtrainTimes()));
        result.setMtrainNum(StringValidater.toInteger(req.getMtrainNum()));
        result.setResume1(req.getResume1());
        result.setResume2(req.getResume2());
        result.setResume3(req.getResume3());
        result.setCourse(req.getCourse());
        serve.setDescription(req.getDescription());
        serve.setPublisher(req.getPublisher());
        result.setServe(serve);
        return result;
    }

    // 修改培训
    public static ServeTrain converter(XN612092Req req) {
        ServeTrain result = new ServeTrain();
        Serve serve = new Serve();
        serve.setCode(req.getCode());
        serve.setName(req.getName());
        serve.setQuoteMin(StringValidater.toLong(req.getQuoteMin()));
        serve.setQuoteMax(StringValidater.toLong(req.getQuoteMax()));
        result.setServeCode(req.getCode());
        result.setLectorNum(StringValidater.toInteger(req.getLectorNum()));
        result.setMtrainTimes(StringValidater.toInteger(req.getMtrainTimes()));
        result.setMtrainNum(StringValidater.toInteger(req.getMtrainNum()));
        result.setResume1(req.getResume1());
        result.setResume2(req.getResume2());
        result.setResume3(req.getResume3());
        result.setCourse(req.getCourse());
        serve.setDescription(req.getDescription());
        serve.setPublisher(req.getPublisher());
        result.setServe(serve);
        return result;
    }

    // 新增店铺代运营
    public static ServeShop converter(XN612110Req req) {
        ServeShop result = new ServeShop();
        Serve serve = new Serve();
        serve.setName(req.getName());
        serve.setCompanyCode(req.getCompanyCode());
        serve.setQuoteMin(StringValidater.toLong(req.getQuoteMin()));
        serve.setQuoteMax(StringValidater.toLong(req.getQuoteMax()));
        serve.setQualityCode(req.getQualityCode());
        result.setTgfw(req.getTgfw());
        result.setFeeMode(req.getFeeMode());
        result.setPayCycle(req.getPayCycle());
        result.setScyylm(req.getScyylm());
        result.setSucCase(req.getSucCase());
        serve.setDescription(req.getDescription());
        serve.setPublisher(req.getPublisher());
        result.setServe(serve);
        return result;
    }

    // 修改店铺代运营
    public static ServeShop converter(XN612112Req req) {
        ServeShop result = new ServeShop();
        Serve serve = new Serve();
        serve.setCode(req.getCode());
        serve.setName(req.getName());
        serve.setQuoteMin(StringValidater.toLong(req.getQuoteMin()));
        serve.setQuoteMax(StringValidater.toLong(req.getQuoteMax()));
        result.setServeCode(req.getCode());
        result.setTgfw(req.getTgfw());
        result.setFeeMode(req.getFeeMode());
        result.setPayCycle(req.getPayCycle());
        result.setScyylm(req.getScyylm());
        result.setSucCase(req.getSucCase());
        serve.setDescription(req.getDescription());
        serve.setPublisher(req.getPublisher());
        result.setServe(serve);
        return result;
    }

    // 新增美工外包
    public static ServeArt converter(XN612120Req req) {
        ServeArt result = new ServeArt();
        Serve serve = new Serve();
        serve.setName(req.getName());
        serve.setCompanyCode(req.getCompanyCode());
        serve.setQuoteMin(StringValidater.toLong(req.getQuoteMin()));
        serve.setQuoteMax(StringValidater.toLong(req.getQuoteMax()));
        serve.setQualityCode(req.getQualityCode());
        result.setDesignNum(StringValidater.toInteger(req.getDesignNum()));
        result.setSclm(req.getSclm());
        result.setHomeDays(StringValidater.toInteger(req.getHomeDays()));
        result.setHomePrice(StringValidater.toLong(req.getHomePrice()));
        result.setDetailDays(StringValidater.toInteger(req.getDetailDays()));
        result.setDetailPrice(StringValidater.toLong(req.getDetailPrice()));
        result.setBannerDays(StringValidater.toInteger(req.getBannerDays()));
        result.setBannerPrice(StringValidater.toLong(req.getBannerPrice()));
        result.setAllDays(StringValidater.toInteger(req.getAllDays()));
        result.setAllPrice(StringValidater.toLong(req.getAllPrice()));
        result.setWorks(req.getWorks());
        serve.setDescription(req.getDescription());
        serve.setPublisher(req.getPublisher());
        result.setServe(serve);
        return result;
    }

    // 修改美工外包
    public static ServeArt converter(XN612121Req req) {
        ServeArt result = new ServeArt();
        Serve serve = new Serve();
        serve.setCode(req.getCode());
        serve.setName(req.getName());
        serve.setQuoteMin(StringValidater.toLong(req.getQuoteMin()));
        serve.setQuoteMax(StringValidater.toLong(req.getQuoteMax()));
        result.setServeCode(req.getCode());
        result.setDesignNum(StringValidater.toInteger(req.getDesignNum()));
        result.setSclm(req.getSclm());
        result.setHomeDays(StringValidater.toInteger(req.getHomeDays()));
        result.setHomePrice(StringValidater.toLong(req.getHomePrice()));
        result.setDetailDays(StringValidater.toInteger(req.getDetailDays()));
        result.setDetailPrice(StringValidater.toLong(req.getDetailPrice()));
        result.setBannerDays(StringValidater.toInteger(req.getBannerDays()));
        result.setBannerPrice(StringValidater.toLong(req.getBannerPrice()));
        result.setAllDays(StringValidater.toInteger(req.getAllDays()));
        result.setAllPrice(StringValidater.toLong(req.getAllPrice()));
        result.setWorks(req.getWorks());
        serve.setDescription(req.getDescription());
        serve.setPublisher(req.getPublisher());
        result.setServe(serve);
        return result;
    }

    // 新增客服外包
    public static ServeKfwb converter(XN612122Req req) {
        ServeKfwb result = new ServeKfwb();
        Serve serve = new Serve();
        serve.setName(req.getName());
        serve.setCompanyCode(req.getCompanyCode());
        serve.setQuoteMin(StringValidater.toLong(req.getQuoteMin()));
        serve.setQuoteMax(StringValidater.toLong(req.getQuoteMax()));
        serve.setQualityCode(req.getQualityCode());
        result.setKfNum(StringValidater.toInteger(req.getKfNum()));
        result.setMtradeAmount(req.getMtradeAmount());
        result.setBusiness(req.getBusiness());
        result.setFeeMode(req.getFeeMode());
        serve.setDescription(req.getDescription());
        serve.setPublisher(req.getPublisher());
        result.setServe(serve);
        return result;
    }

    // 修改客服外包
    public static ServeKfwb converter(XN612123Req req) {
        ServeKfwb result = new ServeKfwb();
        Serve serve = new Serve();
        serve.setCode(req.getCode());
        serve.setName(req.getName());
        serve.setQuoteMin(StringValidater.toLong(req.getQuoteMin()));
        serve.setQuoteMax(StringValidater.toLong(req.getQuoteMax()));
        result.setServeCode(req.getCode());
        result.setKfNum(StringValidater.toInteger(req.getKfNum()));
        result.setMtradeAmount(req.getMtradeAmount());
        result.setBusiness(req.getBusiness());
        result.setFeeMode(req.getFeeMode());
        serve.setDescription(req.getDescription());
        serve.setPublisher(req.getPublisher());
        result.setServe(serve);
        return result;
    }

    // 新增仓配服务
    public static ServeCp converter(XN612124Req req) {
        ServeCp result = new ServeCp();
        Serve serve = new Serve();
        serve.setName(req.getName());
        serve.setCompanyCode(req.getCompanyCode());
        serve.setQuoteMin(StringValidater.toLong(req.getQuoteMin()));
        serve.setQuoteMax(StringValidater.toLong(req.getQuoteMax()));
        serve.setQualityCode(req.getQualityCode());
        result.setCkNum(StringValidater.toInteger(req.getCkNum()));
        result.setCkArea(req.getCkArea());
        result.setGoodsKind(req.getGoodsKind());
        result.setDsendNum(StringValidater.toInteger(req.getDsendNum()));
        serve.setDescription(req.getDescription());
        serve.setPublisher(req.getPublisher());
        result.setServe(serve);
        return result;
    }

    // 修改仓配服务
    public static ServeCp converter(XN612125Req req) {
        ServeCp result = new ServeCp();
        Serve serve = new Serve();
        serve.setCode(req.getCode());
        serve.setName(req.getName());
        serve.setQuoteMin(StringValidater.toLong(req.getQuoteMin()));
        serve.setQuoteMax(StringValidater.toLong(req.getQuoteMax()));
        result.setServeCode(req.getCode());
        result.setCkNum(StringValidater.toInteger(req.getCkNum()));
        result.setCkArea(req.getCkArea());
        result.setGoodsKind(req.getGoodsKind());
        result.setDsendNum(StringValidater.toInteger(req.getDsendNum()));
        serve.setDescription(req.getDescription());
        serve.setPublisher(req.getPublisher());
        result.setServe(serve);
        return result;
    }

    // 新增软件外包
    public static Serve converter(XN612126Req req) {
        Serve serve = new Serve();
        serve.setName(req.getName());
        serve.setCompanyCode(req.getCompanyCode());
        serve.setQuoteMin(StringValidater.toLong(req.getQuoteMin()));
        serve.setQuoteMax(StringValidater.toLong(req.getQuoteMax()));
        serve.setQualityCode(req.getQualityCode());
        serve.setDescription(req.getDescription());
        serve.setPublisher(req.getPublisher());
        return serve;
    }

    // 修改软件外包
    public static Serve converter(XN612127Req req) {
        Serve serve = new Serve();
        serve.setCode(req.getCode());
        serve.setName(req.getName());
        serve.setQuoteMin(StringValidater.toLong(req.getQuoteMin()));
        serve.setQuoteMax(StringValidater.toLong(req.getQuoteMax()));
        serve.setDescription(req.getDescription());
        serve.setPublisher(req.getPublisher());
        return serve;
    }

    // 新增产业园
    public static ServeCyy converter(XN612128Req req) {
        ServeCyy result = new ServeCyy();
        Serve serve = new Serve();
        serve.setName(req.getName());
        serve.setCompanyCode(req.getCompanyCode());
        serve.setQuoteMin(StringValidater.toLong(req.getQuoteMin()));
        serve.setQuoteMax(StringValidater.toLong(req.getQuoteMax()));
        serve.setQualityCode(req.getQualityCode());
        result.setBgArea(StringValidater.toLong(req.getBgArea()));
        result.setAvailBgArea(StringValidater.toLong(req.getAvailBgArea()));
        result.setCcArea(StringValidater.toLong(req.getCcArea()));
        result.setAvailCcArea(StringValidater.toLong(req.getAvailCcArea()));
        result.setZzfw(req.getZzfw());
        result.setIntroduce(req.getIntroduce());
        result.setYhPolicy(req.getYhPolicy());
        result.setPic1(req.getPic1());
        result.setPic2(req.getPic2());
        serve.setDescription(req.getDescription());
        serve.setPublisher(req.getPublisher());
        result.setServe(serve);
        return result;
    }

    // 修改产业园
    public static ServeCyy converter(XN612129Req req) {
        ServeCyy result = new ServeCyy();
        Serve serve = new Serve();
        serve.setCode(req.getCode());
        serve.setName(req.getName());
        serve.setQuoteMin(StringValidater.toLong(req.getQuoteMin()));
        serve.setQuoteMax(StringValidater.toLong(req.getQuoteMax()));
        result.setServeCode(req.getCode());
        result.setBgArea(StringValidater.toLong(req.getBgArea()));
        result.setAvailBgArea(StringValidater.toLong(req.getAvailBgArea()));
        result.setCcArea(StringValidater.toLong(req.getCcArea()));
        result.setAvailCcArea(StringValidater.toLong(req.getAvailCcArea()));
        result.setZzfw(req.getZzfw());
        result.setIntroduce(req.getIntroduce());
        result.setYhPolicy(req.getYhPolicy());
        result.setPic1(req.getPic1());
        result.setPic2(req.getPic2());
        serve.setDescription(req.getDescription());
        serve.setPublisher(req.getPublisher());
        result.setServe(serve);
        return result;
    }

    // 分页查询服务
    public static Serve converter(XN612140Req req) {
        Serve serve = new Serve();
        serve.setName(req.getName());
        serve.setCompanyCode(req.getCompanyCode());
        serve.setCompanyName(req.getCompanyName());
        serve.setStatus(req.getStatus());
        serve.setQualityCode(req.getQualityCode());
        serve.setIsHot(req.getIsHot());
        serve.setPublisher(req.getPublisher());
        serve.setProvince(req.getProvince());
        serve.setCity(req.getCity());
        serve.setArea(req.getArea());
        serve.setPublishDatetimeStart(DateUtil.strToDate(req.getDateStart(),
            DateUtil.DATA_TIME_PATTERN_1));
        serve.setPublishDatetimeEnd(DateUtil.strToDate(req.getDateEnd(),
            DateUtil.DATA_TIME_PATTERN_1));
        serve.setDealer(req.getDealer());
        return serve;
    }
}
