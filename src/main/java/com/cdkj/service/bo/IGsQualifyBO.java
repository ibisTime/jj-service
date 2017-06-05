package com.cdkj.service.bo;

import java.util.List;

import com.cdkj.service.bo.base.IPaginableBO;
import com.cdkj.service.domain.GsQualify;



//CHECK ��鲢��ע�� 
public interface IGsQualifyBO extends IPaginableBO<GsQualify> {


	public boolean isGsQualifyExist(String code);


	public String saveGsQualify(GsQualify data);


	public int removeGsQualify(String code);


	public int refreshGsQualify(GsQualify data);


	public List<GsQualify> queryGsQualifyList(GsQualify condition);


	public GsQualify getGsQualify(String code);


}