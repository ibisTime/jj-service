package com.xnjr.mall.ao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xnjr.mall.ao.IGSStructureAO;
import com.xnjr.mall.bo.IGSStructureBO;
import com.xnjr.mall.bo.base.Paginable;
import com.xnjr.mall.domain.GSStructure;
import com.xnjr.mall.exception.BizException;

/**
 * 结构
 * @author: Gejin 
 * @since: 2016年4月13日 上午11:17:51 
 * @history:
 */
@Service
public class GSStructureAOImpl implements IGSStructureAO {

    @Autowired
    IGSStructureBO gsStructureBO;

    @Override
    public String addStructure(GSStructure data) {
        return gsStructureBO.saveStructure(data);
    }

    @Override
    public int editStructure(GSStructure data) {
        if (!gsStructureBO.isStructureExist(data.getCode())) {
            throw new BizException("gs0000", "修改结构不存在！");
        }
        return gsStructureBO.refreshStructure(data);
    }

    @Override
    public int dropStructure(String code) {
        if (!gsStructureBO.isStructureExist(code)) {
            throw new BizException("gs0000", "删除结构不存在！");
        }
        return gsStructureBO.removeStructure(code);
    }

    @Override
    public List<GSStructure> queryStructureList(GSStructure data) {
        return gsStructureBO.queryStructureList(data);
    }

    @Override
    public Paginable<GSStructure> queryStructurePage(int start, int limit,
            GSStructure data) {
        return gsStructureBO.getPaginable(start, limit, data);
    }

    @Override
    public GSStructure getStructure(String code) {
        if (!gsStructureBO.isStructureExist(code)) {
            throw new BizException("gs0000", "结构不存在！");
        }
        return gsStructureBO.getStructure(code);
    }

}
