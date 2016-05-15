package com.xnjr.mall.api.impl;

import com.xnjr.mall.ao.IGSTraderAO;
import com.xnjr.mall.api.AProcessor;
import com.xnjr.mall.common.JsonUtil;
import com.xnjr.mall.core.StringValidater;
import com.xnjr.mall.domain.GSTrader;
import com.xnjr.mall.dto.req.XNgs0000Req;
import com.xnjr.mall.dto.res.XNgs0000Res;
import com.xnjr.mall.exception.BizException;
import com.xnjr.mall.exception.ParaException;
import com.xnjr.mall.spring.SpringContextHolder;

/**
 * 操盘手-增加
 * @author: myb858 
 * @since: 2016年1月13日 下午1:25:21 
 * @history:
 */
public class XNgs0000 extends AProcessor {
    private IGSTraderAO gsTraderAO = SpringContextHolder
        .getBean(IGSTraderAO.class);

    XNgs0000Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        GSTrader data = new GSTrader();
        data.setUserId(req.getUserId());
        data.setMobile(req.getMobile());
        data.setPhoto(req.getPhoto());
        data.setIntroduction(req.getIntroduction());
        data.setLevel(req.getLevel());
        data.setUpdater(req.getUpdater());
        data.setRemark(req.getRemark());
        return new XNgs0000Res(gsTraderAO.addGSTrader(data));
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XNgs0000Req.class);
        StringValidater.validateBlank(req.getUserId(), req.getMobile(),
            req.getPhoto(), req.getIntroduction(), req.getLevel(),
            req.getUpdater());
    }
}
