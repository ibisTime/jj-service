package com.cdkj.service.api.converter;

import com.cdkj.service.core.StringValidater;
import com.cdkj.service.domain.Position;
import com.cdkj.service.dto.req.XN612150Req;
import com.cdkj.service.dto.req.XN612152Req;

public class PositionConverter {

    // 发布职位
    public static Position converter(XN612150Req req) {
        Position result = new Position();
        result.setName(req.getName());
        result.setKind(req.getKind());
        result.setProvince(req.getProvince());
        result.setCity(req.getCity());
        result.setExperience(req.getExperience());
        result.setEducation(req.getEducation());
        result.setType(req.getType());
        result.setJobNum(StringValidater.toInteger(req.getJobNum()));
        result.setMsalary(req.getMsalary());
        result.setDescription(req.getDescription());
        result.setCompanyCode(req.getCompanyCode());
        result.setPublisher(req.getPublisher());
        return result;
    }

    // 修改职位
    public static Position converter(XN612152Req req) {
        Position result = new Position();
        result.setCode(req.getCode());
        result.setName(req.getName());
        result.setKind(req.getKind());
        result.setProvince(req.getProvince());
        result.setCity(req.getCity());
        result.setExperience(req.getExperience());
        result.setEducation(req.getEducation());
        result.setType(req.getType());
        result.setJobNum(StringValidater.toInteger(req.getJobNum()));
        result.setMsalary(req.getMsalary());
        result.setDescription(req.getDescription());
        result.setCompanyCode(req.getCompanyCode());
        result.setPublisher(req.getPublisher());
        return result;
    }

}
