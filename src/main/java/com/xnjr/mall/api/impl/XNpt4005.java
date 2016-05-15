/**
 * @Title XN803564.java 
 * @Package com.xnjr.moom.api.impl 
 * @Description 
 * @author xieyj  
 * @date 2016年3月6日 上午9:20:25 
 * @version V1.0   
 */
package com.xnjr.mall.api.impl;

import com.xnjr.mall.ao.IPTCompanyCardAO;
import com.xnjr.mall.api.AProcessor;
import com.xnjr.mall.common.DateUtil;
import com.xnjr.mall.core.StringValidater;
import com.xnjr.mall.domain.PTCompanyCard;
import com.xnjr.mall.dto.req.XNpt4005Req;
import com.xnjr.mall.dto.res.XNpt4005Res;
import com.xnjr.mall.exception.BizException;
import com.xnjr.mall.exception.ParaException;
import com.xnjr.mall.http.JsonUtils;
import com.xnjr.mall.spring.SpringContextHolder;

/** 
 * 更新最后一次流水时间
 * @author: xieyj 
 * @since: 2016年3月6日 上午9:20:26 
 * @history:
 */
public class XNpt4005 extends AProcessor {

    private IPTCompanyCardAO ptCompanyCardAO = SpringContextHolder
        .getBean(IPTCompanyCardAO.class);

    private XNpt4005Req req = null;

    /** 
     * @see com.xnjr.mall.api.IProcessor#doBusiness()
     */
    @Override
    public Object doBusiness() throws BizException {
        PTCompanyCard data = new PTCompanyCard();
        data.setCode(req.getCode());
        data.setJourDatetime(DateUtil.strToDate(req.getJourDatetime(),
            DateUtil.DATA_TIME_PATTERN_1));
        data.setUpdater(req.getUpdater());
        data.setRemark(req.getRemark());
        return new XNpt4005Res(ptCompanyCardAO.editJourDatePTCompanyCard(data));
    }

    /** 
     * @see com.xnjr.mall.api.IProcessor#doCheck(java.lang.String)
     */
    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtils.json2Bean(inputparams, XNpt4005Req.class);
        StringValidater.validateBlank(req.getCode(), req.getJourDatetime(),
            req.getUpdater());
    }

}
