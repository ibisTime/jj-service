package com.cdkj.service.ao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.cdkj.service.bo.base.Paginable;
import com.cdkj.service.domain.GsQualify;

@Component
public interface IGsQualifyAO {
    static final String DEFAULT_ORDER_COLUMN = "code";

    public String addGsQualify(GsQualify data);

    public int dropGsQualify(String code);

    public int editGsQualify(GsQualify data);

    public Paginable<GsQualify> queryGsQualifyPage(int start, int limit,
            GsQualify condition);

    public List<GsQualify> queryGsQualifyList(GsQualify condition);

    public GsQualify getGsQualify(String code);

}
