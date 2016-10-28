package com.cdkj.service.ao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cdkj.service.ao.IServeAO;
import com.cdkj.service.bo.ICompanyBO;
import com.cdkj.service.bo.IServeArtBO;
import com.cdkj.service.bo.IServeBO;
import com.cdkj.service.bo.IServeCpBO;
import com.cdkj.service.bo.IServeCyyBO;
import com.cdkj.service.bo.IServeKfwbBO;
import com.cdkj.service.bo.IServePhotoBO;
import com.cdkj.service.bo.IServeShopBO;
import com.cdkj.service.bo.IServeTrainBO;
import com.cdkj.service.bo.base.Paginable;
import com.cdkj.service.domain.Serve;
import com.cdkj.service.domain.ServeArt;
import com.cdkj.service.domain.ServeCp;
import com.cdkj.service.domain.ServeCyy;
import com.cdkj.service.domain.ServeKfwb;
import com.cdkj.service.domain.ServePhoto;
import com.cdkj.service.domain.ServeShop;
import com.cdkj.service.domain.ServeTrain;
import com.cdkj.service.dto.res.XN806010Res;
import com.cdkj.service.enums.EBoolean;
import com.cdkj.service.exception.BizException;

@Service
public class ServeAOImpl implements IServeAO {

    @Autowired
    private IServeBO serveBO;

    @Autowired
    private IServeArtBO serveArtBO;

    @Autowired
    private IServeCpBO serveCpBO;

    @Autowired
    private IServeCyyBO serveCyyBO;

    @Autowired
    private IServeKfwbBO serveKfwbBO;

    @Autowired
    private IServePhotoBO servePhotoBO;

    @Autowired
    private IServeShopBO serveShopBO;

    @Autowired
    private IServeTrainBO serveTrainBO;

    @Autowired
    private ICompanyBO companyBO;

    @Override
    public String addServe(Serve data) {
        return serveBO.saveServe(data);
    }

    @Override
    public int editServe(Serve data) {
        if (!serveBO.isServeExist(data.getCode())) {
            throw new BizException("xn0000", "该编号不存在");
        }
        return serveBO.refreshServe(data);
    }

    @Transactional
    @Override
    public int dropServe(String code) {
        int count = 0;
        if (!serveBO.isServeExist(code)) {
            throw new BizException("xn0000", "该编号不存在");
        }
        count = serveBO.removeServe(code);
        // 扫描各子表，若存在该服务则删除
        if (serveArtBO.isServeArtExist(code)) {
            serveArtBO.removeServeArt(code);
        } else if (serveCpBO.isServeCpExist(code)) {
            serveCpBO.removeServeCp(code);
        } else if (serveCyyBO.isServeCyyExist(code)) {
            serveCyyBO.removeServeCyy(code);
        } else if (serveKfwbBO.isServeKfwbExist(code)) {
            serveKfwbBO.removeServeKfwb(code);
        } else if (servePhotoBO.isServePhotoExist(code)) {
            servePhotoBO.removeServePhoto(code);
        } else if (serveShopBO.isServeShopExist(code)) {
            serveShopBO.removeServeShop(code);
        } else if (serveTrainBO.isServeTrainExist(code)) {
            serveTrainBO.removeServeTrain(code);
        }
        return count;
    }

    @Override
    public Paginable<Serve> queryServePage(int start, int limit, Serve condition) {
        Paginable<Serve> page = serveBO.getPaginable(start, limit, condition);
        List<Serve> list = page.getList();
        // 添加公司信息
        if (null != condition.getCompanyCode()) {
            for (Serve serve : list) {
                XN806010Res res = companyBO.getCompany(serve.getCompanyCode());
                serve.setCompany(res);
            }
        }
        // 添加服务详情信息
        if (null != condition.getType()) {
            addServeExt(condition);
        }
        return page;
    }

    // 添加服务详情信息
    private void addServeExt(Serve data) {
        switch (data.getType()) {
            case "1":
                break;
            case "2":
                ServePhoto servePhoto = servePhotoBO.getServePhoto(data
                    .getCode());
                data.setServePhoto(servePhoto);
                break;
            case "3":
                ServeTrain serveTrain = serveTrainBO.getServeTrain(data
                    .getCode());
                data.setServeTrain(serveTrain);
                break;
            case "4":
                ServeShop serveShop = serveShopBO.getServeShop(data.getCode());
                data.setServeShop(serveShop);
                break;
            case "5":
                ServeArt serveArt = serveArtBO.getServeArt(data.getCode());
                data.setServeArt(serveArt);
                break;
            case "6":
                ServeKfwb serveKfwb = serveKfwbBO.getServeKfwb(data.getCode());
                data.setServeKfwb(serveKfwb);
                break;
            case "7":
                ServeCp serveCp = serveCpBO.getServeCp(data.getCode());
                data.setServeCp(serveCp);
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
        return serveBO.getServe(code);
    }

    @Override
    public int editServeStatus(String code, String dealNote, String dealer) {
        Serve data = new Serve();
        data.setStatus(EBoolean.NO.getCode());
        data.setCode(code);
        data.setDealNote(dealNote);
        data.setDealer(dealer);
        return serveBO.refreshServeStatus(data);
    }

    @Override
    public int editServeHot(String code, String isHot, String orderNo,
            String dealer) {
        Serve data = new Serve();
        data.setCode(code);
        data.setIsHot(isHot);
        data.setOrderNo(Integer.valueOf(orderNo));
        data.setDealer(dealer);
        return serveBO.refreshServeHot(data);
    }

    @Override
    public int editServeHotLocation(String code, String action) {
        Serve data = serveBO.getServe(code);
        Integer location = data.getOrderNo();
        if (null == location) {
            location = 2;
        }
        if (EBoolean.YES.getCode().equalsIgnoreCase(action)) {
            if (location > 0) {
                location--;
            } else {
                throw new BizException("xn0000", "次序不可小于零");
            }
        } else {
            location++;
        }
        data.setOrderNo(location);
        return serveBO.refreshServeHot(data);
    }
}
