package com.cdkj.service.api.converter;

import com.cdkj.service.domain.Resume;
import com.cdkj.service.dto.req.CD612060Req;
import com.cdkj.service.dto.req.CD612061Req;
import com.cdkj.service.dto.req.CD612070Req;

public class ResumeConverter {

    // 发布简历
    public static Resume converter(CD612060Req req) {
        Resume result = new Resume();
        result.setName(req.getName());
        result.setIsWork(req.getIsWork());
        result.setPreCompName(req.getPreCompName());
        result.setPrePosName(req.getPrePosName());
        result.setPreWorkTime(req.getPreWorkTime());
        result.setPreMsalary(req.getPreMsalary());
        result.setPreDescription(req.getPreDescription());
        result.setEducation(req.getEducation());
        result.setIsTz(req.getIsTz());
        result.setStudyTime(req.getStudyTime());
        result.setSchool(req.getSchool());
        result.setProfession(req.getProfession());
        result.setType(req.getType());
        result.setExpPosition(req.getExpPosition());
        result.setExpMsalary(req.getExpMsalary());
        result.setExpProvince(req.getExpProvince());
        result.setExpCity(req.getExpCity());
        result.setWorkStatus(req.getWorkStatus());
        result.setIsOpen(req.getIsOpen());
        result.setPublisher(req.getPublisher());
        return result;
    }

    // 修改简历
    public static Resume converter(CD612061Req req) {
        Resume result = new Resume();
        result.setCode(req.getCode());
        result.setName(req.getName());
        result.setIsWork(req.getIsWork());
        result.setPreCompName(req.getPreCompName());
        result.setPrePosName(req.getPrePosName());
        result.setPreWorkTime(req.getPreWorkTime());
        result.setPreMsalary(req.getPreMsalary());
        result.setPreDescription(req.getPreDescription());
        result.setEducation(req.getEducation());
        result.setIsTz(req.getIsTz());
        result.setStudyTime(req.getStudyTime());
        result.setSchool(req.getSchool());
        result.setProfession(req.getProfession());
        result.setType(req.getType());
        result.setExpPosition(req.getExpPosition());
        result.setExpMsalary(req.getExpMsalary());
        result.setExpProvince(req.getExpProvince());
        result.setExpCity(req.getExpCity());
        result.setWorkStatus(req.getWorkStatus());
        result.setIsOpen(req.getIsOpen());
        result.setPublisher(req.getPublisher());
        return result;
    }

    // 分页查询简历
    public static Resume converter(CD612070Req req) {
        Resume result = new Resume();
        result.setMobile(req.getMobile());
        result.setExpPosition(req.getExpPosition());
        result.setExpProvince(req.getExpProvince());
        result.setExpCity(req.getExpCity());
        result.setPublisher(req.getPublisher());
        result.setIsOpen(req.getIsOpen());
        return result;
    }
}
