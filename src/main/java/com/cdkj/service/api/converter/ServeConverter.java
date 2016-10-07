package com.cdkj.service.api.converter;

import com.cdkj.service.domain.Serve;
import com.cdkj.service.domain.ServePhoto;
import com.cdkj.service.dto.req.XN612000Req;

public class ServeConverter {

    public static ServePhoto converter(XN612000Req req) {
        ServePhoto result = new ServePhoto();
        Serve serve = new Serve();
        serve.setName(req.getName());
        serve.setCompanyCode(req.getCompanyCode());
        serve.setQuoteMin(Long.valueOf(req.getQuoteMin()));
        serve.setQuoteMax(Long.valueOf(req.getQuoteMax()));
        serve.setQualityCode(req.getQualityCode());
        result.setPyNum(Integer.valueOf(req.getPyNum()));
        result.setSysNum(Integer.valueOf(req.getSysNum()));
        result.setIsDz(req.getIsDz());
        result.setScpslm(req.getScpslm());
        result.setWorks(req.getWorks());
        serve.setDescription(req.getDescription());
        serve.setPublisher(req.getPublisher());
        result.setServe(serve);
        return result;
    }
}
