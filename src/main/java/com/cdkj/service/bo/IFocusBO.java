package com.cdkj.service.bo;

import java.util.List;

import com.cdkj.service.bo.base.IPaginableBO;
import com.cdkj.service.domain.Focus;



//CHECK ��鲢��ע�� 
public interface IFocusBO extends IPaginableBO<Focus> {


	public boolean isFocusExist(String code);


	public String saveFocus(Focus data);


	public int removeFocus(String code);


	public int refreshFocus(Focus data);


	public List<Focus> queryFocusList(Focus condition);


	public Focus getFocus(String code);


}