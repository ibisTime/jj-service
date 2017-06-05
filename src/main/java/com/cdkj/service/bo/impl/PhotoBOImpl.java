package com.cdkj.service.bo.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cdkj.service.bo.IPhotoBO;
import com.cdkj.service.bo.base.PaginableBOImpl;
import com.cdkj.service.core.EGeneratePrefix;
import com.cdkj.service.core.OrderNoGenerater;
import com.cdkj.service.dao.IPhotoDAO;
import com.cdkj.service.domain.Photo;
import com.cdkj.service.exception.BizException;

@Component
public class PhotoBOImpl extends PaginableBOImpl<Photo> implements IPhotoBO {

    @Autowired
    private IPhotoDAO photoDAO;

    @Override
    public boolean isPhotoExist(String code) {
        Photo condition = new Photo();
        condition.setCode(code);
        if (photoDAO.selectTotalCount(condition) > 0) {
            return true;
        }
        return false;
    }

    @Override
    public String savePhoto(Photo data) {
        String code = null;
        if (data != null) {
            code = OrderNoGenerater.generateM(EGeneratePrefix.PHOTO.getCode());
            data.setCode(code);
            photoDAO.insert(data);
        }
        return code;
    }

    @Override
    public int removePhoto(String code) {
        int count = 0;
        if (StringUtils.isNotBlank(code)) {
            Photo data = new Photo();
            data.setCode(code);
            count = photoDAO.delete(data);
        }
        return count;
    }

    @Override
    public int refreshPhoto(Photo data) {
        int count = 0;
        if (StringUtils.isNotBlank(data.getCode())) {
            count = photoDAO.update(data);
        }
        return count;
    }

    @Override
    public List<Photo> queryPhotoList(Photo condition) {
        return photoDAO.selectList(condition);
    }

    @Override
    public Photo getPhoto(String code) {
        Photo data = null;
        if (StringUtils.isNotBlank(code)) {
            Photo condition = new Photo();
            condition.setCode(code);
            data = photoDAO.select(condition);
            if (data == null) {
                throw new BizException("xn0000", "�� ��Ų�����");
            }
        }
        return data;
    }
}
