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
import com.cdkj.service.dto.req.CD612000Req;
import com.cdkj.service.dto.req.CD612001Req;
import com.cdkj.service.dto.req.CD612002Req;
import com.cdkj.service.dto.req.CD612003Req;
import com.cdkj.service.dto.req.CD612004Req;
import com.cdkj.service.dto.req.CD612005Req;
import com.cdkj.service.dto.req.CD612006Req;
import com.cdkj.service.dto.req.CD612007Req;
import com.cdkj.service.dto.req.CD612008Req;
import com.cdkj.service.dto.req.CD612009Req;
import com.cdkj.service.dto.req.CD612010Req;
import com.cdkj.service.dto.req.CD612011Req;
import com.cdkj.service.dto.req.CD612012Req;
import com.cdkj.service.dto.req.CD612013Req;
import com.cdkj.service.dto.req.CD612014Req;
import com.cdkj.service.dto.req.CD612015Req;
import com.cdkj.service.dto.req.CD612030Req;

public class ServeConverter {

    // 新增摄影/拍摄服务
    public static ServePhoto converter(CD612000Req req) {
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
    public static ServePhoto converter(CD612001Req req) {
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
    public static ServeTrain converter(CD612002Req req) {
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
    public static ServeTrain converter(CD612003Req req) {
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
    public static ServeShop converter(CD612004Req req) {
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
    public static ServeShop converter(CD612005Req req) {
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
    public static ServeArt converter(CD612006Req req) {
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
    public static ServeArt converter(CD612007Req req) {
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
    public static ServeKfwb converter(CD612008Req req) {
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
    public static ServeKfwb converter(CD612009Req req) {
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
    public static ServeCp converter(CD612010Req req) {
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
    public static ServeCp converter(CD612011Req req) {
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
    public static Serve converter(CD612012Req req) {
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
    public static Serve converter(CD612013Req req) {
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
    public static ServeCyy converter(CD612014Req req) {
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
    public static ServeCyy converter(CD612015Req req) {
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
    public static Serve converter(CD612030Req req) {
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
