package com.cdkj.service.ao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdkj.service.ao.IPhotoAO;
import com.cdkj.service.bo.IPhotoBO;
import com.cdkj.service.bo.base.Paginable;
import com.cdkj.service.domain.Photo;
import com.cdkj.service.exception.BizException;



//CHECK ��鲢��ע�� 
@Service
public class PhotoAOImpl implements IPhotoAO {

	@Autowired
	private IPhotoBO photoBO;

	@Override
	public String addPhoto(Photo data) {
		return photoBO.savePhoto(data);
	}

	@Override
	public int editPhoto(Photo data) {
		if (!photoBO.isPhotoExist(data.getCode())) {
			throw new BizException("xn0000", "记录编号不存在");
		}
		return photoBO.refreshPhoto(data);
	}

	@Override
	public int dropPhoto(String code) {
		if (!photoBO.isPhotoExist(code)) {
			throw new BizException("xn0000", "记录编号不存在");
		}
		return photoBO.removePhoto(code);
	}

	@Override
	public Paginable<Photo> queryPhotoPage(int start, int limit,
			Photo condition) {
		return photoBO.getPaginable(start, limit, condition);
	}

	@Override
	public List<Photo> queryPhotoList(Photo condition) {
		return photoBO.queryPhotoList(condition);
	}

	@Override
	public Photo getPhoto(String code) {
		return photoBO.getPhoto(code);
	}
}