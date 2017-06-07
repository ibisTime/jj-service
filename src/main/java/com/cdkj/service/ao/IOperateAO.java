package com.cdkj.service.ao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.cdkj.service.bo.base.Paginable;
import com.cdkj.service.domain.Operate;
import com.cdkj.service.dto.req.XN612110Req;
import com.cdkj.service.dto.req.XN612112Req;

@Component
public interface IOperateAO {
    static final String DEFAULT_ORDER_COLUMN = "code";

    public String addOperate(XN612110Req req);

    public void dropOperate(String code);

    public void editOperate(XN612112Req req);

    public Paginable<Operate> queryOperatePage(int start, int limit,
            Operate condition);

    public List<Operate> queryOperateList(Operate condition);

    public Operate getOperate(String code);

}
