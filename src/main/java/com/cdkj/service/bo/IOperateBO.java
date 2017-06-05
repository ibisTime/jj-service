package com.cdkj.service.bo;

import java.util.List;

import com.cdkj.service.bo.base.IPaginableBO;
import com.cdkj.service.domain.Operate;



//CHECK ��鲢��ע�� 
public interface IOperateBO extends IPaginableBO<Operate> {


	public boolean isOperateExist(String code);


	public String saveOperate(Operate data);


	public int removeOperate(String code);


	public int refreshOperate(Operate data);


	public List<Operate> queryOperateList(Operate condition);


	public Operate getOperate(String code);


}