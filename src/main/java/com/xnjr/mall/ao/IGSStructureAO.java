package com.xnjr.mall.ao;

import java.util.List;

import com.xnjr.mall.bo.base.Paginable;
import com.xnjr.mall.domain.GSStructure;
import com.xnjr.mall.spring.ServiceModule;

@ServiceModule
public interface IGSStructureAO {

    String DEFAULT_ORDER_COLUMN = "code";

    public String addStructure(GSStructure data);

    public int editStructure(GSStructure data);

    public int dropStructure(String code);

    public List<GSStructure> queryStructureList(GSStructure data);

    public Paginable<GSStructure> queryStructurePage(int start, int limit,
            GSStructure data);

    public GSStructure getStructure(String code);
}
