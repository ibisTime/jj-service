package com.xnjr.mall.bo.impl;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.xnjr.mall.bo.IGSStructureBO;
import com.xnjr.mall.bo.base.Page;
import com.xnjr.mall.bo.base.Paginable;
import com.xnjr.mall.bo.base.PaginableBOImpl;
import com.xnjr.mall.core.OrderNoGenerater;
import com.xnjr.mall.dao.IGSStructureDAO;
import com.xnjr.mall.domain.GSStructure;

/**
 * 结构
 * @author: Gejin 
 * @since: 2016年4月13日 上午11:34:02 
 * @history:
 */
@Component
public class GSStructureBOImpl extends PaginableBOImpl<GSStructure> implements
        IGSStructureBO {

    @Autowired
    private IGSStructureDAO gsStructureDAO;

    @Override
    public Paginable<GSStructure> getPaginable(int start, int pageSize,
            GSStructure condition) {
        long totalCount = gsStructureDAO.selectTotalCount(condition);
        Paginable<GSStructure> page = new Page<GSStructure>(start, pageSize,
            totalCount);
        List<GSStructure> dataList = gsStructureDAO.selectList(condition,
            page.getStart(), page.getPageSize());
        page.setList(dataList);
        return page;
    }

    @Override
    public String saveStructure(GSStructure data) {
        String code = null;
        if (data != null) {
            code = OrderNoGenerater.generateM("JG");
            data.setCode(code);
            data.setUpdateDatetime(new Date());
            gsStructureDAO.insert(data);
        }
        return code;
    }

    @Override
    public int refreshStructure(GSStructure data) {
        int count = 0;
        if (data != null) {
            data.setUpdateDatetime(new Date());
            count = gsStructureDAO.updateStructure(data);
        }
        return count;
    }

    @Override
    public int removeStructure(String code) {
        int count = 0;
        if (StringUtils.isNotBlank(code)) {
            GSStructure data = new GSStructure();
            data.setCode(code);
            count = gsStructureDAO.delete(data);
        }
        return count;
    }

    @Override
    public List<GSStructure> queryStructureList(GSStructure data) {
        return gsStructureDAO.selectList(data);
    }

    @Override
    public GSStructure getStructure(String code) {
        GSStructure data = null;
        if (StringUtils.isNotBlank(code)) {
            GSStructure condition = new GSStructure();
            condition.setCode(code);
            data = gsStructureDAO.select(condition);
        }
        return data;
    }

    @Override
    public boolean isStructureExist(String code) {
        GSStructure structure = new GSStructure();
        structure.setCode(code);
        if (gsStructureDAO.selectTotalCount(structure) == 1) {
            return true;
        }
        return false;
    }

}
