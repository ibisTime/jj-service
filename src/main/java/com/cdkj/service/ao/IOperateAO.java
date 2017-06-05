package com.cdkj.service.ao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.cdkj.service.bo.base.Paginable;
import com.cdkj.service.domain.Operate;

@Component
public interface IOperateAO {
    static final String DEFAULT_ORDER_COLUMN = "code";

    public String addOperate(Operate data);

    public int dropOperate(String code);

    public int editOperate(Operate data);

    public Paginable<Operate> queryOperatePage(int start, int limit,
            Operate condition);

    public List<Operate> queryOperateList(Operate condition);

    public Operate getOperate(String code);

}
