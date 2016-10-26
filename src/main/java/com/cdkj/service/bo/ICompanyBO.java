package com.cdkj.service.bo;

import com.cdkj.service.dto.res.XN806010Res;

public interface ICompanyBO {

    /** 
     * 获取公司详情
     * @return 
     * @create: 2016年10月26日 下午2:06:07 zuixian
     * @history: 
     */
    public XN806010Res getCompany(String companyCode);
}
