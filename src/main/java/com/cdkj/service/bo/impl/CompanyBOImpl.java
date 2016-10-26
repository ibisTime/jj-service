package com.cdkj.service.bo.impl;

import org.springframework.stereotype.Component;

import com.cdkj.service.bo.ICompanyBO;
import com.cdkj.service.dto.req.XN806010Req;
import com.cdkj.service.dto.res.XN806010Res;
import com.cdkj.service.exception.BizException;
import com.cdkj.service.http.BizConnecter;
import com.cdkj.service.http.JsonUtils;

@Component
public class CompanyBOImpl implements ICompanyBO {

    @Override
    public XN806010Res getCompany(String companyCode) {
        XN806010Req req = new XN806010Req();
        req.setCode(companyCode);
        XN806010Res res = BizConnecter.getBizData("806010",
            JsonUtils.object2Json(req), XN806010Res.class);
        if (res == null) {
            throw new BizException("XN000000", "编号为" + companyCode + "的公司不存在");
        }
        return res;
    }

}
