package com.cdkj.service.ao;

import java.util.List;

import com.cdkj.service.bo.base.Paginable;
import com.cdkj.service.domain.Position;

public interface IPositionAO {
    static final String DEFAULT_ORDER_COLUMN = "code";

    public String addPosition(Position data);

    public int dropPosition(String code);

    public int editPosition(Position data);

    public int editPositionStatus(String code, String dealer, String dealNote);

    public int editPositionHot(String code, String isHot, String orderNo,
            String dealer);

    public int editPositionHotLocation(String code, String action);

    public Paginable<Position> queryPositionPage(int start, int limit,
            Position condition);

    public List<Position> queryPositionList(Position condition);

    public Position getPosition(String code);

}
