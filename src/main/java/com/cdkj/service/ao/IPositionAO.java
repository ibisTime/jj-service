package com.cdkj.service.ao;

import java.util.List;

import com.cdkj.service.bo.base.Paginable;
import com.cdkj.service.domain.Position;
import com.cdkj.service.dto.req.XN612150Req;
import com.cdkj.service.dto.req.XN612152Req;

public interface IPositionAO {
    static final String DEFAULT_ORDER_COLUMN = "code";

    public String addPosition(XN612150Req req);

    public void dropPosition(String code);

    public void editPosition(XN612152Req req);

    public void editPositionStatus(String code, String dealer, String dealNote);

    public void editPositionHot(String code, String location, String orderNo,
            String dealer);

    public void editPositionHotLocation(String code, String action);

    public Paginable<Position> queryPositionPage(int start, int limit,
            Position condition);

    public List<Position> queryPositionList(Position condition);

    public Position getPosition(String code);

}
