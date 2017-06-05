package com.cdkj.service.ao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.cdkj.service.bo.base.Paginable;
import com.cdkj.service.domain.Qualify;

@Component
public interface IQualifyAO {
    static final String DEFAULT_ORDER_COLUMN = "code";

    public void editQualify(String code, String type, String name,
            String description, String updater, String remark);

    public Paginable<Qualify> queryQualifyPage(int start, int limit,
            Qualify condition);

    public List<Qualify> queryQualifyList(Qualify condition);

    public Qualify getQualify(String code);

}
