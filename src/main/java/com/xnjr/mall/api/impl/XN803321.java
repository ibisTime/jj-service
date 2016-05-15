package com.xnjr.mall.api.impl;

import com.xnjr.mall.ao.IContractAO;
import com.xnjr.mall.api.AProcessor;
import com.xnjr.mall.common.JsonUtil;
import com.xnjr.mall.core.StringValidater;
import com.xnjr.mall.domain.Contract;
import com.xnjr.mall.dto.req.XN803321Req;
import com.xnjr.mall.dto.res.XN803321Res;
import com.xnjr.mall.exception.BizException;
import com.xnjr.mall.exception.ParaException;
import com.xnjr.mall.spring.SpringContextHolder;

/**
 * 合同查询：查询contract表:undo
 * @author: myb858 
 * @since: 2016年1月13日 上午11:01:18 
 * @history:
 */
public class XN803321 extends AProcessor {
    private IContractAO contractAO = SpringContextHolder
        .getBean(IContractAO.class);

    private XN803321Req req;

    @Override
    public Object doBusiness() throws BizException {
        XN803321Res res = new XN803321Res();
        Contract contract = contractAO.getContract(req.getContractNo());
        res.setCode(contract.getCode());
        res.setCompanyCode(contract.getCompanyCode());
        res.setSubjectCode(contract.getSubjectCode());
        res.setContent(contract.getContent());
        res.setType(contract.getType());
        res.setCreateDatetime(contract.getCreateDatetime());
        res.setRemark(contract.getRemark());
        res.setStatus(contract.getStatus());
        res.setEndDatetime(contract.getEndDatetime());
        return res;
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN803321Req.class);
        StringValidater.validateBlank(req.getContractNo());
    }

}
