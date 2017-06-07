package com.cdkj.service.bo;

import java.util.List;

import com.cdkj.service.bo.base.IPaginableBO;
import com.cdkj.service.domain.Operate;

public interface IOperateBO extends IPaginableBO<Operate> {

    public boolean isOperateExist(String code);

    public void saveOperate(Operate data);

    public void removeOperate(String code);

    public void refreshOperate(Operate data);

    public List<Operate> queryOperateList(Operate condition);

    public Operate getOperate(String code);

    public void wgclOperate(Operate operate, String dealer, String dealNote);

    public List<Operate> queryOperateList(String location, String orderNo);

    public void refreshLocation(Operate operate, String location,
            String orderNo, String dealer);

}
