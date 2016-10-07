package com.cdkj.service.bo;

import java.util.List;

import com.cdkj.service.bo.base.IPaginableBO;
import com.cdkj.service.domain.ServeCp;

public interface IServeCpBO extends IPaginableBO<ServeCp> {

    public boolean isServeCpExist(String code);

    public String saveServeCp(ServeCp data);

    public int removeServeCp(String code);

    public int refreshServeCp(ServeCp data);

    public List<ServeCp> queryServeCpList(ServeCp condition);

    public ServeCp getServeCp(String code);

}
