package com.cdkj.service.bo.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cdkj.service.bo.IServePhotoBO;
import com.cdkj.service.bo.base.PaginableBOImpl;
import com.cdkj.service.dao.IServePhotoDAO;
import com.cdkj.service.domain.ServePhoto;
import com.cdkj.service.exception.BizException;

//CHECK ��鲢��ע�� 
@Component
public class ServePhotoBOImpl extends PaginableBOImpl<ServePhoto> implements
        IServePhotoBO {

    @Autowired
    private IServePhotoDAO servePhotoDAO;

    @Override
    public boolean isServePhotoExist(String code) {
        ServePhoto condition = new ServePhoto();
        condition.setServeCode(code);
        if (servePhotoDAO.selectTotalCount(condition) > 0) {
            return true;
        }
        return false;
    }

    @Override
    public String saveServePhoto(ServePhoto data) {
        String code = null;
        if (data != null) {
            servePhotoDAO.insert(data);
        }
        return code;
    }

    @Override
    public int removeServePhoto(String code) {
        int count = 0;
        if (StringUtils.isNotBlank(code)) {
            ServePhoto data = new ServePhoto();
            data.setServeCode(code);
            count = servePhotoDAO.delete(data);
        }
        return count;
    }

    @Override
    public int refreshServePhoto(ServePhoto data) {
        int count = 0;
        if (StringUtils.isNotBlank(data.getServeCode())) {
            count = servePhotoDAO.update(data);
        }
        return count;
    }

    @Override
    public List<ServePhoto> queryServePhotoList(ServePhoto condition) {
        return servePhotoDAO.selectList(condition);
    }

    @Override
    public ServePhoto getServePhoto(String code) {
        ServePhoto data = null;
        if (StringUtils.isNotBlank(code)) {
            ServePhoto condition = new ServePhoto();
            condition.setServeCode(code);
            data = servePhotoDAO.select(condition);
            if (data == null) {
                throw new BizException("xn0000", "该编号不存在");
            }
        }
        return data;
    }
}
