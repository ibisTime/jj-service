package com.cdkj.service.bo;

import java.util.List;

import com.cdkj.service.bo.base.IPaginableBO;
import com.cdkj.service.domain.ServeCyy;

public interface IServeCyyBO extends IPaginableBO<ServeCyy> {

    public boolean isServeCyyExist(String code);

    public String saveServeCyy(ServeCyy data);

    public int removeServeCyy(String code);

    public int refreshServeCyy(ServeCyy data);

    public List<ServeCyy> queryServeCyyList(ServeCyy condition);

    public ServeCyy getServeCyy(String code);

}
