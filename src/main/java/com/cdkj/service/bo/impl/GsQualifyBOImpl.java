package com.cdkj.service.bo.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cdkj.service.bo.IGsQualifyBO;
import com.cdkj.service.bo.base.PaginableBOImpl;
import com.cdkj.service.core.EGeneratePrefix;
import com.cdkj.service.core.OrderNoGenerater;
import com.cdkj.service.dao.IGsQualifyDAO;
import com.cdkj.service.domain.GsQualify;
import com.cdkj.service.exception.BizException;

@Component
public class GsQualifyBOImpl extends PaginableBOImpl<GsQualify> implements
        IGsQualifyBO {

    @Autowired
    private IGsQualifyDAO gsQualifyDAO;

    @Override
    public boolean isGsQualifyExist(String code) {
        GsQualify condition = new GsQualify();
        condition.setCode(code);
        if (gsQualifyDAO.selectTotalCount(condition) > 0) {
            return true;
        }
        return false;
    }

    @Override
    public String saveGsQualify(GsQualify data) {
        String code = null;
        if (data != null) {
            code = OrderNoGenerater.generateM(EGeneratePrefix.GSQUALIFY
                .getCode());
            data.setCode(code);
            gsQualifyDAO.insert(data);
        }
        return code;
    }

    @Override
    public int removeGsQualify(String code) {
        int count = 0;
        if (StringUtils.isNotBlank(code)) {
            GsQualify data = new GsQualify();
            data.setCode(code);
            count = gsQualifyDAO.delete(data);
        }
        return count;
    }

    @Override
    public int refreshGsQualify(GsQualify data) {
        int count = 0;
        if (StringUtils.isNotBlank(data.getCode())) {
            count = gsQualifyDAO.update(data);
        }
        return count;
    }

    @Override
    public List<GsQualify> queryGsQualifyList(GsQualify condition) {
        return gsQualifyDAO.selectList(condition);
    }

    @Override
    public GsQualify getGsQualify(String code) {
        GsQualify data = null;
        if (StringUtils.isNotBlank(code)) {
            GsQualify condition = new GsQualify();
            condition.setCode(code);
            data = gsQualifyDAO.select(condition);
            if (data == null) {
                throw new BizException("xn0000", "�� ��Ų�����");
            }
        }
        return data;
    }
}
