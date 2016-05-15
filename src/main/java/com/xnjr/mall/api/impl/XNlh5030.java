package com.xnjr.mall.api.impl;

import com.xnjr.mall.ao.ISYSConfigAO;
import com.xnjr.mall.api.AProcessor;
import com.xnjr.mall.common.JsonUtil;
import com.xnjr.mall.core.StringValidater;
import com.xnjr.mall.domain.SYSConfig;
import com.xnjr.mall.dto.req.XNlh5030Req;
import com.xnjr.mall.dto.res.XNlh5030Res;
import com.xnjr.mall.exception.BizException;
import com.xnjr.mall.exception.ParaException;
import com.xnjr.mall.spring.SpringContextHolder;

/**
 * 新增系统参数
 * @author: Gejin 
 * @since: 2016年4月17日 下午8:02:42 
 * @history:
 */
public class XNlh5030 extends AProcessor {

    private ISYSConfigAO sysConfigAO = SpringContextHolder
        .getBean(ISYSConfigAO.class);

    private XNlh5030Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        SYSConfig data = new SYSConfig();
        data.setToSystem("8");// 8 代表生意家 作为服务时启用该字段
        data.setCkey(req.getCkey());
        data.setCvalue(req.getCvalue());
        data.setNote(req.getNote());
        data.setUpdater(req.getUpdater());
        data.setRemark(req.getRemark());
        return new XNlh5030Res(sysConfigAO.addSYSConfig(data));
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XNlh5030Req.class);
        StringValidater.validateBlank(req.getCkey(), req.getCvalue(),
            req.getNote(), req.getUpdater());

    }

}
