package com.cdkj.service.bo;

import java.util.List;

import com.cdkj.service.bo.base.IPaginableBO;
import com.cdkj.service.domain.Qualify;



//CHECK ��鲢��ע�� 
public interface IQualifyBO extends IPaginableBO<Qualify> {


	public boolean isQualifyExist(String code);


	public String saveQualify(Qualify data);


	public int removeQualify(String code);


	public int refreshQualify(Qualify data);


	public List<Qualify> queryQualifyList(Qualify condition);


	public Qualify getQualify(String code);


}