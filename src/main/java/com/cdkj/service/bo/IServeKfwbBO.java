package com.cdkj.service.bo;

import java.util.List;

import com.cdkj.service.bo.base.IPaginableBO;
import com.cdkj.service.domain.ServeKfwb;

public interface IServeKfwbBO extends IPaginableBO<ServeKfwb> {

    public boolean isServeKfwbExist(String code);

    public String saveServeKfwb(ServeKfwb data);

    public int removeServeKfwb(String code);

    public int refreshServeKfwb(ServeKfwb data);

    public List<ServeKfwb> queryServeKfwbList(ServeKfwb condition);

    public ServeKfwb getServeKfwb(String code);

}
