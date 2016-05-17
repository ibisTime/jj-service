/**
 * @Title XN601000.java 
 * @Package com.xnjr.mall.api.impl 
 * @Description 
 * @author haiqingzheng  
 * @date 2016年5月17日 上午9:06:30 
 * @version V1.0   
 */
package com.xnjr.mall.api.impl;

import com.xnjr.mall.ao.IProductAO;
import com.xnjr.mall.api.AProcessor;
import com.xnjr.mall.common.JsonUtil;
import com.xnjr.mall.core.StringValidater;
import com.xnjr.mall.domain.Product;
import com.xnjr.mall.dto.req.XN601000Req;
import com.xnjr.mall.dto.res.PKCodeRes;
import com.xnjr.mall.exception.BizException;
import com.xnjr.mall.exception.ParaException;
import com.xnjr.mall.spring.SpringContextHolder;

/** 
 * 新增产品
 * @author: haiqingzheng 
 * @since: 2016年5月17日 上午9:06:30 
 * @history:
 */
public class XN601000 extends AProcessor {

    private IProductAO productAO = SpringContextHolder
        .getBean(IProductAO.class);

    private XN601000Req req = null;

    /** 
     * @see com.xnjr.mall.api.IProcessor#doBusiness()
     */
    @Override
    public Object doBusiness() throws BizException {
        Product data = new Product();
        data.setType(req.getType());
        data.setName(req.getName());
        data.setAdvTitle(req.getAdvTitle());
        data.setAdvPic(req.getAdvPic());
        data.setMajorPic(req.getMajorPic());
        data.setMajorText(req.getMajorText());
        data.setFamilyPic(req.getFamilyPic());
        data.setFamilyText(req.getFamilyText());
        data.setHighlightPic(req.getHighlightPic());
        data.setHighlighText(req.getHighlighText());
        data.setUpdater(req.getUpdater());
        return new PKCodeRes(productAO.addProduct(data));
    }

    /** 
     * @see com.xnjr.mall.api.IProcessor#doCheck(java.lang.String)
     */
    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN601000Req.class);
        StringValidater.validateBlank(req.getType(), req.getName(),
            req.getAdvTitle(), req.getAdvPic(), req.getMajorPic(),
            req.getMajorText(), req.getFamilyPic(), req.getFamilyText(),
            req.getHighlightPic(), req.getHighlighText(), req.getUpdater());
    }

}
