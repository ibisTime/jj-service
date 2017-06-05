package com.cdkj.service.bo;

import java.util.List;

import com.cdkj.service.bo.base.IPaginableBO;
import com.cdkj.service.domain.Photo;



//CHECK ��鲢��ע�� 
public interface IPhotoBO extends IPaginableBO<Photo> {


	public boolean isPhotoExist(String code);


	public String savePhoto(Photo data);


	public int removePhoto(String code);


	public int refreshPhoto(Photo data);


	public List<Photo> queryPhotoList(Photo condition);


	public Photo getPhoto(String code);


}