package com.cdkj.service.ao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.cdkj.service.bo.base.Paginable;
import com.cdkj.service.domain.Qualify;

@Component
public interface IQualifyAO {
    static final String DEFAULT_ORDER_COLUMN = "code";

    public String addQualify(Qualify data);

    public int dropQualify(String code);

    public int editQualify(Qualify data);

    public Paginable<Qualify> queryQualifyPage(int start, int limit,
            Qualify condition);

    public List<Qualify> queryQualifyList(Qualify condition);

    public Qualify getQualify(String code);

}
