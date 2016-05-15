package com.xnjr.mall.api.impl;

import com.xnjr.mall.ao.ISYSConfigAO;
import com.xnjr.mall.api.AProcessor;
import com.xnjr.mall.common.JsonUtil;
import com.xnjr.mall.core.StringValidater;
import com.xnjr.mall.domain.SYSConfig;
import com.xnjr.mall.dto.req.XNlh5031Req;
import com.xnjr.mall.dto.res.XNlh5031Res;
import com.xnjr.mall.exception.BizException;
import com.xnjr.mall.exception.ParaException;
import com.xnjr.mall.spring.SpringContextHolder;

/**
 * 修改系统参数
 * @author: Gejin 
 * @since: 2016年4月17日 下午8:17:35 
 * @history:
 */
public class XNlh5031 extends AProcessor {
    private ISYSConfigAO sysConfigAO = SpringContextHolder
        .getBean(ISYSConfigAO.class);

    private XNlh5031Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        SYSConfig data = new SYSConfig();
        data.setId(req.getId());
        data.setCvalue(req.getCvalue());
        data.setNote(req.getNote());
        data.setUpdater(req.getUpdater());
        data.setRemark(req.getRemark());
        sysConfigAO.editSYSConfig(data);
        return new XNlh5031Res(true);
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XNlh5031Req.class);
        StringValidater.validateBlank(req.getCvalue(), req.getNote(),
            req.getUpdater());

    }

}
